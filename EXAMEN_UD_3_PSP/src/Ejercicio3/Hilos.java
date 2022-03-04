package Ejercicio3;

import java.io.*;
import java.net.Socket;

public class Hilos extends Thread {

    //Instancio Objetos
    Ataque ataque1 = new Ataque("Hojas Afiladas", 45);
    Ataque ataque2 = new Ataque("Aliento Dragon", 50);
    Ataque ataque3 = new Ataque("Pistola Agua", 30);
    Ataque ataque4 = new Ataque("Ataque Rápido", 10);
    Ataque listaAta1[] = {ataque1,ataque4};
    Ataque listaAta2[] = {ataque2,ataque4};
    Ataque listaAta3[] = {ataque3,ataque4};
    Tipo_Elemento tipElem1 = new Tipo_Elemento("Agua", "Planta");
    Tipo_Elemento tipElem2 = new Tipo_Elemento("Planta", "Fuego");
    Tipo_Elemento tipElem3 = new Tipo_Elemento("Fuego", "Agua");
    Pokemon pokeball_1 = new Pokemon(1, "Bulbasur", tipElem2, listaAta1);
    Pokemon pokeball_2 = new Pokemon(2, "Charmander", tipElem3, listaAta2);
    Pokemon pokeball_3 = new Pokemon(3, "Squirtel", tipElem1, listaAta3);
    Pokemon lista_Pokeballs[] = {pokeball_1, pokeball_2, pokeball_3};

    Socket ClienteConectado = null;
    int numClienteConectado;
    DataInputStream flujoEntrada;
    ObjectOutputStream flujoSalida;


    public Hilos(Socket clienteconectado, int numclienteconectado) {
        this.ClienteConectado = clienteconectado;
        this.numClienteConectado = numclienteconectado;
    }

    public void run() {
        int ID = 0;
        String ID_PKM = "";
        System.out.println("Cliente " + numClienteConectado + " conectado.");
        Pokemon pokemon = new Pokemon();
        while (!ID_PKM.equals("*")) {

            try {

                flujoEntrada = new DataInputStream(ClienteConectado.getInputStream());
                ID_PKM = flujoEntrada.readUTF();

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (!ID_PKM.equals("*")) {

                ID = Integer.parseInt(ID_PKM);
                System.out.println("Consultando Pokemon....: " + ID + ", solicitado por el cliente: " + numClienteConectado);

                for (Pokemon element : lista_Pokeballs) {
                    if (element.getNumeroPokedex() == ID) {
                        pokemon = element;
                        System.out.println(pokemon.getNombre());
                    }
                }
                try{
                    flujoSalida = new ObjectOutputStream(ClienteConectado.getOutputStream());
                    flujoSalida.writeObject(pokemon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

