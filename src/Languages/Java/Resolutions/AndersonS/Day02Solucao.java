package src.Languages.Java.Resolutions.AndersonS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Day02Solucao {
    private static ArrayList<ArrayList<String>> arrayDeArrayDeCompras = new ArrayList<>();
    private static int numeroDeCompras = solicitarNumeroDeLinhas();

    public static boolean verificaNumeroDeLinhas(int numero){
        if (numero >= 100 || numero < 1){
            return false;
        }
        return true;
    }

    public static void notificacaoDeErroNumeroDeLinhas(){
        System.out.println("Numero de linhas inválido! Digite um número de 1 a 100");
    }

    private static int solicitarNumeroDeLinhas(){

        Scanner input = new Scanner(System.in);

        System.out.println("Digite Numero de listas de compras de 1 a 100");
        int numeroDeLinhas = input.nextInt();
        input.nextLine();
        return numeroDeLinhas;
    }

    public static int tratadorDeNumeroDeLinhas(){

        Scanner input = new Scanner(System.in);

        boolean numeroDeLinhasAprovado = false;

        int numeroDeLinhas = 0;

        do{
            notificacaoDeErroNumeroDeLinhas();
            numeroDeLinhas = solicitarNumeroDeLinhas();

            numeroDeLinhasAprovado = verificaNumeroDeLinhas(numeroDeLinhas);

        }while(numeroDeLinhasAprovado == false);

        return numeroDeLinhas;
    }
    public static String solicitarListaCompra(){

        Scanner input = new Scanner(System.in);

        System.out.println("Digite a lista de compras separadas por espaço e com caracters menores que 20");
        return input.nextLine().toLowerCase();
    }
    public static ArrayList<String> transFormarEmArrayList(String comprasString){

        String[] comprasArray = comprasString.split(" ");

        ArrayList<String> comprasArraylist = new ArrayList<>();

        for (String compraPorCompra: comprasArray){
            comprasArraylist.add(compraPorCompra);
        }

        return comprasArraylist;
    }
    public static ArrayList<String> verificaPedidoRepetido(ArrayList<String> comprasArraylist){
        HashSet<String> comprasHashSet = new HashSet<>(comprasArraylist);
        return new ArrayList<String>(comprasHashSet);
    }

    public static void solicitarListasDeCompras(int numeorDeCompras){
        for (int i = 0; i < numeorDeCompras; i++){
            String comprasString = solicitarListaCompra();
            ArrayList<String> comprasArrayList = transFormarEmArrayList(comprasString);
            comprasArrayList = verificaPedidoRepetido(comprasArrayList);
            Collections.sort(comprasArrayList);

            arrayDeArrayDeCompras.add(comprasArrayList);
        }
    }



    public static void main(String[] args) {

        if(verificaNumeroDeLinhas(numeroDeCompras) == false){
            numeroDeCompras = tratadorDeNumeroDeLinhas();
        }

        solicitarListasDeCompras(numeroDeCompras);

        for(int i = 0; i< arrayDeArrayDeCompras.size(); i++){
            System.out.println(arrayDeArrayDeCompras.get(i));
        }
    }
}

