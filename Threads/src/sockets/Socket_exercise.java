/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;

/**
 *
 * @author kaspe_000
 */
public class Socket_exercise {

    public void Server() throws IOException {

        ServerSocket server = new ServerSocket(8080);
        server.bind(new InetSocketAddress("localhost", 8080));
        server.accept();

        
        
    }
}
