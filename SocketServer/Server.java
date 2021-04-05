package com.SocketServer;// A Java program for a Server
import java.net.*;
import java.io.*;

public class Server
{
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream inputStream	 = null;
    public Server(int port)
    {
        try
        {
            server = new ServerSocket(port);
            System.out.println("<----Server started---->");
            System.out.println("<----Waiting for a client---->");
            socket = server.accept();
            System.out.println("<----Client accepted---->");
            inputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = " ";
            while (line.length()>0)
            {
                try
                {
                    line = inputStream.readUTF();
                    System.out.println(line);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");
            socket.close();
            inputStream.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public static void main(String args[])
    {
        Server server = new Server(8080);
    }
}
