package com.company;

import java.util.ArrayList;

public class Output {

    public static void imprimirTaulell(ArrayList<Fitxa> taulell){

        for (int i = 0; i < taulell.size(); i++) {

            System.out.println();
            System.out.println(taulell.get(i).getEsquerra() + "\n-\n" + taulell.get(i).getDreta());
            System.out.println();
        }
    }
}
