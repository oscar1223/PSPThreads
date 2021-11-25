package com.company;

public class HiloNumeroLetras implements Runnable{

    int tipo;

     public HiloNumeroLetras(int tipo){
         this.tipo = tipo;
     }

    @Override
    public void run() {
        if (tipo == 1){
            int i;
            for(i=1; i<=30; i++){
                System.out.println(i);
            }
        }else if (tipo == 2){
            int j;
            for(j = 97; j<123; j++){
                System.out.println((char) j);
            }

        }else{
            System.out.println("Tipo no es ni 1 ni 2.");
        }
    }
}
