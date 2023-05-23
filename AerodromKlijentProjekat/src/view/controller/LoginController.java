/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import communication.Communication;
import domain.Korisnik;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.coordinator.ViewCoordinator;
import view.form.FrmLogin;

/**
 *
 * @author Nikola
 */
public class LoginController {

    private final FrmLogin frmLogin;

    public LoginController(FrmLogin frmLogin) {
        this.frmLogin = frmLogin;
        addActionListeners();
    }

    public void openForm() {
        frmLogin.setVisible(true);
    }

    private void addActionListeners() {
        frmLogin.dodajBtnLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                login(ae);
            }

            private void login(ActionEvent ae) {
                try {
                    frmLogin.getLblValidacija().setText("");
                    frmLogin.getLblValidacija().setText("");
                    String email = frmLogin.getTxtEmail().getText().trim();
                    String password = String.copyValueOf(frmLogin.getTxtSifra().getPassword()).trim();
                    validateUserInput();
                    Communication.getInstance().connect();
                    Korisnik k = Communication.getInstance().login(email, password);
                    ViewCoordinator.getInstance().addParam("Korisnik", k);
                    JOptionPane.showMessageDialog(frmLogin, "Uspesnan login " + k.getIme());
                    ViewCoordinator.getInstance().openMainForm();
                    frmLogin.dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(frmLogin, "Neuspesan login: " + e.getMessage());

                }
            }
        });
    }

    private void validateUserInput() throws Exception {
        if (frmLogin.getTxtEmail().getText().trim().equals("") || String.copyValueOf(frmLogin.getTxtSifra().getPassword()).trim().equals("")) {
            if (String.copyValueOf(frmLogin.getTxtSifra().getPassword()).trim().equals("")) {
                frmLogin.getLblValidacija().setText("Unesite sifru!");
                frmLogin.getLblValidacija().setForeground(Color.red);
            }
            if (frmLogin.getTxtEmail().getText().trim().equals("")) {
                frmLogin.getLblValidacija().setText("Unesite mail!");
                frmLogin.getLblValidacija().setForeground(Color.red);
            }

            frmLogin.getTxtSifra().setText("");
            throw new Exception("Email i sifra ne smeju biti prazni!");
        }
        frmLogin.getLblValidacija().setText("");
        frmLogin.getLblValidacija().setText("");
    }

}
