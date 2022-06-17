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

            if(jugadors[i].getPuntsTotals() >= totalPuntsSolitari){

                System.out.println("El guanyador ha estat = " + jugadors[i].getNom());
                return true;
            }
        }
        return false;
    }
    public boolean guanyadorParelles(Jugador[] jugadors){

        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].getPunts() >= totalPuntsParella){

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
    public boolean guanyarRondaSolitari(Jugador[] jugadors){

        int punts = 0;
        boolean guanyador = false;

        for (int i = 0; i < jugadors.length; i++) {

            punts += jugadors[i].getPunts();

            if(jugadors[i].maBuida()){
                guanyador = true;
            }

        }
        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].maBuida()){

                jugadors[i].addPuntsTotals(punts);
                System.out.println("El jugador " + jugadors[i].getNom() + " ha guanyat = " + punts + " punts");
            }else if (guanyador){
                jugadors[i].setPunts(0);
            }
        }

        return guanyador;
    }
    public boolean guanyarRondaParelles(Jugador[] jugadors){

        int punts = 0;
        boolean guanyador = false;
        int index;

        for (int i = 0; i < jugadors.length; i++) {

            punts += jugadors[i].getPunts();

            if(jugadors[i].maBuida()){
                guanyador = true;
            }
        }
        for (int i = 0; i < jugadors.length; i++) {

            if (jugadors[i].maBuida() && jugadors.length > i + 2) {

                System.out.print("Els jugadors = " + jugadors[i].getNom() + " i " + jugadors[i + 2].getNom() + " han guanyat " + punts + " punts");

                jugadors[i].addPuntsTotals(punts);
                jugadors[i+2].addPuntsTotals(punts);

            }else{
                System.out.print("Els jugadors = " + jugadors[i].getNom() + " i " + jugadors[i - 2].getNom() + " han guanyat " + punts + " punts");
                jugadors[i].addPuntsTotals(punts);
                jugadors[i-2].addPuntsTotals(punts);
            }
            if (guanyador) {
                jugadors[i].setPunts(0);
            }
        }
        return guanyador;
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
