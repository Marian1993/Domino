package com.company;

import java.util.ArrayList;

public class Jugador {

    private String nom;
    private int id;
    private ArrayList<Fitxa> fitxesJugador;
    private int punts;
    private int puntsTotals;


    public Jugador(String nom, int id){

        this.nom = nom;
        this.id = id;
        fitxesJugador = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Fitxa> getFitxesJugador() {
        return fitxesJugador;
    }

    public void addFitxa(Fitxa fitxa){
        fitxesJugador.add(fitxa);
        addPunts(fitxa.getTotal());
    }

    public void eliminarFitxa(Fitxa fitxa){
        fitxesJugador.remove(fitxa);
        llevarPunts(fitxa.getTotal());
    }

    public boolean comprovarFitxaPerSortir(Fitxa fitxa){

        for (int i = 0; i < fitxesJugador.size(); i++) {

             if(fitxesJugador.get(i).getESQUERRA() == fitxa.getESQUERRA() && fitxesJugador.get(i).getDRETA() == fitxa.getDRETA()){
                 return true;
             }
        }
        return false;
    }
    public void eliminarTotesLesFitxes(){
        fitxesJugador.removeAll(fitxesJugador);
    }

    private String fitxa(Fitxa fitxa){

        return fitxa.getESQUERRA() + "-" + fitxa.getDRETA();

    }
    public void imprimirFitxes(){

        for (int i = 0; i < fitxesJugador.size(); i++) {

            System.out.print(i + " = " + fitxa(fitxesJugador.get(i)) + "  ");

        }
    }

    public boolean maBuida(){
        return fitxesJugador.isEmpty();
    }

    public int getPunts() {
        return punts;
    }

    public void setPunts(int punts) {
        this.punts = punts;
    }

    public void addPunts(int punts) {
        this.punts += punts;
    }

    public void llevarPunts(int punts){this.punts -= punts;}

    public int getPuntsTotals() {
        return puntsTotals;
    }

    public void addPuntsTotals(int puntsTotals) {
        this.puntsTotals += puntsTotals;
    }
}
