/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.coordinator;

import java.util.HashMap;
import java.util.Map;
import view.controller.AvionController;
import view.controller.DestinacijaController;
import view.controller.DodajAvionController;
import view.controller.DodajDestinacijuController;
import view.controller.DodajLetController;
import view.controller.DodajRasporedController;
import view.controller.LoginController;
import view.controller.MainController;
import view.controller.LetController;
import view.controller.ProfilController;
import view.controller.RasporedController;
import view.form.FrmAvion;
import view.form.FrmDestinacija;
import view.form.FrmDodajAvion;
import view.form.FrmDodajDestinaciju;
import view.form.FrmDodajLet;
import view.form.FrmDodajRaspored;
import view.form.FrmLogin;
import view.form.FrmMain;
import view.form.FrmLet;
import view.form.FrmProfil;

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
    private DodajRasporedController dodajRasporedController;
    private LoginController loginController;
    private MainController mainController;
    private LetController pilotController;
    private ProfilController profilController;
    private RasporedController rasporedController;
    private LetController letController;

    private ViewCoordinator() {
        params = new HashMap<>();
    }

    public static ViewCoordinator getInstance() {
        if (instance == null) {
            instance = new ViewCoordinator();
        }
        return instance;
    }

    public void openMainForm() {
        mainController = new MainController(new FrmMain());
        mainController.openForm();
    }

    public void openFrmAvion() {
        avionController = new AvionController(new FrmAvion(mainController.getFrmMain(), true));
        avionController.openForm();
    }

    public void openFrmProfil() {
        profilController = new ProfilController(new FrmProfil(mainController.getFrmMain(), true));
        profilController.openForm();
    }

    public void openFrmLogin() {
        loginController = new LoginController(new FrmLogin());
        loginController.openForm();
    }

    public void openFrmDestinacija() {
        destinacijaController = new DestinacijaController(new FrmDestinacija(mainController.getFrmMain(), true));
        destinacijaController.openForm();
    }

    public void openFrmLet() {
        letController = new LetController(new FrmLet(mainController.getFrmMain(), true));
        letController.openForm();
    }

    public void openFrmDodajAvion() {
        dodajAvionController = new DodajAvionController(new FrmDodajAvion(mainController.getFrmMain(), true));
        dodajAvionController.openForm();
    }

    public void openFrmDodajDestinaciju() {
        dodajDestinacijuController = new DodajDestinacijuController(new FrmDodajDestinaciju(mainController.getFrmMain(), true));
        dodajDestinacijuController.openForm();
    }

    public void openFrmDodajLet() {
        dodajLetController = new DodajLetController(new FrmDodajLet(mainController.getFrmMain(), true));
        dodajLetController.openForm();
    }

    public void openFrmDodajRaspored() {
        dodajRasporedController = new DodajRasporedController(new FrmDodajRaspored(mainController.getFrmMain(), true));
        dodajRasporedController.openForm();
    }

    public void addParam(String s, Object o) {
        params.put(s, o);
    }

    public Object getParam(String s) {
        return params.get(s);
    }

    public FrmMain getFrmMain() {
        return mainController.getFrmMain();
    }

    public FrmAvion getFrmAvion() {
        return avionController.getFrmAvion();
    }

    public FrmLet getFrmLet() {
        return letController.getFrmLet();
    }

    public void refreshAvionView() {
        avionController.refreshTable();
    }

    public void refreshDestinacijaView() {
        destinacijaController.refreshTable();
    }

}
