package act4;

public class UsoHilo {

    public static void main(String[] args) throws InterruptedException {
        long t_comienzo, t_fin;
        t_comienzo = System.currentTimeMillis();


        CuentaPalabras h1 =new CuentaPalabras("src\\act4\\Ejemplo1.txt","texto1");
        CuentaPalabras h2 =new CuentaPalabras("src\\act4\\Ejemplo2.txt","texto2");
        CuentaPalabras h3 =new CuentaPalabras("src\\act4\\Ejemplo3.txt","texto3");
        CuentaPalabras h4 =new CuentaPalabras("src\\act4\\Ejemplo4.txt","texto4");

        h1.start();
        h2.start();
        h3.start();
        h4.start();


        Thread.sleep(1000);

        t_fin = System.currentTimeMillis();
        long tiempoTotal = (t_fin - t_comienzo) - 1000;
        System.out.println("El proceso ha tardado: " + tiempoTotal + " milisegundos");
        //La mayoría de las veces sale 0, pero hay otras que no
    }

}
