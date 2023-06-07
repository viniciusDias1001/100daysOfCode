package src.Languages.Java.Resolutions.PauloHenrique.Day01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Desafio01 {
    static Scanner entrada = new Scanner(System.in);
    static int numero;

    public static void main(String[] args) {

        List<Integer> lista = new ArrayList<>();
        System.out.print("Informe a quantidade de números: ");
        int qTdNumero = entrada.nextInt();
        int i = 1;

        while (lista.size() != qTdNumero) {
            System.out.print("Informe o " + i + "° núemro que seja > 0 é < 10000: ");
            numero = entrada.nextInt();
            i++;

            if (validarNumero(numero))
                lista.add(numero);
        }
        System.out.println(ordenarNumeros(lista));
    }

    public static List<Integer> ordenarNumeros(List<Integer> list) {
        List<Integer> response = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        List<Integer> pares = new ArrayList<>();

        for (Integer n : list) {
            if (n % 2 == 0) {
                pares.add(n);
            } else {
                impares.add(n);
            }
        }

        Collections.sort(impares, Collections.reverseOrder());
        Collections.sort(pares);

        response.addAll(pares);
        response.addAll(impares);

        return response;
    }

    private static boolean validarNumero(Integer n) {
        if (n > 0 && n < 10000) {
            return true;
        }
        System.out.print("Número invalido informe outro número que seja > 0 é < 10000: ");
        numero = entrada.nextInt();
        return validarNumero(numero);
    }
}
