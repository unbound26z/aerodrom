/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.net.SocketException;
import javax.swing.JOptionPane;
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
    }

      private void addActionListener() {
        frmProfil.addBtnLogoutListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
            CommitteeLeader cm = (CommitteeLeader) ViewCordinator.getInstance().getParam("Leader");
            Socket socket = communication.Communication.getInstance().logout(cm);
            frmProfile.dispose();
            FrmMain frmMain = ViewCordinator.getInstance().getFrmMain();
            frmMain.dispose();
            socket.close();
            ViewCordinator.getInstance().openLoginForm();
        }catch(SocketException se){
            JOptionPane.showMessageDialog(frmProfile, "Server is closed, Goodbye");
            System.exit(0);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(frmProfile, "Goodbye!"+e.getMessage());
        }
            }
        });
    }

    
}
