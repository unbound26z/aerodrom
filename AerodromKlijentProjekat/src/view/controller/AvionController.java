/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import view.form.FrmAvion;

/**
 *
 * @author Nikola
 */
public class AvionController {

    private final FrmAvion frmAvion;

    public AvionController(FrmAvion frmAvion) {
        this.frmAvion = frmAvion;
    }

    public void openForm() {
        prepareView();
        frmAvion.setVisible(true);

    }
}
