/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import communication.Communication;
import domain.Avion;
import domain.Destinacija;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmDodajAvion;
import view.form.FrmDodajDestinaciju;

/**
 *
 * @author Nikola
 */
public class DodajDestinacijuController {

    private final FrmDodajDestinaciju frm;

    public DodajDestinacijuController(view.form.FrmDodajDestinaciju frmDodajDestinaciju) {
        this.frm = frmDodajDestinaciju;
        addActionListener();

    }

    public void openForm() {
        frm.setVisible(true);
    }

    private void addActionListener() {
        frm.dodajBtnDodajDestinaciju(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String nazivDestinacije = frm.getTxtNaziv().getText().trim();
                    String drzava = frm.getTxtDrzava().getText().trim();
                    Communication.getInstance().zapamtiDestinaciju(new Destinacija(0, nazivDestinacije, drzava));
                    JOptionPane.showMessageDialog(frm, "Destinacija uspesno kreirana!");
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

        frm.dodajBtnObrisiDestinaciju(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    if (frm.getTxtNaziv().getText().trim().equals("") || frm.getTxtDrzava().getText().trim().equals("")) {
                        JOptionPane.showMessageDialog(frm, "Text fields can't be empty!");
                        return;
                    }
                    Destinacija m = new Destinacija();
                    m.setNazivDestinacije(frm.getTxtNaziv().getText().trim());
                    m.setDrzava(frm.getTxtDrzava().getText().trim());

                    Destinacija d = (Communication.getInstance().nadjiDestinacije(m)).get(0);

                    int answer = JOptionPane.showConfirmDialog(frm, "Do you really want to delete this dest?");
                    if (answer != 0) {
                        return;
                    }
                    Communication.getInstance().obrisiDestinaciju(d);

                    JOptionPane.showMessageDialog(frm, "Dest deleted successfully!");
                    frm.dispose();
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frm, "Server is closed, Goodbye");
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "Neuspesno brisanje destinacije: " + e.getMessage());
                }
            }
        }
        );
    }

}
