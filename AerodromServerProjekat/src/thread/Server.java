/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package thread;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author Nikola
 */
public class Server extends Thread {
     private ServerSocket ss;
    public Server() {
    }

    @Override
    public void run() {
        try{
        ss = new ServerSocket(9000);
            System.out.println("Cekaju se klijenti...");
        while(!ss.isClosed()){
            Socket socket = ss.accept();
            System.out.println("Klijent povezan...");
            handleClient(socket);
            
        }
        }catch(SocketException se){
            System.out.println(se.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void handleClient(Socket socket) {
        HandleClient hc = new HandleClient(socket);
        hc.start();
    }

    public void stopServer() {
        try{
            ss.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
