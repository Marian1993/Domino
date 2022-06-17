package com.company;

import java.util.ArrayList;
import java.util.Random;

public class InteraccioJoc {

    private static ArrayList<Fitxa> fitxes = new ArrayList<Fitxa>();
    private static ArrayList<Fitxa> taulell = new ArrayList<Fitxa>();
    private final static Domino[] dominos = {new DominoLlati(),new DominoChileno(), new DominoVenezola()};
    private static Jugador[] jugadors;
    private static int aux = 0;
    private static int fitxaInicial = 0;


    public static void crearFitxes(){

        for (int i = 0; i < 7; i++) {

            for (int j = i; j < 7; j++) {

                fitxes.add(new Fitxa(i,j));
            }
        }
    }
    public static void repartirFitxes(){

        for (int i = 0; i < jugadors.length; i++) {

            int fitxesAssignades = 0;

            while (fitxesAssignades != 4) {

                Fitxa fitxa = fitxes.get((int) (Math.random() * fitxes.size()));
                if (!(fitxa.isUsada())) {
                    fitxa.setUsada(true);
                    jugadors[i].addFitxa(fitxa);
                    fitxes.remove(fitxa);
                    fitxesAssignades++;
                }
            }
        }
    }

    public static void collirFitxa(Jugador jugador){

        boolean fitxaUtil = false;

        while (!fitxaUtil && !fitxes.isEmpty()) {

            Fitxa fitxa = fitxes.get((int) (Math.random() * fitxes.size()));
            if (!(fitxa.isUsada())) {
                fitxa.setUsada(true);
                jugador.addFitxa(fitxa);
                if(Input.comprovarSiEsPotColocarSaFitxa(fitxa,taulell)){

                    fitxaUtil = true;
                }
            }
        }
    }

    public static void colocarFitxa(Fitxa fitxa){

        if(taulell.isEmpty()){
            taulell.add(fitxa);

        }else if(taulell.get(0).getDreta() == fitxa.getEsquerra() && !taulell.get(0).isDretaOcupada()){

            taulell.add(0,fitxa);
            fitxa.setEsquerraOcupada(true);
            if((taulell.get(1).getDreta() == fitxa.getEsquerra() || taulell.get(1).getDreta() == fitxa.getDreta()) && aux == 0){
                taulell.get(1).setDretaOcupada(true);
                aux++;
            }
            fitxaInicial++;

        }else if(taulell.get(0).getDreta() == fitxa.getDreta() && !taulell.get(0).isDretaOcupada()){

            taulell.add(0,fitxa);
            fitxa.setDretaOcupada(true);
            if((taulell.get(1).getDreta() == fitxa.getEsquerra() || taulell.get(1).getDreta() == fitxa.getDreta()) && aux == 0){
                taulell.get(1).setDretaOcupada(true);
                aux++;
            }
            fitxaInicial++;

        }else if(taulell.get(0).getEsquerra() == fitxa.getEsquerra() && !taulell.get(0).isEsquerraOcupada() && taulell.size() > 1){

            taulell.add(0,fitxa);
            fitxa.setEsquerraOcupada(true);
            if((taulell.get(1).getEsquerra() == fitxa.getDreta() || taulell.get(1).getEsquerra() == fitxa.getEsquerra()) && aux == 0){
                taulell.get(1).setEsquerraOcupada(true);
                aux++;
            }
            fitxaInicial++;

        }else if(taulell.get(0).getEsquerra() == fitxa.getDreta() && !taulell.get(0).isEsquerraOcupada() && taulell.size() > 1){

            taulell.add(0,fitxa);
            fitxa.setDretaOcupada(true);
            if((taulell.get(1).getEsquerra() == fitxa.getDreta() || taulell.get(1).getEsquerra() == fitxa.getEsquerra()) && aux == 0){
                taulell.get(1).setEsquerraOcupada(true);
                aux++;
            }
            fitxaInicial++;

        }else if(taulell.get(taulell.size()-1).getEsquerra() == fitxa.getEsquerra() && !taulell.get(taulell.size()-1).isEsquerraOcupada()){

            if((taulell.get(taulell.size()-1).getEsquerra() == fitxa.getEsquerra() || taulell.get(taulell.size()-1).getEsquerra() == fitxa.getDreta()) && aux == 1){
                taulell.get(taulell.size()-1).setEsquerraOcupada(true);
                aux++;
            }
            taulell.add(taulell.size(), fitxa);
            fitxa.setEsquerraOcupada(true);

        }else if(taulell.get(taulell.size()-1).getEsquerra() == fitxa.getDreta() && !taulell.get(taulell.size()-1).isEsquerraOcupada()){

            if((taulell.get(taulell.size()-1).getEsquerra() == fitxa.getEsquerra() || taulell.get(taulell.size()-1).getEsquerra() == fitxa.getDreta()) && aux == 1){
                taulell.get(taulell.size()-1).setEsquerraOcupada(true);
                aux++;
            }
            taulell.add(taulell.size(), fitxa);
            fitxa.setDretaOcupada(true);

        }else if(taulell.get(taulell.size()-1).getDreta() == fitxa.getEsquerra() && !taulell.get(taulell.size()-1).isDretaOcupada() && taulell.size() > 1){

            if((taulell.get(taulell.size()-1).getDreta() == fitxa.getDreta() || taulell.get(taulell.size()-1).getDreta() == fitxa.getEsquerra()) && aux == 1){
                taulell.get(taulell.size()-1).setDretaOcupada(true);
                aux++;
            }
            taulell.add(taulell.size(), fitxa);
            fitxa.setEsquerraOcupada(true);

        } else if(taulell.get(taulell.size()-1).getDreta() == fitxa.getDreta() && !taulell.get(taulell.size()-1).isDretaOcupada() && taulell.size() > 1){

            if((taulell.get(taulell.size()-1).getDreta() == fitxa.getDreta() || taulell.get(taulell.size()-1).getDreta() == fitxa.getEsquerra()) && aux == 1){
                taulell.get(taulell.size()-1).setDretaOcupada(true);
                aux++;
            }
            taulell.add(taulell.size(), fitxa);
            fitxa.setDretaOcupada(true);
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
            repartirFitxes();
            int torn = dominos[domino].elegirQuiInizialitza(jugadors).getId();
            while(!dominos[domino].guanyarRondaSolitari(jugadors)){

                colocarFitxa(Input.elegirFitxa(jugadors[torn%4],taulell));
                Output.imprimirTaulell(taulell,fitxaInicial);
                torn++;
            }
        }while (!dominos[domino].guanyadorSolitari(jugadors));

    }
    public static void partidaEnParelles(int domino){

        do {
            crearFitxes();
            repartirFitxes();
            int torn = dominos[domino].elegirQuiInizialitza(jugadors).getId();
            while(!dominos[domino].guanyarRondaParelles(jugadors)){

                colocarFitxa(Input.elegirFitxa(jugadors[torn%2],taulell));
                Output.imprimirTaulell(taulell,fitxaInicial);
                torn++;
            }
        }while (!dominos[domino].guanyadorParelles(jugadors));
    }

    public  static void algo(){

        ArrayList<String> array = new ArrayList<>();

        for (int i = 0; i < 6; i++) {

            array.add(0,"ejemplo " + i);

        }
        for (int i = 0; i < array.size(); i++) {

            System.out.println(array.get(i));

        }


    }


}
