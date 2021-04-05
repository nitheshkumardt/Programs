package com.SocketServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket=null;
    private DataInputStream inputStream=null;
    private DataOutputStream outputStream=null;
        public Client(String address, int port)
        {
            try
            {
                socket = new Socket(address, port);
                System.out.println("Connected:::"+ socket.getRemoteSocketAddress());
                inputStream  = new DataInputStream(System.in);
                outputStream = new DataOutputStream(socket.getOutputStream());
            }
            catch(UnknownHostException u)
            {
                System.out.println(u);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
            String line = " ";
            while (line.length()>0)
            {
                try
                {
                    line=null;
                    line = inputStream.readLine();
                    outputStream.writeUTF(line);
                    //System.out.println(line.length());
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            try
            {
                inputStream.close();
                outputStream.close();
                socket.close();
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }
        public static void main(String args[])
        {
            Client client = new Client("localhost", 8080);
        }
}
