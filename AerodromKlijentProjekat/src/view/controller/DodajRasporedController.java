/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import communication.Communication;
import domain.Avion;
import domain.Destinacija;
import domain.Let;
import domain.Raspored;
import domain.StavkaRasporeda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmDodajDestinaciju;
import view.form.FrmDodajRaspored;
import view.form.components.table.AvionTableModel;
import view.form.components.table.StavkeTableModel;
import view.form.mode.FrmMode;

/**
 *
 * @author Nikola
 */
public class DodajRasporedController {
    
    private final FrmDodajRaspored frm;
    Date datum;
    StavkeTableModel atm;
    
    public DodajRasporedController(view.form.FrmDodajRaspored frmDodajRaspored) {
        this.frm = frmDodajRaspored;
        addActionListener();
    }
    
    public void openForm(FrmMode mode) {
        prepareView(mode);
        
        frm.setVisible(true);
        
    }
    
    public void prepareView(FrmMode mode) {
        
        atm = new StavkeTableModel(new ArrayList<>());
        frm.getTblStavke().setModel(atm);
        try {
            fillCbLet();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            
        }
        
        prepareMode(mode);
        
    }
    
    private void prepareMode(FrmMode mode) {
        switch (mode) {
            case ADD:
                
                frm.getBtnObrisi().setVisible(false);
                frm.getBtnIzmeni().setVisible(false);
                break;
            case EDIT:
                
                frm.getBtnKreiraj().setVisible(false);
                frm.getTxtRaspored().setVisible(false);
                frm.getLblRaspored().setVisible(false);
                Raspored m = (Raspored) ViewCoordinator.getInstance().getParam("Raspored");
                
                try {
                    List<StavkaRasporeda> stavke = Communication.getInstance().nadjiStavke(new StavkaRasporeda(Long.valueOf(0), m.getRasporedId(), "", null));
                    for (StavkaRasporeda st : stavke) {
                        System.out.println(st);
                        atm.dodajStavku(st);
                    }
                    
                } catch (Exception ex) {
                    System.out.println("Greska pri nalazenju stavki" + ex.getMessage());
                }
                
                break;
            
        }
    }
    
    private void fillCbLet() throws Exception {
        List<Let> list = Communication.getInstance().vratiListuLetova();
        for (Let d : list) {
            System.out.println(d);
            frm.getCbLet().addItem(d);
            
        }
    }
    
    private void addActionListener() {
        frm.dodajBtnKreirajRaspored(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    validacijaDatuma();
                    validacijaVremena(frm.getTxtVreme().getText().trim());
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    Date datum = sdf.parse(frm.getTxtRaspored().getText().trim());
                    Communication.getInstance().zapamtiRaspored(new Raspored(Long.valueOf(0), datum, atm.vratiStavke()));
                    JOptionPane.showMessageDialog(frm, "Raspored uspesno kreiran!");
                    
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frm, "Server zatvoren: " + se.getMessage());
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "Neuspesno kreiranje destinacije: " + e.getMessage());
                    if (e.getMessage().equals("SERVER zatvoren")) {
                        System.exit(0);
                    }
                }
            }
        });
        
        frm.dodajBtnDodajStavku(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    validacijaVremena(frm.getTxtVreme().getText().trim());
                    StavkaRasporeda sr = new StavkaRasporeda();
                    sr.setId(Long.valueOf(0));
                    sr.setLet((Let) frm.getCbLet().getSelectedItem());
                    sr.setVreme(frm.getTxtVreme().getText().trim());
                    sr.setrBr(Long.valueOf(frm.getTblStavke().getRowCount() + 1));
                    atm.dodajStavku(sr);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "Neuspesno dodavanje stavke: " + e.getMessage());
                    if (e.getMessage().equals("SERVER zatvoren")) {
                        System.exit(0);
                    }
                }
            }
        });
        
        frm.dodajBtnObrisiStavku(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                atm.izbaciStavku(frm.getTblStavke().getSelectedRow());
                
            }
        });
        
        frm.dodajBtnIzmeniRaspored(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                validacijaVremena(frm.getTxtVreme().getText().trim());
                Raspored r = (Raspored) ViewCoordinator.getInstance().getParam("Raspored");
                r.getStavke().addAll(atm.vratiStavke());
                try {
                    Communication.getInstance().izmeniRaspored(r);
                } catch (Exception e) {
                    System.out.println("Greska pri izmeni rasporeda: " + e.getMessage());
                }
                
            }
        });
    }
    
    private void validacijaDatuma() throws Exception {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
        try {
            datum = df.parse(frm.getTxtRaspored().getText().trim());
        } catch (ParseException ex) {
            throw new Exception("Datum mora biti u formatu: dd.MM.yyyy.");
        }
        
        if (!"".equals(frm.getTxtRaspored().getText().trim())) {
            try {
                datum = df.parse(frm.getTxtRaspored().getText().trim());
            } catch (ParseException ex) {
                throw new Exception("Datum mora biti u formatu: dd.MM.yyyy.");
            }
        } else {
            datum = null;
        }
        
    }
    
    public void validacijaVremena(String time) throws IllegalArgumentException {
        if (time == null || time.length() != 5) {
            throw new IllegalArgumentException("Vreme mora biti u formatu: HH:MM");
        }
        
        char[] timeChars = time.toCharArray();

        // Validate the hour part
        if (!validacijaSata(timeChars[0], timeChars[1])) {
            throw new IllegalArgumentException("Vreme mora biti u formatu: HH:MM");
        }

        // Validate the minute part
        if (!validacijaMinuta(timeChars[3], timeChars[4])) {
            throw new IllegalArgumentException("Vreme mora biti u formatu: HH:MM");
        }

        // Validate the separator
        if (timeChars[2] != ':') {
            throw new IllegalArgumentException("Vreme mora biti u formatu: HH:MM");
        }
    }
    
    private boolean validacijaSata(char desetica, char jedinica) {
        int sat = Character.getNumericValue(desetica) * 10 + Character.getNumericValue(jedinica);
        return sat >= 0 && sat <= 23;
    }
    
    private boolean validacijaMinuta(char desetica, char jedinica) {
        int minut = Character.getNumericValue(desetica) * 10 + Character.getNumericValue(jedinica);
        return minut >= 0 && minut <= 59;
    }
    
}
