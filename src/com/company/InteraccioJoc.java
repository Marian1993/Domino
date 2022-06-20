package com.company;

import java.util.ArrayList;

public class InteraccioJoc {

    private static ArrayList<Fitxa> fitxes = new ArrayList<Fitxa>();
    private static ArrayList<Fitxa> taulell;
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

            while (fitxesAssignades != 7) {

                Fitxa fitxa = fitxes.get((int) (Math.random() * fitxes.size()));
                jugadors[i].addFitxa(fitxa);
                fitxes.remove(fitxa);
                fitxesAssignades++;
            }
        }
    }

    public static boolean collirFitxa(Jugador jugador){

        while (!fitxes.isEmpty()) {

            Fitxa fitxa = fitxes.get((int) (Math.random() * fitxes.size()));
            jugador.addFitxa(fitxa);
            fitxes.remove(fitxa);
            if(Input.comprovarSiEsPotColocarSaFitxa(fitxa,taulell)){

                return true;
            }
        }
        return  false;
    }

    public static void colocarFitxa(Fitxa fitxa){

        if(taulell.isEmpty()){
            taulell.add(fitxa);

        }else if(taulell.get(0).getDRETA() == fitxa.getESQUERRA() && !taulell.get(0).isDretaOcupada()){

            taulell.add(0,fitxa);
            fitxa.setEsquerraOcupada(true);
            if((taulell.get(1).getDRETA() == fitxa.getESQUERRA() || taulell.get(1).getDRETA() == fitxa.getDRETA()) && aux == 0){
                taulell.get(1).setDretaOcupada(true);
                aux++;
            }
            fitxaInicial++;

        }else if(taulell.get(0).getDRETA() == fitxa.getDRETA() && !taulell.get(0).isDretaOcupada()){

            taulell.add(0,fitxa);
            fitxa.setDretaOcupada(true);
            if((taulell.get(1).getDRETA() == fitxa.getESQUERRA() || taulell.get(1).getDRETA() == fitxa.getDRETA()) && aux == 0){
                taulell.get(1).setDretaOcupada(true);
                aux++;
            }
            fitxaInicial++;

        }else if(taulell.get(0).getESQUERRA() == fitxa.getESQUERRA() && !taulell.get(0).isEsquerraOcupada() && taulell.size() > 1){

            taulell.add(0,fitxa);
            fitxa.setEsquerraOcupada(true);
            if((taulell.get(1).getESQUERRA() == fitxa.getDRETA() || taulell.get(1).getESQUERRA() == fitxa.getESQUERRA()) && aux == 0){
                taulell.get(1).setEsquerraOcupada(true);
                aux++;
            }
            fitxaInicial++;

        }else if(taulell.get(0).getESQUERRA() == fitxa.getDRETA() && !taulell.get(0).isEsquerraOcupada() && taulell.size() > 1){

            taulell.add(0,fitxa);
            fitxa.setDretaOcupada(true);
            if((taulell.get(1).getESQUERRA() == fitxa.getDRETA() || taulell.get(1).getESQUERRA() == fitxa.getESQUERRA()) && aux == 0){
                taulell.get(1).setEsquerraOcupada(true);
                aux++;
            }
            fitxaInicial++;

        }else if(taulell.get(taulell.size()-1).getESQUERRA() == fitxa.getESQUERRA() && !taulell.get(taulell.size()-1).isEsquerraOcupada()){

            if((taulell.get(taulell.size()-1).getESQUERRA() == fitxa.getESQUERRA() || taulell.get(taulell.size()-1).getESQUERRA() == fitxa.getDRETA()) && aux == 1){
                taulell.get(taulell.size()-1).setEsquerraOcupada(true);
                aux++;
            }
            taulell.add(taulell.size(), fitxa);
            fitxa.setEsquerraOcupada(true);

        }else if(taulell.get(taulell.size()-1).getESQUERRA() == fitxa.getDRETA() && !taulell.get(taulell.size()-1).isEsquerraOcupada()){

            if((taulell.get(taulell.size()-1).getESQUERRA() == fitxa.getESQUERRA() || taulell.get(taulell.size()-1).getESQUERRA() == fitxa.getDRETA()) && aux == 1){
                taulell.get(taulell.size()-1).setEsquerraOcupada(true);
                aux++;
            }
            taulell.add(taulell.size(), fitxa);
            fitxa.setDretaOcupada(true);

        }else if(taulell.get(taulell.size()-1).getDRETA() == fitxa.getESQUERRA() && !taulell.get(taulell.size()-1).isDretaOcupada() && taulell.size() > 1){

            if((taulell.get(taulell.size()-1).getDRETA() == fitxa.getDRETA() || taulell.get(taulell.size()-1).getDRETA() == fitxa.getESQUERRA()) && aux == 1){
                taulell.get(taulell.size()-1).setDretaOcupada(true);
                aux++;
            }
            taulell.add(taulell.size(), fitxa);
            fitxa.setEsquerraOcupada(true);

        } else if(taulell.get(taulell.size()-1).getDRETA() == fitxa.getDRETA() && !taulell.get(taulell.size()-1).isDretaOcupada() && taulell.size() > 1){

            if((taulell.get(taulell.size()-1).getDRETA() == fitxa.getDRETA() || taulell.get(taulell.size()-1).getDRETA() == fitxa.getESQUERRA()) && aux == 1){
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

    private static void partidaEnSolitari(int domino){

        do {
            taulell = new ArrayList<Fitxa>();
            aux = 0;
            fitxaInicial = 0;
            crearFitxes();
            repartirFitxes();
            int torn = dominos[domino].elegirQuiInizialitza(jugadors).getId();
            while(!dominos[domino].guanyarRondaSolitari(jugadors)){

                Fitxa fitxa = Input.elegirFitxa(jugadors[torn%2],taulell);
                if(fitxa != null){
                    colocarFitxa(fitxa);
                    Output.imprimirTaulell(taulell,fitxaInicial);
                }
                torn++;
            }
        }while (!dominos[domino].guanyadorSolitari(jugadors));

    }

    private static void partidaEnParelles(int domino){

        do {
            taulell = new ArrayList<Fitxa>();
            aux = 0;
            crearFitxes();
            repartirFitxes();
            int torn = dominos[domino].elegirQuiInizialitza(jugadors).getId();
            while(!dominos[domino].guanyarRondaParelles(jugadors)){

                Fitxa fitxa = Input.elegirFitxa(jugadors[torn%4],taulell);
                if(fitxa != null){
                    colocarFitxa(fitxa);
                    Output.imprimirTaulell(taulell,fitxaInicial);
                }
                torn++;
            }
        }while (!dominos[domino].guanyadorParelles(jugadors));
    }
}
