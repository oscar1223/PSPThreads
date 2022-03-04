package Ejercicio3;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente_Entrenador {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Instancio atributos
        Socket cliente = new Socket("localhost", 6000);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream flujoSalida;
        ObjectInputStream flujoEntrada = null;
        String pokemonGo = null;
        Pokemon pokemonVamos = new Pokemon();

        do {
            System.out.println("ID Del Pokemon: ");
            pokemonGo = scanner.nextLine();
            flujoSalida = new DataOutputStream(cliente.getOutputStream());
            flujoSalida.writeUTF(pokemonGo);
            System.out.println("\t\tID Enviado");
            if (!pokemonGo.equals("*")) {
                flujoEntrada = new ObjectInputStream(cliente.getInputStream());
                pokemonVamos = (Pokemon) flujoEntrada.readObject();
                System.out.println("Pokemon: " + pokemonVamos.getNombre().toString() + "\nElemento: " + pokemonVamos.getElemento().toString());
                for(Ataque elemento : pokemonVamos.getAttack()) {
                    System.out.println("\tAtaque: " + elemento.getAtaque() + " - Daño: " + elemento.getDaño());
                }
            }
        } while (!pokemonGo.equals("*"));
        flujoSalida.close();
        flujoEntrada.close();
        scanner.close();
        cliente.close();
        System.out.println("Etrenador desconectado...");

    }
}

