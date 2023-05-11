/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Avion;
import domain.Destinacija;
import domain.Korisnik;
import domain.Let;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import operation.AbstractGenericOperation;
import operation.avion.NadjiAvione;
import operation.avion.UcitajListuAviona;
import operation.avion.ZapamtiAvion;
import operation.destinacija.NadjiDestinacije;
import operation.destinacija.ObrisiDestinaciju;
import operation.destinacija.UcitajListuDestinacija;
import operation.destinacija.ZapamtiDestinaciju;
import operation.korisnik.LoginKorisnik;
import operation.let.NadjiLetove;
import operation.let.UcitajListuLetova;
import operation.let.ZapamtiLet;
import thread.Server;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;
    private Server server;
    private Map<String, Socket> activeCl;

    private Controller() {
        activeCl = new HashMap<>();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void startServer() {
        server = new Server();
        server.start();
    }

    public void stopServer() {
        for (String email : activeCl.keySet()) {
            System.out.println(email);
            try {
                activeCl.get(email).close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        activeCl.clear();
        server.stopServer();
    }

    public Korisnik login(String email, String sifra, Socket socket) throws Exception {
        LoginKorisnik operation = new LoginKorisnik();
        Korisnik korisnik = new Korisnik();
        korisnik.setEmail(email);
        korisnik.setSifra(sifra);
        operation.execute(korisnik);
        korisnik = operation.vratiKorisnika();
        if (activeCl.containsKey(korisnik.getEmail())) {
            throw new Exception("Korisnik je vec aktivan!");
        }
        activeCl.put(korisnik.getEmail(), socket);
        return korisnik;
    }

    public void logout(Korisnik korisnik) throws IOException {
        activeCl.remove(korisnik.getEmail());

    }

    public void zapamtiLet(Let let) throws Exception {
        AbstractGenericOperation operation = new ZapamtiLet();
        operation.execute(let);
    }

    public void zapamtiAvion(Avion avion) throws Exception {
        AbstractGenericOperation operation = new ZapamtiAvion();
        operation.execute(avion);
    }
    
     public void zapamtiDestinaciju(Destinacija destinacija) throws Exception {
        AbstractGenericOperation operation = new ZapamtiDestinaciju();
        operation.execute(destinacija);
    }

    public List<Let> vratiListuLetova() throws Exception {
        UcitajListuLetova operation = new UcitajListuLetova();
        operation.execute(new Let());
        return operation.vratiListuLetova();
    }

    public List<Avion> vratiListuAviona() throws Exception {
        UcitajListuAviona operation = new UcitajListuAviona();
        operation.execute(new Let());
        return operation.vratiListuAviona();
    }

    public List<Destinacija> vratiListuDestinacija() throws Exception {
        UcitajListuDestinacija operation = new UcitajListuDestinacija();
        operation.execute(new Destinacija());
        return operation.vratiListuDestinacija();
    }

    public List<Let> nadjiLetove(Let let) throws Exception {
        NadjiLetove operation = new NadjiLetove();
        operation.execute(let);
        return operation.vratiLetove();
    }

    public List<Avion> nadjiAvione(Avion avion) throws Exception {
        NadjiAvione operation = new NadjiAvione();
        operation.execute(avion);
        return operation.vratiAvione();
    }
    
    public List<Destinacija> nadjiDestinacije(Destinacija destinacija) throws Exception {
        NadjiDestinacije operation = new NadjiDestinacije();
        operation.execute(destinacija);
        return operation.vratiDestinacije();
    }

    public void obrisiDestinaciju(Destinacija destinacija) throws Exception {
        ObrisiDestinaciju operation = new ObrisiDestinaciju();
        operation.execute(destinacija);
    }
}
