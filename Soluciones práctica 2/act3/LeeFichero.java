package act3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeeFichero extends Thread{
    private String ruta="";
    private String nomFichero="";
    private long total=0;

    public LeeFichero(String ruta, String texto){
        this.ruta=ruta;
        this.nomFichero=texto;
    }

    public void run() {
        try{

            Integer contador=0;
            Integer contador2=0;
            String codigo;
            char a = ' ';

            FileReader reader= new FileReader(ruta);
            BufferedReader buffer= new BufferedReader(reader);

            while(( codigo=buffer.readLine())!=null) {
               contador=contador+codigo.length();
                for (int i = 0; i < codigo.length(); i++) {
                    if (codigo.charAt(i) == ' ') contador2++;
                }

            }
            contador =contador-contador2;

            reader.close();
            buffer.close();
            System.out.println("Número de caracteres del "+ nomFichero+" es "+contador);



        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
