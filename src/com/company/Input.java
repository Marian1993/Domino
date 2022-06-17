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

        System.out.println("0 -> Domino Venezola");
        System.out.println("1 -> Domino Llati");
        System.out.println("2 -> Domino Chileno");
        System.out.print("Quin tipus de domino vols: ");

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

        System.out.println("0 -> Partida en solitari");
        System.out.println("1 -> Partida en parelles");
        System.out.print("Quin tipus de partida vols: ");
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

    public static Fitxa elegirFitxa(Jugador jugador, ArrayList<Fitxa> taulell){


        while (true) {

            collirFitxesNecessaries(jugador, taulell);
            jugador.imprimirFitxes();
            System.out.print(jugador.getNom() + " quina fitxa vols colocar = ");
            int numFitxa = PosarNumero.esNecessitaNumero();

            Fitxa fitxa = jugador.getFitxesJugador().get(numFitxa);
            if (comprovarSiEsPotColocarSaFitxa(fitxa, taulell)) {
                jugador.eliminarFitxa(fitxa);
                return fitxa;
            } else {
                System.out.println("Aquesta fitxa no en encaixa a cap banda");
            }

        }
    }

    public static boolean comprovarSiEsPotColocarSaFitxa(Fitxa fitxa, ArrayList<Fitxa> taulell){

        if(taulell.isEmpty()){
            return true;

        }else if(taulell.get(0).getDreta() == fitxa.getEsquerra() && !taulell.get(0).isDretaOcupada()){

            return true;

        }else if(taulell.get(0).getDreta() == fitxa.getDreta() && !taulell.get(0).isDretaOcupada()){

            return true;

        }else if(taulell.get(0).getEsquerra() == fitxa.getEsquerra() && !taulell.get(0).isEsquerraOcupada()){

            return true;

        }else if(taulell.get(0).getEsquerra() == fitxa.getDreta() && !taulell.get(0).isEsquerraOcupada()){

            return true;

        }else if(taulell.get(taulell.size()-1).getEsquerra() == fitxa.getEsquerra() && !taulell.get(taulell.size()-1).isEsquerraOcupada()){

            return true;

        }else if(taulell.get(taulell.size()-1).getEsquerra() == fitxa.getDreta() && !taulell.get(taulell.size()-1).isEsquerraOcupada()){

            return true;

        }else if(taulell.get(taulell.size()-1).getDreta() == fitxa.getEsquerra() && !taulell.get(taulell.size()-1).isDretaOcupada()){

            return true;

        } else if(taulell.get(taulell.size()-1).getDreta() == fitxa.getDreta() && !taulell.get(taulell.size()-1).isDretaOcupada()){

            return true;
        }
        return false;
    }

    private static boolean collirFitxesNecessaries(Jugador jugador, ArrayList<Fitxa> taulell){

        int totalFitxesCollides = 0;
        int fitxesJugador = jugador.getFitxesJugador().size();

        while (true) {

            for (int i = 0; i < jugador.getFitxesJugador().size(); i++) {

                if(comprovarSiEsPotColocarSaFitxa(jugador.getFitxesJugador().get(i),taulell)){

                    totalFitxesCollides = jugador.getFitxesJugador().size() - fitxesJugador;
                    if( totalFitxesCollides > 0){
                        System.out.println("Se t'han collit " + totalFitxesCollides + " fitxa/es");
                    }
                    return true;
                }
            }
            System.out.println("Ara se te colliran fitxes fins que en tinguis per tirar");
            InteraccioJoc.collirFitxa(jugador);
        }
    }

    public static boolean reiniciaJoc(){

        System.out.println("Reiniciar partida = 0 \n" + "Per sortir pitja cualsevol numero");
        int reinici = PosarNumero.esNecessitaNumero();

        return reinici == 0;
    }

}
