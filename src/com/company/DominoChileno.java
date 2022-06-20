package com.company;

import java.util.ArrayList;

public class DominoChileno extends Domino{

    public DominoChileno(){
        this.totalPuntsSolitari = 121;
        this.totalPuntsParella = 121;
    }

    @Override
    public void empat(Jugador[] jugadors) {

        if(jugadors[0].getPuntsTotals() < jugadors[1].getPuntsTotals()){

            jugadors[0].setPunts(jugadors[1].getPunts());

        }else {
            jugadors[1].setPunts(jugadors[0].getPunts());
        }
    }
}
