package src.Languages.Java.Resolutions.PedroV.Day07;

import java.util.*;
import java.util.stream.Collectors;

public class Day07Solucao {
    private List<String[]> listaEntradaLetras = new ArrayList<>();
    private Integer quntidadeDeCasos = 0;
    private Map<String, Integer> valorDeLetras = new HashMap<>(26);
    private List<Integer> somaFinal = new ArrayList<>();
    String[] alfabeto = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    private void darValorAletras(){
        for (int i = 0; i < 26; i++ ){
            valorDeLetras.put( alfabeto[i],i);
        }

    }
    private void receberQuantidadeDeCasos() {
        Scanner entrada = new Scanner(System.in);
        try {
            boolean start = false;
            while (!start) {
                System.out.println("Digite quantas entradas irar mandar: ");
                Integer valor = entrada.nextInt();

                if (valor >= 1 && valor <= 100) {
                    this.quntidadeDeCasos = valor;
                    start = true;
                } else {
                    System.out.println("Digite um valor Entre 1 e 100");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite apenas números inteiros.");
            entrada.next();
        }
    }
    public void receberLetras(){
        Scanner entrada = new Scanner(System.in);
        for (int i = 0; i < quntidadeDeCasos; i++){
            System.out.println("Digite as letras para calcular Hash | Resta: " + (quntidadeDeCasos - i));
            String letras = entrada.nextLine().toUpperCase();
            char cacheLetras[] = letras.toCharArray();

            String[] arraysLetras = new String[cacheLetras.length];

            for (int j = 0; j < arraysLetras.length; j++ ){
                arraysLetras[j] = String.valueOf(cacheLetras[j]);
            }
            this.listaEntradaLetras.add(arraysLetras);
        }

    }
    public void hash() {
        String[] primeiraArray = listaEntradaLetras.get(0);
        for (int j = 0; j < this.listaEntradaLetras.size(); j++){
            for (int i = 0; i < primeiraArray.length; i++) {
                String[] primeiraArray2 = listaEntradaLetras.get(j);
                Integer posicaoAlfabeto = this.valorDeLetras.get(primeiraArray2[i]);
                this.somaFinal.add(posicaoAlfabeto);
                Integer elementoEntrada = listaEntradaLetras.indexOf(primeiraArray2);
                this.somaFinal.add(elementoEntrada);
                    this.somaFinal.add(i);
            }
        }
    }
    public void somarValoresDeLista(){
        Integer soma = this.somaFinal.stream().mapToInt(Integer::intValue).sum();
        System.out.println("O cálculo final de hash será:  " + soma);

    }
    public void run(){
        darValorAletras();
        receberQuantidadeDeCasos();
        receberLetras();
        hash();
        somarValoresDeLista();
    }
    public static void main(String[] args) {
        Day07Solucao day07Solucao = new Day07Solucao();
        day07Solucao.run();


    }

}
