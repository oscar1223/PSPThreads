package act4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CuentaPalabras extends Thread {
    String fichero;

    public CuentaPalabras(String fichero, String nombre) {
        setName(nombre);
        this.fichero = fichero;
    }

    public void run() {
        try {
        FileReader reader = new FileReader(fichero);
        BufferedReader buffer = new BufferedReader(reader);
        Integer contador=0;
        String codigo;

        while(( codigo=buffer.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(codigo);
            contador = contador+st.countTokens();
            }


        reader.close();
        buffer.close();
        System.out.println("El numero de palabras de "+fichero+" es "+contador);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
