package src.Languages.Java.Resolutions.AndersonS.Day06;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Day06WhithLambdas {

    private static Scanner input = new Scanner(System.in);

    private static int numeroDePalavrasParaConcatenar = 2;

    private static Consumer<String> printlnString = string -> System.out.println(string);

    private static Supplier<Integer> recebeInteiro = () -> {
        int inteiro = 0;
        boolean entradaValida = false;
        do {
            try {
                inteiro = input.nextInt();
                input.nextLine();
                if (inteiro < 0) {
                    throw new InputMismatchException();
                }
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido!");
                input.nextLine();
            }
        } while (!entradaValida);

        return inteiro;
    };

    private static Supplier<String[]> recebeESeparaStringsPorEspacoParaArray = () -> {

        String[] vetorStrings;
        boolean entradaValida;
        do{
            String stringsComEspaco = input.nextLine();
            vetorStrings = stringsComEspaco.split(" ");
            entradaValida = true;

            if(vetorStrings.length<numeroDePalavrasParaConcatenar){
                System.out.print("Número de palavras insuficiente para combinação!\nDigite novamente:");
                entradaValida = false;
            }
        }while (entradaValida == false);

        return vetorStrings;

    };

    private static Function<String[] , ArrayList<String>> tornarEmArrayList = palavrasArray -> {

        ArrayList<String> arrayListString = new ArrayList<>();

        for (String palvra: palavrasArray){
            arrayListString.add(palvra);
        }

        return arrayListString;

    };

    private static Function<Integer, ArrayList<String>> recebePalavras = numeroDeCombinacoes -> {

        ArrayList<String> palavrasParaConcatenar = new ArrayList<>();

        for (int i=0; i<numeroDeCombinacoes;i++){

            System.out.println("Digite as palavras para a combinação número: "+(i+1));
            ArrayList<String> palavrasEmArrayList = tornarEmArrayList.apply(recebeESeparaStringsPorEspacoParaArray.get());
            palavrasEmArrayList.forEach(string -> palavrasParaConcatenar.add(string));
        }
        return palavrasParaConcatenar;

    };

    private static Function<ArrayList<String>, Integer> contarNumeroDeLetrasTotais = palavras -> palavras.stream().mapToInt(String::length).sum();

    private static BiFunction<Integer, ArrayList<String>, ArrayList<String>> concatenarPalavras = (numeroDePalavrasParaConcatenar, palavras) -> {

        ArrayList<String> combinacoesFinais = new ArrayList<>();

        ArrayList<String> palavrasParaConcatenar;

        for (int i=0; i< palavras.size();i+=numeroDePalavrasParaConcatenar){

            int maiorIndicieDasProximasPalavras = i + numeroDePalavrasParaConcatenar -1;
            int indicieDaPalavraAtual = i;
            palavrasParaConcatenar = new ArrayList<>();

            while(indicieDaPalavraAtual<=maiorIndicieDasProximasPalavras){

                palavrasParaConcatenar.add(palavras.get(indicieDaPalavraAtual));
                indicieDaPalavraAtual++;

            }
            int numeroDeLetras = contarNumeroDeLetrasTotais.apply(palavrasParaConcatenar);

            StringBuilder stringBuilder = new StringBuilder();

            for (int t=0; t<numeroDeLetras;t++){


                for(int j= 0; j<palavrasParaConcatenar.size(); j++){

                    if(palavrasParaConcatenar.get(j).length()>t){
                        stringBuilder.append(palavrasParaConcatenar.get(j).charAt(t));
                    }

                }

            }
            combinacoesFinais.add(stringBuilder.toString());
        }
        return combinacoesFinais;

    };

    public static void run(){

        printlnString.accept("Digite o número de combinações");
        int numeroDeCombinacoes = recebeInteiro.get();
        ArrayList<String> palavras = recebePalavras.apply(numeroDeCombinacoes);

        ArrayList<String> combinacoesFinais = concatenarPalavras.apply(numeroDePalavrasParaConcatenar, palavras);
        combinacoesFinais.forEach(palavraConcatenada -> System.out.println("Combinação número: "+ (combinacoesFinais.indexOf(palavraConcatenada)+1)+"\n"+palavraConcatenada));
    }

    public static void main(String[] args) {
        run();
    }
}
