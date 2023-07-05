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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import view.coordinator.ViewCoordinator;
import view.form.FrmAvion;
import view.form.components.table.AvionTableModel;

/**
 *
 * @author Nikola
 */
public class AvionController {

    private final FrmAvion frmAvion;

    public AvionController(FrmAvion frmAvion) {
        this.frmAvion = frmAvion;
        addActionListener();
    }

    public void openForm() {
        prepareView();
        frmAvion.setVisible(true);

    }

    public FrmAvion getFrmAvion() {
        return frmAvion;
    }

    public void prepareView() {
        List<Avion> avioni = new ArrayList<>();
        try {
            avioni = Communication.getInstance().vratiListuAviona();
        } catch (SocketException se) {
            JOptionPane.showMessageDialog(frmAvion, "Server zatvoren");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmAvion, "Error: " + ex.getMessage());
        }
        AvionTableModel atm = new AvionTableModel(avioni);
        frmAvion.getTblAvion().setModel(atm);
  

    }

    private void addActionListener() {
        frmAvion.dodajBtnNadjiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String naziv = frmAvion.getTxtAvion().getText().trim();
                if (naziv.equals("")) {
                    prepareView();
                    return;
                }
                try {
                    Avion avion = new Avion(new Long(0), null, 0, null, 0, null);
                    avion.setNazivAviona(naziv);
                    List<Avion> avioni = Communication.getInstance().nadjiAvione(avion);
                    if (avioni.isEmpty()) {
                        JOptionPane.showMessageDialog(frmAvion, "Ne postoji takav avion!");
                        return;
                    }
                    AvionTableModel atm = new AvionTableModel(avioni);
                    frmAvion.getTblAvion().setModel(atm);
                    TableColumn column = frmAvion.getTblAvion().getColumnModel().getColumn(2);
                    column.setPreferredWidth(200);
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frmAvion, "Server zatvoren");
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frmAvion, "Greska pri trazenju aviona: " + e.getMessage());

                }
            }
        });

    }

    public void refreshTable() {
        List<Avion> avioni = new ArrayList<>();
        try {
            avioni = Communication.getInstance().vratiListuAviona();
        } catch (SocketException se) {
            JOptionPane.showMessageDialog(frmAvion, "Server is closed, Goodbye");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frmAvion, "Error: " + ex.getMessage());
        }
        AvionTableModel tm = new AvionTableModel(avioni);
        frmAvion.getTblAvion().setModel(tm);
    }

    private void validateEmptyFields() throws Exception {
        if (frmAvion.getTxtAvion().getText().isEmpty()) {
            throw new Exception("ID, title, descprition and deadline can't be empty!");
        }

    }
}
