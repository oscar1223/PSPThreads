package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HiloNumeroLetras hnl = new HiloNumeroLetras(1);
        Thread t = new Thread(hnl);
        t.start();
        for(int i = 0; i<5; i++){
            System.out.println("Fuera del hilo");
        }

    }
}
