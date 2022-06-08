package com.company;

import java.util.ArrayList;

public class DominoVenezola extends Domino{

    public DominoVenezola(){
        this.totalPuntsSolitari = 75;
        this.totalPuntsParella = 100;
    }

    @Override
    public boolean empat() {
        return false;
    }
}
