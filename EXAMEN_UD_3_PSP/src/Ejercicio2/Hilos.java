package Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
Claase para la creaciónd ehilos
 */

public class Hilos extends Thread {


    BufferedReader entradaBuffer;
    PrintWriter salidaBuffer;
    Socket socketHilo;


    public Hilos(Socket socket) throws IOException {
        this.socketHilo = socket;
        salidaBuffer = new PrintWriter(socket.getOutputStream(), true);
        entradaBuffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        String msg = "";
        System.out.println("=>  Conecta IP /" + socketHilo.getInetAddress() + ", Puerto remoto: " + socketHilo.getPort());

        while (!msg.trim().equals("*")) {
            try {
                msg = entradaBuffer.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(!msg.trim().equals("*")) {
                salidaBuffer.println(msg.trim().toUpperCase());
            }
        }
        System.out.println("\t=>Desconecta IP /" + socketHilo.getInetAddress() + ", Puerto remoto: " + socketHilo.getPort()+"\n");
        salidaBuffer.close();

        try {
            entradaBuffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socketHilo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

