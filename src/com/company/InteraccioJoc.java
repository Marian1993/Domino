package com.company;

import java.util.ArrayList;
import java.util.Random;

public class InteraccioJoc {

    private ArrayList<Fitxa> fitxes = new ArrayList<Fitxa>();

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



}
