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
import domain.Let;
import java.net.Socket;
import java.util.List;

/**
 *
 * @author Nikola
 */
public class HandleClient extends Thread{
    private Socket socket;
    private boolean end=false;

    public HandleClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try{
            Receiver receiver = new Receiver(socket);
            Sender sender = new Sender(socket);
            while(!socket.isClosed() && socket.isConnected()){
                Response response = new Response();
                Request request = (Request) receiver.receive();
                
                try{
                    switch(request.getOperation()){
                        case UCITAJ_LISTU_AVIONA:
                            break;
                        case UCITAJ_LISTU_DESTINACIJA:
                            break;
                        case UCITAJ_LISTU_LETOVA:
                            break;
                        case ZAPAMTI_LET:
                            Let let = (Let) request.getArgument();
                            Controller.getInstance().zapamtiLet(let);
                            break;
                        case NADJI_LETOVE:
                            break;
                        case UCITAJ_LET:
                            break;
                        case KREIRAJ_AVION:
                            break;
                        case ZAPAMTI_AVION:
                            break;
                        case NADJI_AVIONE:
                            break;
                        case UCITAJ_AVION:
                            break;
                        case KREIRAJ_DESTINACIJU:
                            break;
                        case ZAPAMTI_DESTINACIJU:
                            break;
                        case NADJI_DESTINACIJE:
                            break;
                        case UCITAJ_DESTINACIJU:
                            break;
                        case OBRISI_DESTINACIJU:
                            break;
                        case ZAPAMTI_RASPORED:
                            break;
                        case NADJI_RASPOREDE:
                            break;
                        case UCITAJ_RASPORED:
                            break;
                        default:
                            throw new AssertionError(request.getOperation().name());
                        
                    }
                }catch(Exception e){
                    response.setException(e);
                }
                sender.send(response);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
}
