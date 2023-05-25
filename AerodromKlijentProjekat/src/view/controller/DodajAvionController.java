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
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmDodajAvion;

/**
 *
 * @author Nikola
 */
public class DodajAvionController {

    private final FrmDodajAvion frmDodajAvion;

    public DodajAvionController(view.form.FrmDodajAvion frmDodajAvion) {
        this.frmDodajAvion = frmDodajAvion;
        addActionListener();

    }

    public void openForm() {
        frmDodajAvion.setVisible(true);
    }

    private void addActionListener() {
        frmDodajAvion.dodajBtnDodajAvion(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String name = frmDodajAvion.getTxtNaziv().getText().trim();
                    int brojSedista = Integer.parseInt(frmDodajAvion.getTxtBrojSedista().getText().trim());
                    String mestoProizvodnje = frmDodajAvion.getTxtMestoProizvodnje().getText().trim();
                    int godinaProizvodnje = Integer.parseInt(frmDodajAvion.getTxtGodinaProizvodnje().getText().trim());
                    String aviokompanija = frmDodajAvion.getTxtAviokompanija().getText().trim();
                    Communication.getInstance().zapamtiAvion(new Avion(0, name, brojSedista, mestoProizvodnje, godinaProizvodnje, aviokompanija));
                    JOptionPane.showMessageDialog(frmDodajAvion, "Avion uspesno kreiran!");
                    ViewCoordinator.getInstance().refreshAvionView();
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frmDodajAvion, "Server zatvoren: " + se.getMessage());
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frmDodajAvion, "Neuspesno kreiranje aviona: " + e.getMessage());
                    if (e.getMessage().equals("SERVER zatvoren")) {
                        System.exit(0);
                    }
                }
            }
        });
    }

}
