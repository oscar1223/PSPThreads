package P3ejer1;
/*
Usando sockets TCP realiza un programa cliente que introduzca cadenas por
teclado hasta introducir un asterisco. Las cadenas se enviarán a un programa servidor.
El programa servidor aceptará la conexión de un único cliente y por cada cadena
recibida le devolverá al cliente el número de caracteres de la misma. El programa
servidor finalizará cuando reciba un asterisco como cadena.
 */

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class client {
    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int puerto = 6000;

        System.out.println("Programa cliente iniciando...");
        Socket cliente = new Socket(Host, puerto);

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduxca una cadena ed caracteres: ");
        String cadLeida = sc.nextLine();

        //Creo flujo de salida.
        DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

        //  Envio cadena al servidor.
        flujoSalida.writeUTF(cadLeida);

        //Creo flujo de entrada.
        DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

        //Mensaje del servidor.
        System.out.println("Numero de caracteres de la cadena: "+flujoEntrada.readUTF());

        if(cadLeida == "*"){
            sc.close();
            System.out.println("Programa terminado.");
        }

        //Cerrar Streams y Sockets.
        flujoEntrada.close();
        flujoSalida.close();
        cliente.close();
    }
}
