package com.company;

import java.util.ArrayList;

public class Jugador {

    private String nom;
    private int id;
    private ArrayList<Fitxa> fitxesJugador;
    private int punts;
    private boolean guanyador;


    public Jugador(String nom, int id){

        this.nom = nom;
        this.id = id;
        this.guanyador = false;
        fitxesJugador = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
    }

    public boolean fitxesRepetides(Fitxa fitxa){

        for (int i = 0; i < fitxesJugador.size(); i++) {

             if(fitxesJugador.get(i).getEsquerra() == fitxa.getEsquerra() && fitxesJugador.get(i).getDreta() == fitxa.getDreta()){
                 return true;
             }
        }
        return false;
    }

    private String fitxa(Fitxa fitxa){

        return fitxa.getEsquerra() + "-" + fitxa.getDreta();

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

    public void addPunts(int punts) {
        this.punts += punts;
    }

    public boolean isGuanyador() {
        return guanyador;
    }

    public void setGuanyador(boolean guanyador) {
        this.guanyador = guanyador;
    }
}
