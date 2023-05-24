/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import domain.Korisnik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.coordinator.ViewCoordinator;
import view.form.FrmMain;

/**
 *
 * @author Nikola
 */
public class MainController {

    private final FrmMain frmMain;

    public MainController(FrmMain frmMain) {
        this.frmMain = frmMain;
        addActionListener();
    }

    public void openForm() {
        prepareView();
        frmMain.setVisible(true);

    }

    private void addActionListener() {
        frmMain.dodajJmiAvionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCoordinator.getInstance().openFrmAvion();
            }
        });

        frmMain.dodajJmiDestinacijaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCoordinator.getInstance().openFrmDestinacija();
            }
        });

        frmMain.dodajJmiDodajAvionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCoordinator.getInstance().openFrmDodajAvion();
            }
        });

        frmMain.dodajJmiDodajDestinacijuListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCoordinator.getInstance().openFrmDodajDestinaciju();
            }
        });

        frmMain.dodajJmiDodajLetListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCoordinator.getInstance().openFrmDodajLet();
            }
        });

        frmMain.dodajJmiProfilListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCoordinator.getInstance().openFrmProfil();
            }
        });
    }

    private void prepareView() {
        Korisnik k = (Korisnik) ViewCoordinator.getInstance().getParam("Korisnik");
        frmMain.getLblLider().setText(k.getIme() + " " + k.getPrezime());
    }

    public FrmMain getFrmMain() {
        return frmMain;
    }

}
