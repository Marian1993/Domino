package com.company;

public class Taulell {

    private Casella[][] casellas;
    private final int NUMFILES = 12;
    private final int NUMCOLUMNES = 12;

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

    public Casella[][] colocarFitxa(){

        return  casellas;
    }

}
