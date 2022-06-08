package com.company;

import java.util.ArrayList;

public class DominoChileno extends Domino{

    public DominoChileno(){
        this.totalPuntsSolitari = 121;
        this.totalPuntsParella = 121;
    }

    @Override
    public boolean empat() {
        return false;
    }
}
