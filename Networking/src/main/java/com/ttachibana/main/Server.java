/**
 * @author  Tyrel Tachibana
 * @date    2017-11-14
 * @notes   Server class that will connect to the companion client class
 */

package com.ttachibana.main;

import java.net.*;
import java.io.*;

public class Server extends Thread
{
   private final ServerSocket serverSocket;

   public Server(int port) throws IOException
   {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
   }

   @Override
   public void run()
   {
        while(true)
        {
            try
            {
                System.out.println("Waiting for client on port " +
                    serverSocket.getLocalPort() + "...");
                Socket server = serverSocket.accept();

                System.out.println("Just connected to " + server.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());
                DataOutputStream out = new DataOutputStream(server.getOutputStream());
                out.writeUTF("Thank you for connecting to " + server.getLocalSocketAddress()
                    + "\nGoodbye!");
                server.close();
            }
            catch (SocketTimeoutException s)
            {
                System.out.println("Socket timed out!");
                System.out.println(s.getMessage());
                break;
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
                break;
            }
        }
   }

   public static void main(String [] args)
   {
        //int port = Integer.parseInt(args[0]); // for actual use
        int port = 6666; // testing purposes
        try
        {
            Thread t = new Server(port);
            t.start();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
