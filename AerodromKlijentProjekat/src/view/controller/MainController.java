/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

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
                ViewCoordinator.getInstance().openAddMemberForm();
            }
        });
        
        frmMain.addJmiViewAllMembersListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCordinator.getInstance().openViewMembers();
            }
        });
        
        frmMain.addJmiViewAllTaskGroupsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCordinator.getInstance().openViewTaskGroups();
            }
        });
        
        frmMain.addJmiViewProfileListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ViewCordinator.getInstance().openProfileForm();
            }
        });
    }

    private void prepareView() {
        CommitteeLeader cm = (CommitteeLeader) ViewCordinator.getInstance().getParam("Leader");
        frmMain.getLblLider().setText(cm.getFirstname()+" "+cm.getLastname());
    }

    public FrmMain getFrmMain() {
        return frmMain;
    }
    
}
