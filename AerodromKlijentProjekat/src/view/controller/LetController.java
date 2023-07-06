/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import communication.Communication;
import domain.Destinacija;
import domain.Let;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import view.coordinator.ViewCoordinator;
import view.form.FrmDestinacija;
import view.form.FrmLet;
import view.form.components.table.DestinacijaTableModel;
import view.form.components.table.LetTableModel;

/**
 *
 * @author Nikola
 */
public class LetController {

    private final FrmLet frm;

    public LetController(FrmLet frm) {
        this.frm = frm;
        addActionListener();

    }

    public void openForm() {
        prepareView();
        frm.setVisible(true);

    }

    public FrmLet getFrmLet() {
        return frm;
    }

    public void prepareView() {
        List<Let> lista = new ArrayList<>();
        try {
            lista = Communication.getInstance().vratiListuLetova();
        } catch (SocketException se) {
            JOptionPane.showMessageDialog(frm, "Server zatvoren");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frm, "Error: " + ex.getMessage());
        }
        LetTableModel tm = new LetTableModel(lista);
        frm.getTblLet().setModel(tm);
//        TableColumn column = frm.getTblLet().getColumnModel().getColumn(2);
//        column.setPreferredWidth(100);

    }

    private void addActionListener() {
        frm.dodajBtnNadjiListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String gg = frm.getTxtLet().getText().trim();
                if (gg.equals("")) {
                    prepareView();
                    return;
                }
                try {
                    Let let = new Let(Long.valueOf(0), 0, 0, null, null, null, null);
                    let.setCena(Integer.parseInt(gg));
                    List<Let> letovi = Communication.getInstance().nadjiLetove(let);
                    if (letovi.isEmpty()) {
                        JOptionPane.showMessageDialog(frm, "Ne postoji takav let!");
                        return;
                    }
                    LetTableModel tm = new LetTableModel(letovi);
                    frm.getTblLet().setModel(tm);
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frm, "Server zatvoren");
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frm, "Greska pri trazenju leta: " + e.getMessage());

                }
            }
        });

        frm.dodajBtnIzmeniListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                int row = frm.getTblLet().getSelectedRow();

                Let let = new Let();
                let.setId(Long.valueOf((Long) frm.getTblLet().getValueAt(row, 0)));
                let.setTrajanje((int) frm.getTblLet().getValueAt(row, 1));
                let.setCena((int) frm.getTblLet().getValueAt(row, 2));
                ViewCoordinator.getInstance().addParam("Let", let);
                ViewCoordinator.getInstance().openFrmIzmeniLet();
            }
        });
    }

    public void refreshTable() {
        List<Let> letovi = new ArrayList<>();
        try {
            letovi = Communication.getInstance().vratiListuLetova();
        } catch (SocketException se) {
            JOptionPane.showMessageDialog(frm, "Server is closed, Goodbye");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frm, "Error: " + ex.getMessage());
        }
        LetTableModel tm = new LetTableModel(letovi);
        frm.getTblLet().setModel(tm);
    }

    private void validateEmptyFields() throws Exception {
        if (frm.getTxtLet().getText().isEmpty()) {
            throw new Exception("ID, title, descprition and deadline can't be empty!");
        }

    }
}
