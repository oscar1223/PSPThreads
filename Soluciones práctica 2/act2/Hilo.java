package act2;

public class Hilo implements Runnable {
    //String nombre;

    /*
    en esta ocasión, al no extender de Thread,
    no podemos usar sus métodos directamente.
     */
    public Hilo (String nombre) {
        Thread.currentThread().setName(nombre);
    }

    /*
       run, que mostrará el nombre (identificador)
       del hilo y "hola mundo" tras ejecutar su .start().

       Según su id, lo bloquearemos escalonadamente. Esto hará que
       se muestre ordenadamente debido a que la espera es en cascada y
       escalonada.
        */
    public void run() {
        try {
            Thread.sleep(Thread.currentThread().getId()*100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hola mundo: " + Thread.currentThread().getName());
    }
}
