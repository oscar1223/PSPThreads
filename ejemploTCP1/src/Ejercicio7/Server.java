package Ejercicio7;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


class SocketServidor {
    public static void main(String[] args) throws IOException {
        int Puerto=6000;
        ServerSocket servidor=null;
        servidor = new ServerSocket(Puerto);

        System.out.println("Escuchando en " + servidor.getLocalPort());

        Socket cliente1 = servidor.accept();

        Socket cliente2 = servidor.accept();

        servidor.close();
    }
}
