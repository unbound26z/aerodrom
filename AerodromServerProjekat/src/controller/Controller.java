/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import domain.Avion;
import domain.Destinacija;
import domain.Korisnik;
import domain.Let;
import domain.Pilot;
import domain.Raspored;
import domain.StavkaRasporeda;
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
import operation.let.IzmeniLet;
import operation.let.NadjiLetove;
import operation.let.UcitajListuLetova;
import operation.let.ZapamtiLet;
import operation.pilot.UcitajListuPilota;
import operation.raspored.IzmeniRaspored;
import operation.raspored.NadjiRasporede;
import operation.raspored.UcitajListuRasporeda;
import operation.raspored.ZapamtiRaspored;
import operation.stavkaRasporeda.NadjiStavke;
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

    public void zapamtiRaspored(Raspored raspored) throws Exception {
        AbstractGenericOperation operation = new ZapamtiRaspored();
        operation.execute(raspored);

    }

    public List<Let> vratiListuLetova() throws Exception {
        UcitajListuLetova operation = new UcitajListuLetova();
        operation.execute(new Let());
        return operation.vratiListuLetova();
    }

    public List<Avion> vratiListuAviona() throws Exception {
        UcitajListuAviona operation = new UcitajListuAviona();
        operation.execute(new Avion());
        return operation.vratiListuAviona();
    }

    public List<Pilot> vratiListuPilota() throws Exception {
        UcitajListuPilota operation = new UcitajListuPilota();
        operation.execute(new Pilot());
        return operation.vratiListuPilota();
    }

    public List<Raspored> vratiListuRasporeda() throws Exception {
        UcitajListuRasporeda operation = new UcitajListuRasporeda();
        operation.execute(new Raspored());
        return operation.vratiListuRasporeda();
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

    public List<Raspored> nadjiRasporede(Raspored raspored) throws Exception {
        NadjiRasporede operation = new NadjiRasporede();
        operation.execute(raspored);
        return operation.vratiRasporede();
    }

    public List<StavkaRasporeda> nadjiStavke(StavkaRasporeda stavka) throws Exception {
        NadjiStavke operation = new NadjiStavke();
        operation.execute(stavka);
        return operation.vratiStavke();
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

    public void izmeniLet(Let letIzmeni) throws Exception {
        IzmeniLet operation = new IzmeniLet();
        operation.execute(letIzmeni);
    }

    public void izmeniRaspored(Raspored rasporedIzmeni) throws Exception {
        IzmeniRaspored operation = new IzmeniRaspored();
        operation.execute(rasporedIzmeni);
    }
}
