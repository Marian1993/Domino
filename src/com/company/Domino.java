package com.company;

import java.util.ArrayList;

public abstract class Domino {

    protected int totalPuntsSolitari;
    protected int totalPuntsParella;

    public Jugador elegirQuiInizialitza(ArrayList<Jugador> jugadors){

        int costats = 6;

        while (true) {

            for (int i = 0; i < jugadors.size(); i++) {

                if(jugadors.get(i).fitxesRepetides(new Fitxa(costats, costats))){

                    return jugadors.get(i);
                }
            }
            costats--;
        }
    }
    public abstract boolean empat();

    public void fiDelJocSolitari(ArrayList<Jugador> jugador){

        for (int i = 0; i < jugador.size(); i++) {

            if(jugador.get(i).getPunts() >= totalPuntsSolitari){

                jugador.get(i).setGuanyador(true);
            }
        }
    }
    public void fiDelJocParella(ArrayList<Jugador> jugador){

        for (int i = 0; i < jugador.size(); i++) {

            if(jugador.get(i).getPunts() >= totalPuntsParella){

                jugador.get(i).setGuanyador(true);
            }
        }
    }

    public int getTotalPuntsSolitari() {
        return totalPuntsSolitari;
    }

    public void setTotalPuntsSolitari(int totalPuntsSolitari) {
        this.totalPuntsSolitari = totalPuntsSolitari;
    }

    public int getTotalPuntsParella() {
        return totalPuntsParella;
    }

    public void setTotalPuntsParella(int totalPuntsParella) {
        this.totalPuntsParella = totalPuntsParella;
    }
}
