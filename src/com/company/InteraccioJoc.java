package com.company;

import java.util.ArrayList;
import java.util.Random;

public class InteraccioJoc {

    private static ArrayList<Fitxa> fitxes = new ArrayList<Fitxa>();
    private static ArrayList<Fitxa> taulell = new ArrayList<Fitxa>();
    private static Domino[] dominos = {new DominoLlati(),new DominoChileno(), new DominoVenezola()};
    private static Jugador[] jugadors;

    public static void crearFitxes(){

        for (int i = 0; i < 7; i++) {

            for (int j = i; j < 7; j++) {

                fitxes.add(new Fitxa(i,j));
            }
        }
    }
    public static void repartirFitxes(Jugador[] jugadors){

        for (Jugador jugador : jugadors) {

            int fitxesAssignades = 0;

            while (fitxesAssignades != 6) {

                Fitxa fitxa = fitxes.get((int) (Math.random() * fitxes.size()));
                if (!(fitxa.isUsada())) {
                    fitxa.setUsada(true);
                    jugador.addFitxa(fitxa);
                    fitxesAssignades++;
                    System.out.println(fitxa.getEsquerra() + "-" + fitxa.getDreta());
                }
            }
        }
    }


    public static void colocarFitxa(Fitxa fitxa){

        if(taulell.get(0).getEsquerra() == fitxa.getEsquerra() || taulell.get(0).getEsquerra() == fitxa.getDreta()
                || taulell.get(0).getDreta() == fitxa.getEsquerra() || taulell.get(0).getDreta() == fitxa.getDreta()){

            taulell.add(0,fitxa);

        }else if(taulell.get(taulell.size()-1).getEsquerra() == fitxa.getEsquerra() || taulell.get(taulell.size()-1).getEsquerra() == fitxa.getDreta()
                || taulell.get(taulell.size()-1).getDreta() == fitxa.getEsquerra() || taulell.get(taulell.size()-1).getDreta() == fitxa.getDreta()){

            taulell.add(taulell.size(), fitxa);
        }
    }

    public static void joc(){

        do {

            int domino = Input.eleccioDomino();
            jugadors = new Jugador[Input.eleccioParticipants()];
            Input.nomJugador(jugadors);

            if (jugadors.length == 2) {
                partidaEnSolitari(domino);

            }else {
                partidaEnParelles(domino);
            }

        }while (Input.reiniciaJoc());

    }

    public static void partidaEnSolitari(int domino){

        do {
            crearFitxes();
            repartirFitxes(jugadors);
            int torn = dominos[domino].elegirQuiInizialitza(jugadors).getId();
            while(!dominos[domino].fiDelJoc(jugadors)){

                colocarFitxa(Input.elegirFitxa(jugadors[torn%2]));
                Output.imprimirTaulell(taulell);

                torn++;
            }
        }while (true);

    }
    public static void partidaEnParelles(int domino){

    }

    public  static void algo(){

        jugadors = new Jugador[Input.eleccioParticipants()];
        Input.nomJugador(jugadors);

        for (int i = 0; i < jugadors.length; i++) {

            System.out.println(jugadors[i].getNom());
        }


    }


}
