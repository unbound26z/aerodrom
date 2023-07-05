/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import communication.Communication;
import domain.Avion;
import domain.Korisnik;
import domain.Let;
import domain.Raspored;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;
import view.coordinator.ViewCoordinator;
import view.form.FrmMain;
import view.form.FrmProfil;
import view.form.FrmRaspored;
import view.form.components.table.AvionTableModel;
import view.form.components.table.LetTableModel;
import view.form.components.table.RasporedTableModel;

/**
 *
 * @author Nikola
 */
public class RasporedController {

    private final FrmRaspored frm;

    public RasporedController(view.form.FrmRaspored frm) {
        this.frm = frm;
        addActionListener();
        prepareView();
    }

    public void openForm() {
        frm.setVisible(true);
    }

    private void addActionListener() {

    }

    private void prepareView() {
        List<Raspored> list = new ArrayList<>();
        try {
            list = Communication.getInstance().vratiListuRasporeda();
        } catch (SocketException se) {
            JOptionPane.showMessageDialog(frm, "Server is closed, Goodbye");
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frm, "Error: " + ex.getMessage());
        }
        RasporedTableModel tm = new RasporedTableModel(list);
        frm.getTblRaspored().setModel(tm);
    }
}
