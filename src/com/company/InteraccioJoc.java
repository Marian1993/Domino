package com.company;

import java.util.ArrayList;

public class InteraccioJoc {

    private ArrayList<Fitxa> fitxes = new ArrayList<Fitxa>();

    public void crearFitxes(){

        for (int i = 0; i < 7; i++) {

            for (int j = i; j < 7; j++) {

                fitxes.add(new Fitxa(i,j));
            }
        }
    }


}
