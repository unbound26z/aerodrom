/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import communication.Communication;
import domain.Destinacija;
import domain.Raspored;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmDodajDestinaciju;
import view.form.FrmDodajRaspored;

/**
 *
 * @author Nikola
 */
public class DodajRasporedController {
     private final FrmDodajRaspored frm;

    public DodajRasporedController(view.form.FrmDodajRaspored frmDodajRaspored) {
        this.frm = frmDodajRaspored;
    }

    public void openForm() {
        frm.setVisible(true);
    }

    private void addActionListener() {
        frm.dodajBtnKreirajRaspored(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    LocalDate datum = 
                    Communication.getInstance().zapamtiRaspored(new Raspored(0, datum));
                    JOptionPane.showMessageDialog(frm, "Destinacija uspesno kreirana!");
                    ViewCoordinator.getInstance().refreshTaskGroupsView();
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
    }
}
