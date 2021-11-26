package sara.Practica_UD2.src.act5;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReboteApplet extends Applet implements Runnable, ActionListener{
    private Thread hilo;
    private Font fuente;
    private Button botFin, botReanudar;
    boolean choqueDcha = false;
    boolean botFinPulsado = false;
    boolean botReanPulsado = false;
    boolean inicio = true;
    boolean stopHilo = false;
    int x=1;

    public void pararHilo () {
        stopHilo = true;
    }

    public void run() {
        while (!stopHilo) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    public void start() {
        hilo = new Thread(this);
        hilo.start();
    }
    
    public void init() {
        setBackground(Color.yellow);
        add(botFin = new Button("Finalizar Hilo"));
        botFin.addActionListener(this);
        add(botReanudar = new Button("Reanudar Hilo"));
        botReanudar.addActionListener(this);
        fuente = new Font("Arial", Font.PLAIN, 24);
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, 500, 500);
        g.setFont(fuente);
        botFin.setLocation(160,10);
        botReanudar.setLocation(155,10);

        if (x==(getSize().width-15)) { choqueDcha = true; }
        if (x==0) { choqueDcha = false; }

        if (choqueDcha) {
            x--;
        } else {
            x++;
        }

        if (inicio) {
            botReanudar.setVisible(false);
            inicio = false;
        }

        if (botFinPulsado) {
            botFin.setVisible(false);
            botReanudar.setVisible(true);
        }

        if (botReanPulsado) {
            botReanudar.setVisible(false);
            botFin.setVisible(true);
        }
        g.drawString("O", x, 100);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botFin) {
            botReanPulsado = false;
            botFinPulsado = true;
            pararHilo();
        }
        if (e.getSource() == botReanudar) {
            botFinPulsado = false;
            botReanPulsado = true;
            hilo = new Thread(this);
            hilo.start();
        }
    }
}
