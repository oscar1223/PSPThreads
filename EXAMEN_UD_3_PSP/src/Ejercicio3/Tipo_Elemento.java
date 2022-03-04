package Ejercicio3;

import java.io.Serializable;

public class Tipo_Elemento implements Serializable {

    String elemento;
    String debil_contra;

    //Constructor vacío
    public Tipo_Elemento() {
        elemento = "";
        debil_contra = "";
    }
    //Constructor de la clase
    public Tipo_Elemento(String elemento, String debil_contra) {
        this.elemento = elemento;
        this.debil_contra = debil_contra;
    }

    //Getter y setter
    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getDebil_contra() {
        return debil_contra;
    }

    public void setDebil_contra(String debil_contra) {
        this.debil_contra = debil_contra;
    }

}

