package ejercicio1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/*
Oscar Arauz Pérez examen U3
 */

public class Cliente_chat extends JFrame implements ActionListener,Runnable {


    static MulticastSocket multisocketcliente = null;
    static byte[] buffer = new byte[1024];
    static InetAddress grupo = null;
    static int puerto = 6000;

    static JTextArea textmensaje;
    JButton enviar = new JButton("Enviar");
    JButton salir = new JButton("Salir");
    boolean repetir = true;
    String nombre;

    public Cliente_chat(String nom) {
        super("  UDP CHAT ~~~ Nombre: " + nom);
        setLayout(null);
        this.nombre = nom;
        textmensaje = new JTextArea();
        JScrollPane chatpane = new JScrollPane(textmensaje);
        chatpane.setBounds(10, 10, 300, 100);
        add(chatpane);
        salir.setBounds(320, 10, 100, 30);
        add(salir);
        textmensaje.setEditable(false);
        enviar.addActionListener(this);
        salir.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public static void main(String[] args) throws IOException {
        String usuario = JOptionPane.showInputDialog("Introduce tu usuario:");
        multisocketcliente = new MulticastSocket(puerto);
        grupo = InetAddress.getByName("225.0.0.1");
        multisocketcliente.joinGroup(grupo);
        String mensaje_inicio = "\n *** El usuario " + usuario + " entra al chat ***";
        DatagramPacket inicioChat = new DatagramPacket(mensaje_inicio.getBytes(),mensaje_inicio.length(),grupo,puerto);
        multisocketcliente.send(inicioChat);

        if (!usuario.trim().equals("")){
            Cliente_chat cliente = new Cliente_chat(usuario);
            cliente.setBounds(0,0,440,170);
            cliente.setVisible(true);
            new Thread(cliente).start();
        }
        else{
            System.out.println("No se ha introducido usuario...");
        }

    }

    @Override
    public void actionPerformed(ActionEvent ev) {

        if (ev.getSource() == salir){
            String txt = "\n *** El usuario " + nombre + " abandona el chat..." + " ***";

            try{
                DatagramPacket salida2 = new DatagramPacket(txt.getBytes(),txt.length(),grupo,puerto);
                multisocketcliente.send(salida2);
                multisocketcliente.close();
                repetir = false;
                System.out.println("\nEl usuario " + nombre + " abandona el chat...");
                System.exit(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        while (repetir) {
            try {
                DatagramPacket entrada = new DatagramPacket(buffer, buffer.length);
                multisocketcliente.receive(entrada);
                String mostrar = new String(entrada.getData(), 0, entrada.getLength());
                textmensaje.append( "\n" + mostrar );
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

