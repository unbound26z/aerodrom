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
                    StavkaRasporeda sr = new StavkaRasporeda();
                    sr.setId(Long.valueOf(0));
                    sr.setLet((Let) frm.getCbLet().getSelectedItem());
                    sr.setVreme(frm.getTxtVreme().getText().trim());
                    sr.setrBr(Long.valueOf(frm.getTblStavke().getRowCount() + 1));
                    atm.dodajStavku(sr);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "Neuspesno kreiranje stavke: " + e.getMessage());
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

    private void validateDates() throws Exception {
//        DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
//        try {
//            datum = df.parse(frm.getTblStavke().getText().trim());
//        } catch (ParseException ex) {
//            throw new Exception("Date need to be in format: dd.MM.yyyy.");
//        }
//
//        if (!"".equals(frmTask.getTxtStartDate().getText().trim())) {
//            try {
//                startDate = df.parse(frmTask.getTxtStartDate().getText().trim());
//            } catch (ParseException ex) {
//                throw new Exception("Date need to be in format: dd.MM.yyyy.");
//            }
//        } else {
//            startDate = null;
//        }
//        if ("".equals(frmTask.getTxtFinishDate().getText().trim())) {
//            finishDate = null;
//        } else {
//            try {
//                finishDate = df.parse(frmTask.getTxtFinishDate().getText().trim());
//            } catch (ParseException ex) {
//                throw new Exception("Date need to be in format: dd.MM.yyyy.");
//            }
//        }
//    }

    }
}
