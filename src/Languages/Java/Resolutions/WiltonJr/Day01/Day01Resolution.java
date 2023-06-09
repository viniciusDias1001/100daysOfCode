package src.Languages.Java.Resolutions.WiltonJr.Day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day01Resolution {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        List<Integer> listNumeros = new ArrayList<>();
        int numeroLinhas;
        do {
            System.out.print("Digite a quantidade de linhas: ");
            numeroLinhas = input.nextInt();
            if (numeroLinhas < 1 || numeroLinhas > 10000) {
                numeroLinhas = 0;
            }
        } while (numeroLinhas == 0);
        for (int i = 1; i <= numeroLinhas; i++) {
            System.out.print("Digite o " + i + "º numero: ");
            listNumeros.add(input.nextInt());
        }
        for (List l : ordenarNumeros(listNumeros)) {
            System.out.println();
            for (int i = 0; i < l.size(); i++) {
                System.out.println(l.get(i));
            }
        }


    }

    public static List<List<Integer>> ordenarNumeros(List<Integer> list) {
        List<Integer> numeroPares = new ArrayList<>();
        List<List<Integer>> resposta = new ArrayList<>();
        List<Integer> numeroImpares = new ArrayList<>();

        for (Integer n : list) {
            if (n % 2 == 0) {
                numeroPares.add(n);
            } else {
                numeroImpares.add(n);
            }
        }

        Collections.sort(numeroPares);
        Collections.sort(numeroImpares, Collections.reverseOrder());
        resposta.add(numeroPares);
        resposta.add(numeroImpares);
        return resposta;
    }
}
