package P3ejer1;

/*
Usando sockets TCP realiza un programa cliente que introduzca cadenas por
teclado hasta introducir un asterisco. Las cadenas se enviarán a un programa servidor.
El programa servidor aceptará la conexión de un único cliente y por cada cadena
recibida le devolverá al cliente el número de caracteres de la misma. El programa
servidor finalizará cuando reciba un asterisco como cadena.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {

        int numeroPuerto = 6000;
        ServerSocket servidor = new ServerSocket(numeroPuerto);
        Socket clientConect = null;
        OutputStream salida = null;
        DataOutputStream flujoSalida = null;
        System.out.println("Esperando al cliente...");
        clientConect = servidor.accept();


        //Creo el flujo de entrada del cliente.
        InputStream entrada = null;
        entrada = clientConect.getInputStream();
        DataInputStream flujoEntrada = new DataInputStream(entrada);


        //El cliente envia cadenas de texto.
        System.out.println("Recibido del cliente: \n\t" +
                flujoEntrada.readUTF());


        //Recojo la cadena.
        String cadena = flujoEntrada.readUTF();
        int numerito = cadena.length();
        String num = String.valueOf(numerito);

        while(!cadena.equals("*")){
            salida = clientConect.getOutputStream();
            flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF(num);

        }
        if(cadena.equals("*")){
            salida = clientConect.getOutputStream();
            flujoSalida = new DataOutputStream(salida);
            flujoSalida.writeUTF("-1");
        }else{
            //Cerramos Streams y Sockets.
            entrada.close();
            flujoEntrada.close();
            salida.close();
            flujoSalida.close();
            clientConect.close();
            servidor.close();
        }



    }
}
