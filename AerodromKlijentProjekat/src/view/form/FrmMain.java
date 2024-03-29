/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.form;

import domain.Korisnik;
import java.awt.event.ActionListener;
import java.net.Socket;
import javax.swing.JLabel;
import view.coordinator.ViewCoordinator;

/**
 *
 * @author Nikola
 */
public class FrmMain extends javax.swing.JFrame {

    /**
     * Creates new form FrmMain
     */
    public FrmMain() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        lblKorisnik = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jmiDodajRaspored = new javax.swing.JMenuItem();
        jmiRaspored = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jmiDodajAvion = new javax.swing.JMenuItem();
        jmiAvion = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jmiDodajPilota = new javax.swing.JMenuItem();
        jmiPilot = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jmiDodajDestinaciju = new javax.swing.JMenuItem();
        jmiDestinacija = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jmiDodajLet = new javax.swing.JMenuItem();
        jmiLet = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jmiProfil = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu5.setText("jMenu5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Dobrodosli, ");

        lblKorisnik.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblKorisnik.setText("Korisnik");

        jMenu1.setText("Raspored");

        jmiDodajRaspored.setText("Dodaj");
        jMenu1.add(jmiDodajRaspored);

        jmiRaspored.setText("Pregled ");
        jmiRaspored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRasporedActionPerformed(evt);
            }
        });
        jMenu1.add(jmiRaspored);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Avion");

        jmiDodajAvion.setText("Dodaj");
        jMenu2.add(jmiDodajAvion);

        jmiAvion.setText("Pregled");
        jmiAvion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAvionActionPerformed(evt);
            }
        });
        jMenu2.add(jmiAvion);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Pilot");

        jmiDodajPilota.setText("Dodaj");
        jMenu3.add(jmiDodajPilota);

        jmiPilot.setText("Pregled");
        jMenu3.add(jmiPilot);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Destinacija");

        jmiDodajDestinaciju.setText("Dodaj");
        jMenu4.add(jmiDodajDestinaciju);

        jmiDestinacija.setText("Pregled");
        jMenu4.add(jmiDestinacija);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("Let");

        jmiDodajLet.setText("Dodaj");
        jMenu7.add(jmiDodajLet);

        jmiLet.setText("Pregled");
        jMenu7.add(jmiLet);

        jMenuBar1.add(jMenu7);

        jMenu6.setText("Profil");

        jmiProfil.setText("Pregled profila");
        jMenu6.add(jmiProfil);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblKorisnik)
                    .addComponent(jLabel1))
                .addContainerGap(265, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lblKorisnik)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiAvionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAvionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiAvionActionPerformed

    private void jmiRasporedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRasporedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmiRasporedActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        try {
            Korisnik k = (Korisnik) ViewCoordinator.getInstance().getParam("Korisnik");
            Socket socket = communication.Communication.getInstance().logout(k);
            socket.close();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    public JLabel getLblLider() {
        return lblKorisnik;
    }

    public void setLblLider(JLabel lblKorisnik) {
        this.lblKorisnik = lblKorisnik;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jmiAvion;
    private javax.swing.JMenuItem jmiDestinacija;
    private javax.swing.JMenuItem jmiDodajAvion;
    private javax.swing.JMenuItem jmiDodajDestinaciju;
    private javax.swing.JMenuItem jmiDodajLet;
    private javax.swing.JMenuItem jmiDodajPilota;
    private javax.swing.JMenuItem jmiDodajRaspored;
    private javax.swing.JMenuItem jmiLet;
    private javax.swing.JMenuItem jmiPilot;
    private javax.swing.JMenuItem jmiProfil;
    private javax.swing.JMenuItem jmiRaspored;
    private javax.swing.JLabel lblKorisnik;
    // End of variables declaration//GEN-END:variables

    public void dodajJmiDodajAvionListener(ActionListener actionListener) {
        jmiDodajAvion.addActionListener(actionListener);
    }

    public void dodajJmiRasporedListener(ActionListener actionListener) {
        jmiRaspored.addActionListener(actionListener);
    }

    public void dodajJmiDodajRasporedListener(ActionListener actionListener) {
        jmiDodajRaspored.addActionListener(actionListener);
    }

    public void dodajJmiAvionListener(ActionListener actionListener) {
        jmiAvion.addActionListener(actionListener);
    }

    public void dodajJmiPilotListener(ActionListener actionListener) {
        jmiPilot.addActionListener(actionListener);
    }

    public void dodajJmiDodajPilotaListener(ActionListener actionListener) {
        jmiDodajPilota.addActionListener(actionListener);
    }

    public void dodajJmiDestinacijaListener(ActionListener actionListener) {
        jmiDestinacija.addActionListener(actionListener);
    }

    public void dodajJmiDodajDestinacijuListener(ActionListener actionListener) {
        jmiDodajDestinaciju.addActionListener(actionListener);
    }

    public void dodajJmiDodajLetListener(ActionListener actionListener) {
        jmiDodajLet.addActionListener(actionListener);
    }

    public void dodajJmiLetListener(ActionListener actionListener) {
        jmiLet.addActionListener(actionListener);
    }

    public void dodajJmiProfilListener(ActionListener actionListener) {
        jmiProfil.addActionListener(actionListener);
    }
}
