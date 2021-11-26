package act1;

public class UsaHilo {

    public static void main(String[] args) {
        /*
        Creación de los cinco hilos, que reciben
        su nombre (identificador)
         */
        Hilo h1 = new Hilo("Hilo1");
        Hilo h2 = new Hilo("Hilo2");
        Hilo h3 = new Hilo("Hilo3");
        Hilo h4 = new Hilo("Hilo4");
        Hilo h5 = new Hilo("Hilo5");

        /*
        inicializaciones de los hilos. Este orden
        no significa que vayan a mostrarse en orden,
        ni siquiera ejecutarse como tal
         */
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
    }

}
