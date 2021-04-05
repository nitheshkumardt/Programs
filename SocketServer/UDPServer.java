package com.SocketServer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        System.out.println("<---Server--->");
        DatagramSocket datagramSocket=new DatagramSocket(8080);
        byte[] bytes = new byte[1024];
        System.out.println("Waiting for Client");
        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length);
        datagramSocket.receive(datagramPacket);
        String name= new String(datagramPacket.getData());
        System.out.println("Name:: "+name);
    }
}
