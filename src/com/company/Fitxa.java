package com.company;

public class Fitxa {

    private int dreta;
    private int esquerra;
    private boolean usada;
    private int total;

    public Fitxa(int dreta, int esquerra){

        this.usada = false;
        this.dreta = dreta;
        this.esquerra = esquerra;
    }

    public int getDreta() {
        return dreta;
    }

    public void setDreta(int dreta) {
        this.dreta = dreta;
    }

    public int getEsquerra() {
        return esquerra;
    }

    public void setEsquerra(int esquerra) {
        this.esquerra = esquerra;
    }

    public int getTotal() {
        return this.dreta + this.esquerra;
    }

    public boolean isUsada() {
        return usada;
    }

    public void setUsada(boolean usada) {
        this.usada = usada;
    }
}
