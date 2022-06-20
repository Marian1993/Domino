package com.company;

public class Fitxa {

    private final int DRETA;
    private boolean dretaOcupada;
    private final int ESQUERRA;
    private boolean esquerraOcupada;

    public Fitxa(int esquerra, int dreta){

        this.DRETA = dreta;
        this.ESQUERRA = esquerra;
        this.dretaOcupada = false;
        this.esquerraOcupada = false;
    }

    public int getDRETA() {
        return DRETA;
    }

    public int getESQUERRA() {
        return ESQUERRA;
    }

    public int getTotal() {
        return this.DRETA + this.ESQUERRA;
    }
    public boolean isDretaOcupada() {
        return dretaOcupada;
    }

    public void setDretaOcupada(boolean dretaOcupada) {
        this.dretaOcupada = dretaOcupada;
    }

    public boolean isEsquerraOcupada() {
        return esquerraOcupada;
    }

    public void setEsquerraOcupada(boolean esquerraOcupada) {
        this.esquerraOcupada = esquerraOcupada;
    }
}
