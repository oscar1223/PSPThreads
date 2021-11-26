package act2;

public class UsaHilo {

    public static void main(String[] args) {

        //ejecución del start tras implementar a runnable
        new Thread(new Hilo("Hilo1")).start();
        new Thread(new Hilo("Hilo2")).start();
        new Thread(new Hilo("Hilo3")).start();
        new Thread(new Hilo("Hilo4")).start();
        new Thread(new Hilo("Hilo5")).start();

    }
}
