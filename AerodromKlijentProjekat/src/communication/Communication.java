/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import domain.Avion;
import domain.Destinacija;
import domain.Korisnik;
import domain.Let;
import domain.Raspored;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class Communication {

    private static Communication instance;
    private Socket socket;
    private Receiver receiver;
    private Sender sender;

    public void connect() throws Exception {
        try {
            socket = new Socket("localhost", 9000);
            receiver = new Receiver(socket);
            sender = new Sender(socket);
        } catch (SocketException se) {
            throw new Exception("Server is not connected!");

        } catch (Exception e) {

        }
    }

    public static Communication getInstance() {
        if (instance == null) {
            instance = new Communication();
        }
        return instance;
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Korisnik login(String email, String password) throws Exception {
        Request request = new Request(Operation.LOGIN, new Korisnik(email, password, null, null));
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (Korisnik) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public Socket logout(Korisnik korisnik) throws Exception {
        Request request = new Request(Operation.LOGOUT, korisnik);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return socket;
        } else {
            throw response.getException();
        }
    }

    public void zapamtiLet(Let let) throws Exception {
        Request request = new Request(Operation.ZAPAMTI_LET, let);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }

    }

    public void zapamtiAvion(Avion avion) throws Exception {
        Request request = new Request(Operation.ZAPAMTI_AVION, avion);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }

    }

    public void zapamtiDestinaciju(Destinacija destinacija) throws Exception {
        Request request = new Request(Operation.ZAPAMTI_DESTINACIJU, destinacija);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }

    }

    public void zapamtiRaspored(Raspored raspored) throws Exception {
        Request request = new Request(Operation.ZAPAMTI_RASPORED, raspored);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }

    }

    public List<Let> vratiListuLetova() throws Exception {
        Request request = new Request(Operation.UCITAJ_LISTU_LETOVA, null);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Let>) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public List<Avion> vratiListuAviona() throws Exception {
        Request request = new Request(Operation.UCITAJ_LISTU_AVIONA, null);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Avion>) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public List<Destinacija> vratiListuDestinaicja() throws Exception {
        Request request = new Request(Operation.UCITAJ_LISTU_DESTINACIJA, null);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Destinacija>) response.getResult();
        } else {
            throw response.getException();
        }

    }

    public List<Let> nadjiLetove(Let let) throws Exception {
        Request request = new Request(Operation.NADJI_LETOVE, let);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Let>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Raspored> nadjiRasporede(Raspored raspored) throws Exception {
        Request request = new Request(Operation.NADJI_RASPOREDE, raspored);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Raspored>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Avion> nadjiAvione(Avion avion) throws Exception {
        Request request = new Request(Operation.NADJI_AVIONE, avion);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Avion>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public List<Destinacija> nadjiDestinacije(Destinacija destinacija) throws Exception {
        Request request = new Request(Operation.NADJI_DESTINACIJE, destinacija);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {
            return (List<Destinacija>) response.getResult();
        } else {
            throw response.getException();
        }
    }

    public void obrisiDestinaciju(Destinacija destinacija) throws Exception {
        Request request = new Request(Operation.OBRISI_DESTINACIJU, destinacija);
        sender.send(request);

        Response response = (Response) receiver.receive();
        if (response.getException() == null) {

        } else {
            throw response.getException();
        }
    }

}
