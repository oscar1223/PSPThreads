package ThreadAct1;
/*
    Crea una clase que extienda Thread cuya única funcionalidad sea visualizar el mensaje
    “Hola mundo”. Crea un programa Java que visualice el mensaje anterior 5 veces
    creando para ello 5 hilos diferentes usando la clase creada anteriormente. Modifica el
    mensaje “Hola mundo” en el hilo para incluir el identificador del hilo. Prueba de nuevo
    el programa Java creado anteriormente.
*/

public class Act1HolaMundo extends Thread {

    //Metodo de runeo
    public void run(){
        for(int x=1; x<=5; x++){
            System.out.println("Hola Mundo, desde Hilo:"+Thread.currentThread().getId());
        }
        System.out.println("=============================================");
    }

    //Metodo main
    public static void main(String[] args) {
        //Hilo 1
        Act1HolaMundo hil1 = new Act1HolaMundo();
        new Thread(hil1).start();
        //Hilo 2
        Act1HolaMundo hil2 = new Act1HolaMundo();
        new Thread(hil2).start();
        //Hilo 3
        Act1HolaMundo hil3 = new Act1HolaMundo();
        new Thread(hil3).start();
        //Hilo 4
        Act1HolaMundo hil4 = new Act1HolaMundo();
        new Thread(hil4).start();
        //Hilo 5
        Act1HolaMundo hil5 = new Act1HolaMundo();
        new Thread(hil5).start();
    }

}
