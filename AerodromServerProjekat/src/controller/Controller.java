/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import thread.Server;

/**
 *
 * @author Nikola
 */
public class Controller {

    private static Controller instance;
    private Server server;
    private Map<String, Socket> activeCl;

     private Controller(){
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

}
