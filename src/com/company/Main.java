package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        InteraccioJoc joc = new InteraccioJoc();
        Jugador[] jugadors = new Jugador[4];
        jugadors[0] = new Jugador("lala",1);
        jugadors[1] = new Jugador("lolo",2);
        jugadors[2] = new Jugador("lele",3);
        jugadors[3] = new Jugador("lili",4);

        /*joc.crearFitxes();
        joc.repartirFitxes(jugadors);
        Input.elegirFitxa(jugadors[0]);*/

        InteraccioJoc.joc();
        //InteraccioJoc.algo();

    }
}
