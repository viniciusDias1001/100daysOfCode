package src.Languages.Java.Resolutions.PedroV.Day06;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Day06Solucao {
    public Integer quantDeJuncoes = 0;
    public List<String> palavrasCombinadas = new ArrayList<>();
    public char[] chars;
    public List<String> palvraFinal = new ArrayList<>();


    public void receberQuantDeJucoes() {
        Scanner entrada = new Scanner(System.in);
        boolean entradaValida = false;

        while (!entradaValida) {

            System.out.println("Digite quantas palavras vai juntar");
            try {
                Integer entradaQuant = entrada.nextInt();
                if (entradaQuant >= 0) {
                    this.quantDeJuncoes = entradaQuant;
                    entradaValida = true;
                } else {
                    System.out.println("Digite apenas números positivos.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite apenas números inteiros.");
                entrada.next();
            }
        }
        }

    public void juntarPalavras() {

        Scanner entrada = new Scanner(System.in);

        for(int i = 1; i <= quantDeJuncoes; i++) {
            System.out.println("Digite duas palavras separadas por espaço");
            StringBuilder analise = new StringBuilder();
            String[] palavras = entrada.nextLine().split(" ");

            int maxSize = Math.max (
                    palavras[0].length(),
                    palavras[1].length());

            for(int dados = 0; dados < maxSize; dados++) {

                if(dados < palavras[0].length()) {

                    analise.append(palavras[0].charAt(dados));

                }

                if(dados < palavras[1].length()) {

                    analise.append(palavras[1].charAt(dados));

                }

            }

            System.out.println("Palavra Junta");
            System.out.println(analise.toString());

        }

    }




    public void run(){
        receberQuantDeJucoes();
        juntarPalavras();
    }


    public static void main(String[] args) {
        Day06Solucao day06Solucao = new Day06Solucao();
        day06Solucao.run();
    }


}
