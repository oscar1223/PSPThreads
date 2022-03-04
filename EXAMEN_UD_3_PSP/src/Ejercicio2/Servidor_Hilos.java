package Ejercicio2;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor_Hilos {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(44444);
        System.out.println("Servidor_Hilos iniciado...");

        while (true) {
            Socket cliente = new Socket();
            cliente = servidor.accept();
            Hilos hilo = new Hilos(cliente);
            hilo.start();
        }
    }
}

