package src.Languages.Java.Resolutions.AndersonS;

import java.util.*;

public class Day01Solucao {

    static private List<Integer> numerosPares = new ArrayList<>();
    static private List<Integer> numerosImpares = new ArrayList<>();

    public static void main(String[] args) {

        Day01Solucao day01Solucao = new Day01Solucao();

        Scanner input = new Scanner(System.in);

        System.out.println("Digite a quantiade de números ");
        int numeroRecebido = input.nextInt();

        boolean margemDeNumeroTestada = day01Solucao.testaMargemDeNumeros(numeroRecebido);

        if (margemDeNumeroTestada == false){
            numeroRecebido = day01Solucao.validadorDeEntrada(numeroRecebido);
        }

        for ( int i=0 ;i < numeroRecebido;i++){

            System.out.println("Entre com um número maior ou igual a 1 ");

            int valorInteiroDaRodada = input.nextInt();
            input.nextLine();

            if (day01Solucao.testaParidade(valorInteiroDaRodada)){
                numerosPares.add(valorInteiroDaRodada);
            }
            else{
                numerosImpares.add(valorInteiroDaRodada);
            }
        }
        System.out.println(juntarListasParesImpares((ArrayList<Integer>) numerosPares, (ArrayList<Integer>) numerosImpares));
    }
    public static int validadorDeEntrada(int numeroRecebido){

        Scanner input = new Scanner(System.in);

        boolean numeroVerificado = testaMargemDeNumeros(numeroRecebido);

        while(numeroVerificado == false){

            System.out.println("número fora da margem permitida! digite um número entre 1 e 10000");

            numeroRecebido = input.nextInt();
            input.nextLine();
            numeroVerificado = testaMargemDeNumeros(numeroRecebido);

            if (numeroVerificado == false){
                continue;
            }
        }
        return numeroRecebido;
    }
    public static boolean testaMargemDeNumeros(int numero){
        if (numero < 1 || numero>10000 ){
            return false;
        }
        return true;
    }
    public static boolean testaParidade(int numero){
        if (numero % 2 == 0){
            return true;
        }
        return false;
    }
    public static ArrayList<Integer> ordenarPares(ArrayList<Integer> numerosPares){
        Collections.sort(numerosPares);
        return numerosPares;
    }
    public static ArrayList<Integer> ordenarImpares(ArrayList<Integer> numerosImpares){
        Collections.sort(numerosImpares, Collections.reverseOrder());
        return numerosImpares;
    }
    public static ArrayList<Integer> juntarListasParesImpares(ArrayList<Integer> pares, ArrayList<Integer> impares){
       pares.addAll(impares);
       // o final da lista de pares receberá os impares (objetivo de recebimento da lista final)
       return pares;
    }
}
