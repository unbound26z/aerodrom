/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.coordinator;

import java.util.Map;
import view.controller.AvionController;
import view.controller.DestinacijaController;
import view.controller.DodajAvionController;
import view.controller.DodajDestinacijuController;
import view.controller.DodajLetController;
import view.controller.DodajPilotaController;
import view.controller.DodajRasporedController;
import view.controller.LoginController;
import view.controller.MainController;
import view.controller.PilotController;
import view.controller.ProfilController;
import view.controller.RasporedController;
import view.form.FrmLogin;

/**
 *
 * @author Nikola
 */
public class ViewCoordinator {

    private static ViewCoordinator instance;
    private Map<String, Object> params;
    private AvionController avionController;
    private DestinacijaController destinacijaController;
    private DodajAvionController dodajAvionController;
    private DodajDestinacijuController dodajDestinacijuController;
    private DodajLetController dodajLetController;
    private DodajPilotaController dodajPilotaController;
    private DodajRasporedController dodajRasporedController;
    private LoginController loginController;
    private MainController mainController;
    private PilotController pilotController;
    private ProfilController profilController;
    private RasporedController rasporedController;

    public static ViewCoordinator getInstance() {
        if (instance == null) {
            instance = new ViewCoordinator();
        }
        return instance;
    }

    public void addParam(String s, Object o) {
        params.put(s, o);
    }

    public Object getParam(String s) {
        return params.get(s);
    }

}
