package Ejercicio3;

import java.io.Serializable;

public class Ataque implements Serializable {

    String ataque;
    int daño;

    public Ataque(String ataque, int damage) {
        this.ataque = ataque;
        this.daño = damage;
    }

    public Ataque(){
        super();
        ataque = "";
        daño = 0;
    }

    //Getter y setter
    public String getAtaque() {
        return ataque;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) {
        this.daño = daño;
    }
}