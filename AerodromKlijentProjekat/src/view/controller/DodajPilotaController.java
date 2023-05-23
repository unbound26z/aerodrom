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
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmDodajLet;
import view.form.FrmDodajPilota;

/**
 *
 * @author Nikola
 */


//Unneeded?
public class DodajPilotaController {

    private final FrmDodajPilota frm;

    public DodajPilotaController(view.form.FrmDodajPilota frmDodajPilota) {
        this.frm = frmDodajPilota;
    }

    public void openForm() {
        frm.setVisible(true);
    }

    private void addActionListener() {
        frm.dodajBtnDodajPilota(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    int cena = Integer.parseInt(frm.getTxtCena().getText().trim());
                    int trajanje = Integer.parseInt(frm.getTxtTrajanje().getText().trim());
                    Destinacija mestoPolaska = (Destinacija) frm.getCbPolazak().getSelectedItem();
                    Destinacija mestoDolaska = (Destinacija) frm.getCbDolazak().getSelectedItem();
                    Avion avion = (Avion) frm.getCbAvion().getSelectedItem();
                    Pilot pilot = (Pilot) frm.getCbPilot().getSelectedItem();

                    Communication.getInstance().zapa(new Let(0, trajanje, cena, mestoPolaska, avion, mestoDolaska, pilot));
                    JOptionPane.showMessageDialog(frm, "Let uspesno kreiran!");
                    ViewCoordinator.getInstance().refreshTaskGroupsView();
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
}
