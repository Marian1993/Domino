package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Input {

    private final static Scanner sc = new Scanner(System.in);

    public static void nomJugador(Jugador[] jugadors){

        for (int i = 0; i < jugadors.length; i++) {

            System.out.print("Nom del jugador " + i + " :");
            jugadors[i] = new Jugador(sc.next(),i);
        }
    }

    public static int eleccioDomino(){

        System.out.println("Quin tipus de domino vols:");
        System.out.println("0 -> Domino Venezola");
        System.out.println("1 -> Domino Llati");
        System.out.println("2 -> Domino Chileno");

        int eleccio = PosarNumero.esNecessitaNumero();

        if(eleccio == 0){
            return 0;
        }else if( eleccio == 1){
            return 1;
        }else if(eleccio == 2){
            return 2;
        }
        else {
            System.err.println("No has posat cap de les eleccions següents.");
            System.out.println();
            eleccioParticipants();
        }
        return 0;
    }

    public static int eleccioParticipants(){

        System.out.println("Quin tipus de partida vols:");
        System.out.println("0 -> Partida en solitari");
        System.out.println("1 -> Partida en parelles");
        int eleccio = PosarNumero.esNecessitaNumero();
        if(eleccio == 0){
            return 2;
        }else if( eleccio == 1){
            return 4;
        }else {
            System.err.println("No has posat cap de les eleccions següents.");
            System.out.println();
            eleccioParticipants();
        }
        return 0;
    }

    public static Fitxa elegirFitxa(Jugador jugador){

        jugador.imprimirFitxes();
        System.out.print("Quina fitxa vols colocar = ");
        int numFitxa = PosarNumero.esNecessitaNumero();

        Fitxa fitxa = jugador.getFitxesJugador().get(numFitxa);
        jugador.eliminarFitxa(fitxa);
        return fitxa;
    }


    public static boolean colocarFitxa(Fitxa fitxa, ArrayList<Fitxa> taulell){

        if(taulell.get(0).getEsquerra() == fitxa.getEsquerra() || taulell.get(0).getEsquerra() == fitxa.getDreta()
                || taulell.get(0).getDreta() == fitxa.getEsquerra() || taulell.get(0).getDreta() == fitxa.getDreta()){

            taulell.add(0,fitxa);
            return true;

        }else if(taulell.get(taulell.size()-1).getEsquerra() == fitxa.getEsquerra() || taulell.get(taulell.size()-1).getEsquerra() == fitxa.getDreta()
                || taulell.get(taulell.size()-1).getDreta() == fitxa.getEsquerra() || taulell.get(taulell.size()-1).getDreta() == fitxa.getDreta()){

            taulell.add(taulell.size(), fitxa);
            return  true;
        }
        return  false;
    }

    public static boolean reiniciaJoc(){

        System.out.println("Reiniciar partida = 0 \n" + "Per sortir pitja cualsevol numero");
        int reinici = PosarNumero.esNecessitaNumero();

        return reinici == 0;
    }

}
