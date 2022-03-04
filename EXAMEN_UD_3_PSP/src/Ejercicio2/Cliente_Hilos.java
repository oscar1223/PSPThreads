package Ejercicio2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

/*
Óscar Arauz Pérez U3
 */

public class Cliente_Hilos {

    public static void main(String[] args) throws IOException {

        String host = "localhost";
        int puerto = 44444;
        Socket cliente = new Socket(host, puerto);
        PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
        BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        JFrame frame = new JFrame("Cliente_Hilos Hilo");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField txt_min = new JTextField();
        txt_min.setPreferredSize(new Dimension(200, 30));
        JTextField txt_mayus = new JTextField();
        txt_mayus.setEditable(false);
        txt_mayus.setPreferredSize(new Dimension(200, 30));
        frame.add(txt_min, BorderLayout.NORTH);
        frame.add(txt_mayus, BorderLayout.CENTER);
        JPanel panel = new JPanel();

        JButton btn_enviar, btn_limpiar, btn_salir;
        btn_enviar = new JButton("Enviar");
        btn_limpiar = new JButton("Limpiar");
        btn_salir = new JButton("Salir");

        ActionListener btn_accion = e -> {

            //Se activa cuando se pulsa enviar
            if(e.getSource() == btn_enviar) {
                String cadenaEnviada = txt_min.getText();
                salida.println(cadenaEnviada);
                if (!cadenaEnviada.trim().equals("*")) {
                    try {
                        String cadenaRecibida = entrada.readLine();
                        txt_mayus.setText(cadenaRecibida);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            if(e.getSource() == btn_limpiar) {
                txt_min.setText("");
                txt_mayus.setText("");
            }
            if(e.getSource() == btn_salir) {
                String cadenaEnviada = "*";
                salida.println(cadenaEnviada);
                salida.close();
                try {
                    entrada.close();
                    cliente.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.exit(0);
            }

        };
        panel.add(btn_enviar, BorderLayout.EAST);
        panel.add(btn_limpiar, BorderLayout.SOUTH);
        panel.add(btn_salir, BorderLayout.EAST);
        btn_enviar.addActionListener(btn_accion);
        btn_limpiar.addActionListener(btn_accion);
        btn_salir.addActionListener(btn_accion);
        frame.add(panel);
        frame.setSize(300, 150);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    }

}

