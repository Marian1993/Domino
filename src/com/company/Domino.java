package com.company;

public abstract class Domino {

    protected int totalPuntsSolitari;
    protected int totalPuntsParella;


    //Tots els dominos tenen la mateixa manera
    public Jugador elegirQuiInizialitza(Jugador[] jugadors){

        int costats = 6;

        while (true) {

            if(costats <= 6 && costats >= 0){

                for (int i = 0; i < jugadors.length; i++) {

                    if(jugadors[i].comprovarFitxaPerSortir(new Fitxa(costats, costats))){

                        return jugadors[i];
                    }
                }
                costats--;
            }else {
                for (int i = 0; i < jugadors.length; i++) {

                    for (int j = 6; j >= 0; j--) {

                        for (int z = 6; z >= 0; z--) {

                            if (jugadors[i].comprovarFitxaPerSortir(new Fitxa(j, z))) {

                                return jugadors[i];
                            }
                        }
                    }
                }
            }
        }
    }
    public abstract void empat(Jugador[] jugadors);

    public boolean guanyadorSolitari(Jugador[] jugadors){

        for (int i = 0; i < jugadors.length; i++) {

            if(jugadors[i].getPuntsTotals() >= totalPuntsSolitari){

                System.out.println("El guanyador de l'empat ha estat = " + jugadors[i].getNom());
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
        int index = 0;
        boolean guanyador = false;

        if(jugadors[0].getPunts() == jugadors[1].getPunts()){
            empat(jugadors);
        }
        for (int i = 0; i < jugadors.length; i++) {

            punts += jugadors[i].getPunts();

            if(jugadors[i].maBuida()){
                guanyador = true;
                index = i;
            }
            jugadors[i].setPunts(0);
            jugadors[i].eliminarTotesLesFitxes();
        }
        jugadors[index].addPuntsTotals(punts);
        System.out.println("El jugador " + jugadors[index].getNom() + " ha guanyat = " + punts + " punts");
        System.out.println("Te " + jugadors[index].getPuntsTotals() + " punts en total");

        return guanyador;
    }
    public boolean guanyarRondaParelles(Jugador[] jugadors){

        int punts = 0;
        boolean guanyador = false;
        int puntuacioMesAlta = 0;
        int indexPuntuacioMesAlta = 0;
        int index = 0;

        for (int i = 0; i < jugadors.length; i++) {

            punts += jugadors[i].getPunts();

            if(jugadors[i].getPunts() > puntuacioMesAlta){
                puntuacioMesAlta = jugadors[i].getPunts();
                indexPuntuacioMesAlta = i;
            }
            if(jugadors[i].maBuida()){
                guanyador = true;
                index = i%2;
            }
            jugadors[i].setPunts(0);
        }
        for (int i = 0; i < jugadors.length; i++) {

            if (index == i%2) {

                jugadors[i].addPuntsTotals(punts);
                System.out.println("El jugador = " + jugadors[i].getNom() + " han guanyat " + punts + " punts");
                System.out.println("Te " + jugadors[i].getPuntsTotals() + " punts en total");

            }else if(i != indexPuntuacioMesAlta && jugadors[i].getPunts() == puntuacioMesAlta){
                empat(jugadors);
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
