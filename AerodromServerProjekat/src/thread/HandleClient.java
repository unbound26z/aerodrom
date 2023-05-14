/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.Avion;
import domain.Destinacija;
import domain.Let;
import domain.Raspored;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class HandleClient extends Thread {

    private Socket socket;
    private boolean end = false;

    public HandleClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            Receiver receiver = new Receiver(socket);
            Sender sender = new Sender(socket);
            while (!socket.isClosed() && socket.isConnected()) {
                Response response = new Response();
                Request request = (Request) receiver.receive();

                try {
                    switch (request.getOperation()) {
                        case UCITAJ_LISTU_AVIONA:
                            List<Avion> avioni = Controller.getInstance().vratiListuAviona();
                            response.setResult(avioni);
                            break;
                        case UCITAJ_LISTU_DESTINACIJA:
                            List<Destinacija> destinacije = Controller.getInstance().vratiListuDestinacija();
                            response.setResult(destinacije);
                            break;
                        case UCITAJ_LISTU_LETOVA:
                            List<Let> letovi = Controller.getInstance().vratiListuLetova();
                            response.setResult(letovi);
                            break;
                        case ZAPAMTI_LET:
                            Let let = (Let) request.getArgument();
                            Controller.getInstance().zapamtiLet(let);
                            break;
                        case NADJI_LETOVE:
                            Let trazenLet = (Let) request.getArgument();
                            response.setResult(Controller.getInstance().nadjiLetove(trazenLet));
                            break;
                        case ZAPAMTI_AVION:
                            Avion noviAvion = (Avion) request.getArgument();
                            Controller.getInstance().zapamtiAvion(noviAvion);
                            break;
                        case NADJI_AVIONE:
                            Avion trazeniAvion = (Avion) request.getArgument();
                            response.setResult(Controller.getInstance().nadjiAvione(trazeniAvion));
                            break;
                        case ZAPAMTI_DESTINACIJU:
                            Destinacija novaDestinacija = (Destinacija) request.getArgument();
                            Controller.getInstance().zapamtiDestinaciju(novaDestinacija);
                            break;
                        case NADJI_DESTINACIJE:
                            Destinacija trazenaDestinacija = (Destinacija) request.getArgument();
                            response.setResult(Controller.getInstance().nadjiDestinacije(trazenaDestinacija));
                            break;
                        case OBRISI_DESTINACIJU:
                            break;
                        case ZAPAMTI_RASPORED:
                            Raspored novRaspored = (Raspored) request.getArgument();
                            Controller.getInstance().zapamtiRaspored(novRaspored);
                            break;
                        case NADJI_RASPOREDE:
                            Raspored trazeniRaspored = (Raspored) request.getArgument();
                            response.setResult(Controller.getInstance().nadjiRasporede(trazeniRaspored));
                            break;
                        default:
                            throw new AssertionError(request.getOperation().name());
                    }
                } catch (Exception e) {
                    response.setException(e);
                }
                sender.send(response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
