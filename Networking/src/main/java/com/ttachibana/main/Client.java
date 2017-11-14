/**
 * @author  Tyrel Tachibana
 * @date    2017-11-14
 * @notes   Client class that will connect to the companion server class
 */

package com.ttachibana.main;

import java.net.*;
import java.io.*;

public class Client
{
   public static void main(String [] args)
   {
        //String serverName = args[0]; // for actual use
        String serverName = "localhost"; // testing purposes
        //int port = Integer.parseInt(args[1]); // for actual use
        int port = 6666; // testing purposes
        try
        {
            System.out.println("Connecting to " + serverName + " on port " + port);
            try (Socket client = new Socket(serverName, port))
            {
                System.out.println("Just connected to " + client.getRemoteSocketAddress());
                OutputStream outToServer = client.getOutputStream();
                DataOutputStream out = new DataOutputStream(outToServer);

                out.writeUTF("Hello from " + client.getLocalSocketAddress());
                InputStream inFromServer = client.getInputStream();
                DataInputStream in = new DataInputStream(inFromServer);

                System.out.println("Server says " + in.readUTF());
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
