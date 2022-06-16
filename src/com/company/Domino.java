package com.company;

public abstract class Domino {

    protected int totalPuntsSolitari;
    protected int totalPuntsParella;


    //Tots els dominos tenen la mateixa manera
    public Jugador elegirQuiInizialitza(Jugador[] jugadors){

        int costats = 6;

        while (true) {

            for (int i = 0; i < jugadors.length; i++) {

                if(jugadors[i].comprovarFitxaPerSortir(new Fitxa(costats, costats))){

                    return jugadors[i];
                }
            }
            costats--;
        }
    }
    public abstract boolean empat();

    public boolean guanyadorSolitari(Jugador[] jugadors){

        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].getPunts() >= totalPuntsSolitari){

                jugadors[i].setGuanyador(true);
                System.out.println("El guanyador ha estat = " + jugadors[i].getNom());
                return true;
            }
        }
        return false;
    }
    public boolean guanyadorParelles(Jugador[] jugadors){

        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].getPunts() >= totalPuntsParella){

                jugadors[i].setGuanyador(true);

                if(jugadors.length >= i+2){

                    System.out.print("Els guanyadors han estat = " + jugadors[i].getNom() + " i " + jugadors[i+2].getNom());

                }else {
                    System.out.print("Els guanyadors han estat = " + jugadors[i].getNom() + " i " + jugadors[i-2].getNom());

                }
                return true;
            }
        }
        return false;
    }
    public boolean guanyarRonda(Jugador[] jugadors){

        int punts = 0;

        for (int i = 0; i < jugadors.length; i++) {

             if(!jugadors[i].maBuida()){

                 punts += jugadors[i].getPunts();
                 jugadors[i].setPunts(0);
             }
        }
        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].maBuida()){

                jugadors[i].addPuntsTotals(punts);
                return true;
            }
        }
        return false;
    }

    public boolean fiDelJoc(Jugador[]jugadors){

        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].isGuanyador()){
                System.out.println("El jugador " );
                return true;
            }
        }
        return false;
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
