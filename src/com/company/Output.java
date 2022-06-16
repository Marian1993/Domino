package com.company;

import java.util.ArrayList;

public class Output {

    public static void imprimirTaulell(ArrayList<Fitxa> taulell){

        for (int i = 0; i < taulell.size(); i++) {

            System.out.println(taulell.get(i).getEsquerra() + "-" + taulell.get(i).getDreta());
        }
    }
}
