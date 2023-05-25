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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
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
    Date datum;

    public DodajRasporedController(view.form.FrmDodajRaspored frmDodajRaspored) {
        this.frm = frmDodajRaspored;
        addActionListener();

    }

    public void openForm() {
        frm.setVisible(true);
    }

    private void addActionListener() {
        frm.dodajBtnKreirajRaspored(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy.");

                    LocalDate datum
                            = Communication.getInstance().zapamtiRaspored(new Raspored(0, datum));
                    JOptionPane.showMessageDialog(frm, "Destinacija uspesno kreirana!");
                    //TODO: Refresh raspored view
//                    ViewCoordinator.getInstance().ref();
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

    private void validateDates() throws Exception {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy.");
        try {
            datum = df.parse(frm.getTblStavke().getText().trim());
        } catch (ParseException ex) {
            throw new Exception("Date need to be in format: dd.MM.yyyy.");
        }

        if (!"".equals(frmTask.getTxtStartDate().getText().trim())) {
            try {
                startDate = df.parse(frmTask.getTxtStartDate().getText().trim());
            } catch (ParseException ex) {
                throw new Exception("Date need to be in format: dd.MM.yyyy.");
            }
        } else {
            startDate = null;
        }
        if ("".equals(frmTask.getTxtFinishDate().getText().trim())) {
            finishDate = null;
        } else {
            try {
                finishDate = df.parse(frmTask.getTxtFinishDate().getText().trim());
            } catch (ParseException ex) {
                throw new Exception("Date need to be in format: dd.MM.yyyy.");
            }
        }
    }

}
