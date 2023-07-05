/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import communication.Communication;
import domain.Avion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.util.Date;
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmDodajAvion;
import view.form.FrmDodajPilota;

/**
 *
 * @author Nikola
 */
public class DodajPilotaController {

    private final FrmDodajPilota frm;

    public DodajPilotaController(view.form.FrmDodajPilota frm) {
        this.frm = frm;
        addActionListener();

    }

    public void openForm() {
        frm.setVisible(true);
    }

    private void addActionListener() {
//        frm.dodajBtnDodajPilota(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                try {
//                    String ime = frm.getTxtIme().getText().trim();
//                    String prezime = frm.getTxtPrezime().getText().trim();
//                    int radniStaz = Integer.parseInt(frm.getTxtRadniStaz().getText().trim());
//                    //TODO: Popravi ako treba
//                    Date datum = new Date(frm.getTxtDatum().getText().trim());
//                  
//                    Communication.getInstance().za(new Avion(new Long(0), name, brojSedista, mestoProizvodnje, godinaProizvodnje, aviokompanija));
//                    JOptionPane.showMessageDialog(frm, "Avion uspesno kreiran!");
//                    ViewCoordinator.getInstance().refreshAvionView();
//                } catch (SocketException se) {
//                    JOptionPane.showMessageDialog(frm, "Server zatvoren: " + se.getMessage());
//                    System.exit(0);
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(frm, "Neuspesno kreiranje aviona: " + e.getMessage());
//                    if (e.getMessage().equals("SERVER zatvoren")) {
//                        System.exit(0);
//                    }
//                }
//            }
//        });
    }

}
