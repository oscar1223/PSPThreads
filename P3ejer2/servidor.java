package P3ejer2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class servidor {
    public static void main(String[] args) throws Exception {
        //Flujo de entrada estandar.
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        //Creo el socket multicast
        MulticastSocket ms = new MulticastSocket();

        int puerto = 6000;
        InetAddress grupo = InetAddress.getByName("192.168.2.13");

        String cadena = "";

        while(!cadena.trim().equals("*")){
            System.out.println("Datos enviados a un grupo: ");
            cadena = in.readLine();

            //Enviado al grupo.
            DatagramPacket paquete = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
            ms.send(paquete);
        }
        ms.close();
        System.out.println("Socket cerrado ...");


    }

}
