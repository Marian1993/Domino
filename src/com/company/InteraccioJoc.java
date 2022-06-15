package com.company;

import java.util.ArrayList;
import java.util.Random;

public class InteraccioJoc {

    private ArrayList<Fitxa> fitxes = new ArrayList<Fitxa>();
    private ArrayList<Fitxa> taulell = new ArrayList<Fitxa>();
    private static Jugador[] jugadors;

    public void crearFitxes(){

        for (int i = 0; i < 7; i++) {

            for (int j = i; j < 7; j++) {

                fitxes.add(new Fitxa(i,j));
            }
        }
    }
    public void repartirFitxes(Jugador[] jugadors){

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

    public void colocarFitxa(Fitxa fitxa){

        if(taulell.get(0).getEsquerra() == fitxa.getEsquerra() || taulell.get(0).getEsquerra() == fitxa.getDreta()
                || taulell.get(0).getDreta() == fitxa.getEsquerra() || taulell.get(0).getDreta() == fitxa.getDreta()){

            taulell.add(0,fitxa);

        }else if(taulell.get(taulell.size()-1).getEsquerra() == fitxa.getEsquerra() || taulell.get(taulell.size()-1).getEsquerra() == fitxa.getDreta()
                || taulell.get(taulell.size()-1).getDreta() == fitxa.getEsquerra() || taulell.get(taulell.size()-1).getDreta() == fitxa.getDreta()){

            taulell.add(taulell.size(), fitxa);
        }
    }

    public static  void joc(){

        jugadors = new Jugador[Input.eleccioParticipants()];

    }


}
