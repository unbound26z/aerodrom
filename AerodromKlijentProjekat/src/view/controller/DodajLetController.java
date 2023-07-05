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
        prepareView(FrmMode.ADD);
    }

    public void openForm() {
        frm.setVisible(true);
    }

    private void addActionListener() {
        frm.dodajBtnDodajLet(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
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
    }

    private void prepareView(FrmMode mode) {
        try {

            fillCbPolazak();
            fillCbAvion();
            fillCbPilot();
        } catch (Exception e) {
            System.out.println(e.getMessage());
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

}
