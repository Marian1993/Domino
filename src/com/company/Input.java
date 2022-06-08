package com.company;

import java.util.Scanner;

public class Input {

    private final static Scanner sc = new Scanner(System.in);

    public static void nomJugador(Jugador jugador){

        System.out.print("Nom del jugador " + jugador.getId() + " :");
        jugador.setNom(sc.next());

    }

}
