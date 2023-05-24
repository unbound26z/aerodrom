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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import view.form.FrmAvion;
import view.form.FrmDestinacija;
import view.form.components.table.AvionTableModel;
import view.form.components.table.DestinacijaTableModel;

/**
 *
 * @author Nikola
 */
public class DestinacijaController {

    private final FrmDestinacija frm;

    public DestinacijaController(FrmDestinacija frm) {
        this.frm = frm;
    }

    public void openForm() {
        prepareView();
        frm.setVisible(true);

    }

    public FrmDestinacija getFrmDestinacija() {
        return frm;
    }

    public void prepareView() {
        List<Destinacija> lista = new ArrayList<>();
        try {
            lista = Communication.getInstance().vratiListuDestinaicja();
        } catch (SocketException se) {
            JOptionPane.showMessageDialog(frm, "Server zatvoren");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frm, "Error: " + ex.getMessage());
        }
        DestinacijaTableModel tm = new DestinacijaTableModel(lista);
        frm.getTblDestinacija().setModel(tm);
        TableColumn column = frm.getTblDestinacija().getColumnModel().getColumn(2);
        column.setPreferredWidth(200);

    }

    private void addActionListener() {
        frm.dodajBtnNadjiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String naziv = frm.getTxtDestinacija().getText().trim();
                if (naziv.equals("")) {
                    prepareView();
                    return;
                }
                try {
                    Destinacija destinacija = new Destinacija(0, naziv, naziv);
                    destinacija.setNazivDestinacije(naziv);
                    List<Destinacija> destinacije = Communication.getInstance().nadjiDestinacije(destinacija);
                    if (destinacije.isEmpty()) {
                        JOptionPane.showMessageDialog(frm, "Ne postoji takva destinacija!");
                        return;
                    }
                    DestinacijaTableModel tm = new DestinacijaTableModel(destinacije);
                    frm.getTblDestinacija().setModel(tm);
                    TableColumn column = frm.getTblDestinacija().getColumnModel().getColumn(2);
                    column.setPreferredWidth(200);
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frm, "Server zatvoren");
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "Greska pri trazenju destinacije: " + e.getMessage());

                }
            }
        });

    }

    private void validateEmptyFields() throws Exception {
        if (frm.getTxtDestinacija().getText().isEmpty()) {
            throw new Exception("ID, title, descprition and deadline can't be empty!");
        }

    }
}
