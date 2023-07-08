/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import domain.Korisnik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmMain;
import view.form.FrmProfil;

/**
 *
 * @author Nikola
 */
public class ProfilController {

    private final FrmProfil frmProfil;

    public ProfilController(view.form.FrmProfil frmProfil) {
        this.frmProfil = frmProfil;
        addActionListener();
        prepareView();
    }

    public void openForm() {
        frmProfil.setVisible(true);
    }

    private void addActionListener() {
        frmProfil.dodajBtnLogoutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    Korisnik cm = (Korisnik) ViewCoordinator.getInstance().getParam("Korisnik");
                    Socket socket = communication.Communication.getInstance().logout(cm);
                    frmProfil.dispose();
                    FrmMain frmMain = ViewCoordinator.getInstance().getFrmMain();
                    frmMain.dispose();
                    socket.close();
                    ViewCoordinator.getInstance().openFrmLogin();
                } catch (SocketException se) {
                    JOptionPane.showMessageDialog(frmProfil, "Server je zatvoren.");
                    System.exit(0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frmProfil, "Dovidjenja!");

                }
            }
        });
    }

    private void prepareView() {
        Korisnik k = (Korisnik) ViewCoordinator.getInstance().getParam("Korisnik");
        System.out.println(k.getIme());
        frmProfil.getTxtIme().setText(k.getIme());
        frmProfil.getTxtPrezime().setText(k.getPrezime());
    }

}
