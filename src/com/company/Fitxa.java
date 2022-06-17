package com.company;

public class Fitxa {

    private int dreta;
    private boolean dretaOcupada;
    private int esquerra;
    private boolean esquerraOcupada;
    private boolean usada;
    private int total;

    public Fitxa(int esquerra, int dreta){

        this.usada = false;
        this.dreta = dreta;
        this.esquerra = esquerra;
        this.dretaOcupada = false;
        this.esquerraOcupada = false;
    }

    public int getDreta() {
        return dreta;
    }

    public int getEsquerra() {
        return esquerra;
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
