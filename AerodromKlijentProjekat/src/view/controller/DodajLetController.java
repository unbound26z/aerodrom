/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import communication.Communication;
import domain.Avion;
import domain.Destinacija;
import domain.Let;
import domain.Pilot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.util.List;
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmDodajDestinaciju;
import view.form.FrmDodajLet;
import view.form.mode.FrmMode;

/**
 *
 * @author Nikola
 */
public class DodajLetController {
    
    private final FrmDodajLet frm;
    
    public DodajLetController(view.form.FrmDodajLet frmDodajLet) {
        this.frm = frmDodajLet;
        addActionListener();
        
    }
    
    public void openForm(FrmMode frmMode) {
        
        prepareView(frmMode);
        frm.setVisible(true);
    }
    
    private void addActionListener() {
        frm.dodajBtnDodajLet(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    validacija();
                    int cena = Integer.parseInt(frm.getTxtCena().getText().trim());
                    int trajanje = Integer.parseInt(frm.getTxtTrajanje().getText().trim());
                    Destinacija mestoPolaska = (Destinacija) frm.getCbPolazak().getSelectedItem();
                    Destinacija mestoDolaska = (Destinacija) frm.getCbDolazak().getSelectedItem();
                    Avion avion = (Avion) frm.getCbAvion().getSelectedItem();
                    Pilot pilot = (Pilot) frm.getCbPilot().getSelectedItem();
                    
                    Communication.getInstance().zapamtiLet(new Let(Long.valueOf(0), trajanje, cena, mestoPolaska, avion, mestoDolaska, pilot));
                    JOptionPane.showMessageDialog(frm, "Let uspesno kreiran!");
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frm, "Server zatvoren: " + se.getMessage());
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "Neuspesno kreiranje leta: " + e.getMessage());
                    if (e.getMessage().equals("SERVER zatvoren")) {
                        System.exit(0);
                    }
                }
            }
        });
        
        frm.dodajBtnIzmeniLet(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    validacija();
                    if (frm.getTxtCena().getText().trim().equals("") || frm.getTxtTrajanje().getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(frm, "Polja ne smeju biti prazna!");
                        return;
                    }
                    
                    Let m = new Let();
                    
                    int cena = Integer.parseInt(frm.getTxtCena().getText().trim());
                    int trajanje = Integer.parseInt(frm.getTxtTrajanje().getText().trim());
                    
                    Long id = ((Let) ViewCoordinator.getInstance().getParam("Let")).getLetId();
                    m.setId(id);
                    m.setCena(cena);
                    m.setTrajanje(trajanje);
                    Communication.getInstance().izmeniLet(m);
                    ViewCoordinator.getInstance().refreshLetView();
                    JOptionPane.showMessageDialog(frm, "Let izmenjen!");
                    frm.dispose();
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frm, "Server je zatvoren");
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "Neuspesna izmena leta: " + e.getMessage());
                }
            }
        });
    }
    
    private void prepareView(FrmMode mode) {
        try {
            
            fillCbPolazak();
            fillCbAvion();
            fillCbPilot();
            prepareMode(mode);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    private void prepareMode(FrmMode mode) {
        switch (mode) {
            case ADD:
                frm.getBtnIzmeni().setVisible(false);
                break;
            case EDIT:
                frm.getBtnDodaj().setVisible(false);
                Let m = (Let) ViewCoordinator.getInstance().getParam("Let");
                frm.getTxtCena().setText(String.valueOf(m.getCena()));
                frm.getTxtTrajanje().setText(String.valueOf(m.getTrajanje()));
                frm.getCbPolazak().setVisible(false);
                frm.getCbDolazak().setVisible(false);
                frm.getCbAvion().setVisible(false);
                frm.getCbPilot().setVisible(false);
                frm.getLblAvion().setVisible(false);
                frm.getLblMestoDolaska().setVisible(false);
                frm.getLblMestoPolaska().setVisible(false);
                frm.getLblPilot().setVisible(false);
                break;
        }
    }
    
    private void fillCbPolazak() throws Exception {
        List<Destinacija> list = Communication.getInstance().vratiListuDestinaicja();
        for (Destinacija d : list) {
            System.out.println(d.getNazivDestinacije());
            frm.getCbPolazak().addItem(d);
            frm.getCbDolazak().addItem(d);
        }
    }
    
    private void fillCbAvion() throws Exception {
        List<Avion> list = Communication.getInstance().vratiListuAviona();
        for (Avion d : list) {
            System.out.println(d.getNazivAviona());
            frm.getCbAvion().addItem(d);
        }
    }
    
    private void fillCbPilot() throws Exception {
        List<Pilot> list = Communication.getInstance().vratiListuPilota();
        for (Pilot d : list) {
            System.out.println(d.getPrezime());
            frm.getCbPilot().addItem(d);
        }
    }
    
    private void validacija() throws Exception {
        if (frm.getTxtCena().getText().isEmpty()
                | frm.getTxtTrajanje().getText().isEmpty()) {
            throw new Exception("Ne sme ostati prazno polje!");
        }
        
    }
    
}
