package com.company;

import java.util.ArrayList;

public class DominoLlati extends Domino{

    public DominoLlati(){
        this.totalPuntsSolitari = 100;
        this.totalPuntsParella = 200;
    }

    @Override
    public boolean empat() {
        return false;
    }
}
