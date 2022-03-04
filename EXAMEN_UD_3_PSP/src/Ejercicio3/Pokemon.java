package Ejercicio3;


import java.io.Serializable;

public class Pokemon  implements Serializable {
    int numeroPokedex;
    String nombre;
    Tipo_Elemento elemento;
    Ataque[] attack;

    public Pokemon(){
        numeroPokedex = 0;
        nombre = "";
        elemento = new Tipo_Elemento();
        attack = new Ataque[0];
    }
    public Pokemon(int numeroPokedex, String nombre, Tipo_Elemento elemento, Ataque[] attack) {
        this.numeroPokedex = numeroPokedex;
        this.nombre = nombre;
        this.elemento = elemento;
        this.attack = attack;
    }
    @Override
    public String toString() {

        return "\n Pokemon{" +
                "numeroPokedex=" + numeroPokedex +
                ", nombre='" + nombre + '\'' +
                ", elemento=" + elemento +
                ", ataque=" + attack +
                '}';
    }


    //Getter  Setter
    public int getNumeroPokedex() {
        return numeroPokedex;
    }

    public void setNumeroPokedex(int numeroPokedex) {
        this.numeroPokedex = numeroPokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo_Elemento getElemento() {
        return elemento;
    }

    public void setElemento(Tipo_Elemento elemento) {
        this.elemento = elemento;
    }

    public Ataque[] getAttack() {

        return attack;
    }

    public void setAttack(Ataque[] attack) {
        this.attack = attack;
    }
}

