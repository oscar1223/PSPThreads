package P3ejer2;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class cliente {
    public static void main(String[] args) throws Exception {
        int puerto = 6000;
        MulticastSocket ms = new MulticastSocket(puerto);

        InetAddress grupo = InetAddress.getByName("192.168.2.13");

        ms.joinGroup(grupo);

        String msg = "";

        while(!msg.trim().equals("*")){
            byte[] buf = new byte[1000];
            //Recibe el paquete del servidor multicast.
            DatagramPacket paquete = new DatagramPacket(buf, buf.length);
            ms.receive(paquete);

            msg = new String(paquete.getData());
            System.out.println("Recibido: "+msg.trim());

        }
        ms.leaveGroup(grupo);
        ms.close();
        System.out.println("Socket cerrado...");

    }
}
