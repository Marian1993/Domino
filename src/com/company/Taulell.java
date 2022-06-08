package com.company;

public class Taulell {

    private Casella[][] casellas;
    private final int NUMFILES = 12;
    private final int NUMCOLUMNES = 12;
    private Fitxa[] fitxes = {new Fitxa(0,0),new Fitxa(0,1),new Fitxa(0,2),new Fitxa(0,3),new Fitxa(0,4),
            new Fitxa(0,5),new Fitxa(0,6),new Fitxa(1,1),new Fitxa(1,2),new Fitxa(1,3),
            new Fitxa(1,4),new Fitxa(1,5),new Fitxa(1,6), new Fitxa(2,2),new Fitxa(2,3),
            new Fitxa(2,4),new Fitxa(2,5),new Fitxa(2,6),new Fitxa(3,3),new Fitxa(3,4),
            new Fitxa(3,5),new Fitxa(3,6),new Fitxa(4,4),new Fitxa(4,5),new Fitxa(4,6),
            new Fitxa(5,5),new Fitxa(5,6),new Fitxa(6,6)};

    public Taulell(){

        casellas =  new Casella[NUMFILES][NUMCOLUMNES];
        inicialitzarTaulell();

    }

    private void inicialitzarTaulell(){

        for (int i = 0; i < casellas.length; i++) {

            for (int j = 0; j < casellas[i].length; j++) {

                casellas[i][j] = new Casella();
            }
        }
    }
}
