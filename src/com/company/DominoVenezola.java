package com.company;

import java.util.ArrayList;

public class DominoVenezola extends Domino{

    public DominoVenezola(){
        this.totalPuntsSolitari = 75;
        this.totalPuntsParella = 100;
    }

    @Override
    public void empat(Jugador[] jugadors) {

        ArrayList<Fitxa> fitxes = new ArrayList<Fitxa>();
        int[] puntuacions = new int[jugadors.length];
        int numMesAlt = 0;
        int indexGuanyador =0;
        int puntstotals = 0;

        for (int i = 0; i < 7; i++) {

            for (int j = i; j < 7; j++) {

                fitxes.add(new Fitxa(i,j));
            }
        }

        for (int i = 0; i < jugadors.length; i++) {

            Fitxa fitxa = fitxes.get((int) (Math.random() * fitxes.size()));
            System.out.println("Al jugador " + jugadors[i].getNom() + "ha tret una fitxa amb " + fitxa.getTotal() + " punts");
            puntuacions[i] = fitxa.getTotal();
            puntstotals = jugadors[i].getPunts();
        }

        for (int i = 0; i < puntuacions.length; i++) {

            if(puntuacions[i] > numMesAlt){

                numMesAlt = puntuacions[i];
                indexGuanyador = i;
            }
        }
        System.out.println("El jugador " + jugadors[indexGuanyador].getNom() + "es el que ha guanyat");
        jugadors[indexGuanyador].addPuntsTotals(puntstotals);
    }
}
