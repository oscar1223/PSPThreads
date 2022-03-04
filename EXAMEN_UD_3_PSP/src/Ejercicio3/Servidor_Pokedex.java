package Ejercicio3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.lang.Thread;

public class Servidor_Pokedex extends Thread{

    public static void main(String[] args) throws IOException {
        ServerSocket Servidor = new ServerSocket(6000);
        int numCliente = 0;
        System.out.println("Servidor iniciado...");

        while (true) {
            Socket clienteconectado = new Socket();
            clienteconectado = Servidor.accept();
            numCliente++;
            Hilos hilo = new Hilos(clienteconectado, numCliente);
            hilo.start();

        }
    }
}

