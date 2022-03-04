package ejercicio1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Servidor_Chat extends JFrame implements ActionListener,Runnable {


    //Declaramos los datos del socket
    static MulticastSocket multisocket = null;
    static byte[] buffer = new byte[1024];
    static InetAddress grupo = null;
    static int puerto = 6000;

    //Declaramos los elementos que vamos a añadir a la interfaz
    static JTextField mensaje = new JTextField();
    private JScrollPane scrollpane1;
    static JTextArea textarea_chat;
    JButton boton = new JButton("Enviar");
    JButton salir = new JButton("Salir");
    boolean repetir = true;
    String nombre;



    public Servidor_Chat(){
        super("  CHAT UDP ~~~ Alias: Administrador " );
        setLayout(null);

        mensaje.setBounds(10, 10, 300, 30);
        add(mensaje);
        textarea_chat = new JTextArea();
        scrollpane1 = new JScrollPane(textarea_chat);
        scrollpane1.setBounds(10, 50, 300, 100);
        add(scrollpane1);
        boton.setBounds(320, 10, 100, 30);
        add(boton);
        salir.setBounds(320, 50, 100, 30);
        add(salir);

        textarea_chat.setEditable(false);
        boton.addActionListener(this);
        salir.addActionListener(this);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }


    public static void main(String[] args) throws IOException {

        //Creamos el socket multicast con los datos declarados
        multisocket = new MulticastSocket(puerto);
        grupo = InetAddress.getByName("225.0.0.1");

        //Nos unimos al grupo
        multisocket.joinGroup(grupo);

        //Manda un mensaje de que ha entrado en el chat
        String mensaje_inicio = "\n *** El usuario Servidor_Hilos entra al chat ***";
        DatagramPacket inicioChat = new DatagramPacket(mensaje_inicio.getBytes(),mensaje_inicio.
                length(),grupo,puerto);
        multisocket.send(inicioChat);

        //Mostramos la ventana
        Servidor_Chat cliente = new Servidor_Chat();
        cliente.setBounds(0,0,440,200);
        cliente.setVisible(true);
        new Thread(cliente).start();


    }


    //Aqui indicamos las acciones de los botones
    @Override
    public void actionPerformed(ActionEvent ev) {
        //Se acciona el boton de enviar
        if(ev.getSource() == boton){
            //Formateo del mensaje
            String introducido  = "\nServidor_Hilos ->" + mensaje.getText();
            try{
                //Envio el mensaje
                DatagramPacket salida = new DatagramPacket(introducido.getBytes(),introducido.length(),grupo,puerto);
                multisocket.send(salida);
                mensaje.setText("");

            }catch (IOException ex){
                ex.printStackTrace();
            }

        }
        //Se acciona el botón desconectar del chat
        if (ev.getSource() == salir){
            String txt = "\n *** El usuario Servidor_Hilos abandona el chat ***";

            try{
                //Se notifica la desconexión enviando al servidor
                DatagramPacket salida2 = new DatagramPacket(txt.getBytes(),txt.length(),grupo,puerto);
                multisocket.send(salida2);
                multisocket.close();

                repetir = false;
                System.out.println("\nEl usuario Servidor_Hilos abandona el chat...");
                System.exit(0);


            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }


    //Se reciben y escriben los mensajes
    @Override
    public void run() {
        while (repetir) {
            try {
                //Creamos la entrada de paquetes
                DatagramPacket entrada = new DatagramPacket(buffer, buffer.length);
                multisocket.receive(entrada);
                //La escribimos
                String mostrar = new String(entrada.getData(), 0, entrada.getLength());
                textarea_chat.append(mostrar + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

