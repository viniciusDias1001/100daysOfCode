package src.Languages.Java.Resolutions.AndersonS.Day06;

import java.util.*;

public class Day06solucao {

    private static int numeroDePalavrasParaConcatenar = 2;
    private static ArrayList<String> combinacoesFinais = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static int contarNumeroDeLetrasTotais(ArrayList<String> palavras){

        int soma =0;
        for(String palvra: palavras){
            soma+=palvra.length();
        }
        return soma;
    }

    public static void concatenarPalavras(int numeroDePalavrasParaConcatenar, ArrayList<String> palavras){

        ArrayList<String> palavrasParaConcatenar;

        for (int i=0; i< palavras.size();i+=numeroDePalavrasParaConcatenar){

            int maiorIndicieDasProximasPalavras = i + numeroDePalavrasParaConcatenar -1;
            int indicieDaPalavraAtual = i;
            palavrasParaConcatenar = new ArrayList<>();

            while(indicieDaPalavraAtual<=maiorIndicieDasProximasPalavras){

                palavrasParaConcatenar.add(palavras.get(indicieDaPalavraAtual));
                indicieDaPalavraAtual++;

            }
            int numeroDeLetras = contarNumeroDeLetrasTotais(palavrasParaConcatenar);

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

    }

    public static ArrayList<String> tornarEmArrayListString(String[] vetorString){

        ArrayList<String> arrayListString = new ArrayList<>();

        for (String palvra: vetorString){
            arrayListString.add(palvra);
        }
        return arrayListString;
    }

    public static String[] RecebeEseparaStringsPorEspacoParaArray(){

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
    }

    public static ArrayList<String> recebePalavras(int numeroDeCombinacoes){

        ArrayList<String> palavrasParaConcatenar = new ArrayList<>();

        for (int i=0; i<numeroDeCombinacoes;i++){

            System.out.println("Digite as palavras para a combinação número: "+(i+1));
            ArrayList<String> palavrasEmArrayList = tornarEmArrayListString(RecebeEseparaStringsPorEspacoParaArray());

            palavrasEmArrayList.forEach(string -> palavrasParaConcatenar.add(string));
        }
        return palavrasParaConcatenar;
    }

    public static int recebeInteiro(){
        int inteiro = 0;
        boolean entradaValida = false;
        do{
            try{
                inteiro = input.nextInt();
                input.nextLine();
                if(inteiro<0){
                    throw new InputMismatchException();
                }
                entradaValida =true;
            }catch (InputMismatchException e){
                System.out.println("Digite um número válido!");
                input.nextLine();
            }
        }while(!entradaValida);

        return inteiro;
    }

    public static void run(){

        System.out.println("Digite o número de combinações");
        int numeroDeCombinacoes = recebeInteiro();

        ArrayList<String> palavrasParaConcatenar = recebePalavras(numeroDeCombinacoes);

        concatenarPalavras(numeroDePalavrasParaConcatenar, palavrasParaConcatenar);

        combinacoesFinais.forEach(palavraConcatenada -> System.out.println("Combinação número: "+ (combinacoesFinais.indexOf(palavraConcatenada)+1)+"\n"+palavraConcatenada));

    }

    public static void main(String[] args) {
        run();
    }
}
