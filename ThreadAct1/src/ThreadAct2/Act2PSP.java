package ThreadAct2;

/*

Crea una clase que implemente la interfaz Runnable cuya única funcionalidad sea
visualizar el mensaje “Hola mundo” seguido de una cadena que se recibirá en el
constructor (es decir, al crear un objeto de este tipo se enviará una cadena) y seguido
del identificador del hilo.
Crea un programa Java que visualice el mensaje anterior 5
veces creando para ello 5 hilos diferentes usando la clase creada anteriormente. Luego
haz que antes de visualizar el mensaje el hilo espere un tiempo proporcional a su
identificador; usa para ello el método sleep(). ¿Qué diferencias observas al ejecutar el
programa usando o no el método sleep()?

 */

import ThreadAct1.Act1HolaMundo;

public class Act2PSP extends Thread implements Runnable{

    //Definimos el constructor.
    public Act2PSP(String nombre){
        super(nombre);
        System.out.println("CREANDO HILO:"+ getName());
    }


    //Metodo de runeo
    public void run(){
        try{
            int numi = (int) Thread.currentThread().getId();
            sleep(Thread.currentThread().getId(), numi);
            System.out.println("Hola Mundo, desde Hilo:"+Thread.currentThread().getId());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("=============================================");
    }


    //Metodo main
    public static void main(String[] args) {
        //Hilo 1
        Act2PSP hil1 = new Act2PSP("Hilo 1");
        new Thread(hil1).run();
        //Hilo 2
        Act2PSP hil2 = new Act2PSP("Hilo 2");
        new Thread(hil2).run();
        //Hilo 3
        Act2PSP hil3 = new Act2PSP("Hilo 3");
        new Thread(hil3).run();
        //Hilo 4
        Act2PSP hil4 = new Act2PSP("Hilo 4");
        new Thread(hil4).run();
        //Hilo 5
        Act2PSP hil5 = new Act2PSP("Hilo 5");
        new Thread(hil5).run();
    }
}
