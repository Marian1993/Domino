package com.company;

import java.util.ArrayList;

public class Output {

    private static int posicoFitxaInicial = 0;

    public static void imprimirTaulell(ArrayList<Fitxa> taulell, int fitxaInicial){

        for (int i = 0; i < taulell.size(); i++) {

            if(taulell.size() == 1){

                System.out.println();
                System.out.println(taulell.get(i).getESQUERRA() + "\n-\n" + taulell.get(i).getDRETA());
                System.out.println();


            }else if(taulell.get(i).isDretaOcupada()  && i <= fitxaInicial){

                System.out.println();
                System.out.println(taulell.get(i).getESQUERRA() + "\n-\n" + taulell.get(i).getDRETA());
                System.out.println();

            }else if(taulell.get(i).isEsquerraOcupada()  && i <= fitxaInicial){

                System.out.println();
                System.out.println(taulell.get(i).getDRETA() + "\n-\n" + taulell.get(i).getESQUERRA());
                System.out.println();
            }else if(taulell.get(i).isDretaOcupada() && i > fitxaInicial){

                System.out.println();
                System.out.println(taulell.get(i).getDRETA() + "\n-\n" + taulell.get(i).getESQUERRA());
                System.out.println();

            }else if(taulell.get(i).isEsquerraOcupada() && i > fitxaInicial){

                System.out.println();
                System.out.println(taulell.get(i).getESQUERRA() + "\n-\n" + taulell.get(i).getDRETA());
                System.out.println();
            }
        }
    }
}
