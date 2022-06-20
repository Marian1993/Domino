package com.company;

import java.util.ArrayList;

public class DominoLlati extends Domino{

    public DominoLlati(){
        this.totalPuntsSolitari = 100;
        this.totalPuntsParella = 200;
    }

    @Override
    public void empat(Jugador[] jugadors) {

        if(jugadors[0].getPuntsTotals() > jugadors[1].getPuntsTotals()){

            jugadors[0].setPunts(jugadors[1].getPunts());

        }else {
            jugadors[1].setPunts(jugadors[0].getPunts());
        }
    }
}
