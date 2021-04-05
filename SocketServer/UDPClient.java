package com.SocketServer;

import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket();
        String name="Nithesh Kumar D";
        byte[] bytes = name.getBytes();
        InetAddress inetAddr=InetAddress.getLocalHost();
        DatagramPacket datagramPacket=new DatagramPacket(bytes,bytes.length,inetAddr,8080);
        datagramSocket.send(datagramPacket);
    }
}
