package act1;

public class Hilo extends Thread {

    /*
    constructor que usa el método setName
    de Thread para para utilizar el nombre
    del hilo
    */
    public Hilo (String nombre) {
        setName(nombre);
    }

    /*
    run, que mostrará el nombre (identificador)
    del hilo y "hola mundo" tras ejecutar su .start().
     */
    public void run() {
        System.out.println(getName() + ": Hola mundo");
    }
}
