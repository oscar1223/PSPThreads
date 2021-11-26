package act3;



public class UsaHilo extends Thread{


    public static void main(String[] args) throws InterruptedException {
        long t_comienzo, t_fin;
        t_comienzo=System.currentTimeMillis();

        LeeFichero h1 =new LeeFichero("src\\act3\\Ejemplo1.txt","texto1");
        LeeFichero h2 =new LeeFichero("src\\act3\\Ejemplo2.txt","texto2");
        LeeFichero h3 =new LeeFichero("src\\act3\\Ejemplo3.txt","texto3");
        LeeFichero h4 =new LeeFichero("src\\act3\\Ejemplo4.txt","texto4");

        h1.start();
        h2.start();
        h3.start();
        h4.start();

        Thread.sleep(1000);
        t_fin=System.currentTimeMillis();
        long timepo_total = t_fin -t_comienzo-1000;
        ;
        System.out.println("El proceso ha tardado "+timepo_total+" milisegundos");

    }
}
