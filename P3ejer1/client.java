package P3ejer1;
/*
Usando sockets TCP realiza un programa cliente que introduzca cadenas por
teclado hasta introducir un asterisco. Las cadenas se enviarán a un programa servidor.
El programa servidor aceptará la conexión de un único cliente y por cada cadena
recibida le devolverá al cliente el número de caracteres de la misma. El programa
servidor finalizará cuando reciba un asterisco como cadena.
 */
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int puerto = 6000;
        int tamaño = 0;

        try{

            System.out.println("Programa cliente iniciando...");
            Socket cliente = new Socket(Host, puerto);

            while(tamaño != -1){
                Scanner sc = new Scanner(System.in);
                System.out.print("Introduxca una cadena de caracteres: ");
                String cadLeida = sc.nextLine();

                //Creo flujo de salida.
                DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());


                //  Envio cadena al servidor.
                flujoSalida.writeUTF(cadLeida);
                System.out.println("Enviado al servidor");

                //Creo flujo de entrada.
                DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

                //Mensaje del servidor.
                tamaño = flujoEntrada.read();
                System.out.println("Numero de caracteres de la cadena: "+tamaño);
            }


        }catch(IOException e){
            e.printStackTrace();
        }



    }
}
