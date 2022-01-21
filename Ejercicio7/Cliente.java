package Ejercicio7;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

class SocketCliente {
    public static void main(String[] args) throws IOException {
        String Host = "localhost";
        int Puerto = 6000;

        Socket Cliente = new Socket(Host, Puerto);
        Socket Cliente2 = new Socket(Host, Puerto);

        InetAddress i = Cliente.getInetAddress();
        InetAddress i2 = Cliente2.getInetAddress();

        System.out.println("Puerto local: "+Cliente.getLocalPort());
        System.out.println("Puerto Remoto: "+Cliente.getPort());
        System.out.println("Host remoto: "+i.getHostName());
        System.out.println("IP Host remoto: "+i.getHostAddress());

        System.out.println("Puerto local: "+Cliente2.getLocalPort());
        System.out.println("Puerto Remoto: "+Cliente2.getPort());
        System.out.println("Host remoto: "+i2.getHostName());
        System.out.println("IP Host remoto: "+i2.getHostAddress());


    }

}
