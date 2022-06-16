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

    public void tovarGuanyadorSolitari(Jugador[] jugadors){

        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].getPunts() >= totalPuntsSolitari){

                jugadors[i].setGuanyador(true);
            }
        }
    }
    public void trovarGuanyadorParelles(Jugador[] jugadors){

        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].getPunts() >= totalPuntsParella){

                jugadors[i].setGuanyador(true);
            }
        }
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
