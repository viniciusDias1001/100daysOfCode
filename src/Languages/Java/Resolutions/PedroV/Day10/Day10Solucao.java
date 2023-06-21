package src.Languages.Java.Resolutions.PedroV.Day10;

import java.util.*;

public class Day10Solucao {

    private List<Integer> listadeNumeros = new ArrayList<>();
    private List<Integer> listadeNumerosCopia = new ArrayList<>();
    String[] numerosSeparados = null;


    private void receberLista() {
        Scanner entrada = new Scanner(System.in);
        Boolean start = false;
        try {
            while (!start) {
                System.out.println("Digite a lista separadas por espaço ");
                String listaNumeros = entrada.nextLine();

                if (listaNumeros.matches("[0-9\\s]+")) {
                    String[] numeros = listaNumeros.split(" ");
                    start = true;
                    this.numerosSeparados = numeros;

                } else {
                    System.out.println("Digite um valor Entre -1000 e 1000");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite apenas números inteiros.");
            entrada.next();
        }

    }


    public void transformaListaDeStringsEmInteger() {
        for (String string : this.numerosSeparados) {
            this.listadeNumeros.add(Integer.parseInt(string));
            this.listadeNumerosCopia.add(Integer.parseInt(string));
        }

    }

    public void eliminarNumerosRepetidos() {
        for (Integer numero : this.listadeNumeros) {
            if (Collections.frequency(this.listadeNumeros, numero) > 1) {
                listadeNumerosCopia.remove(numero);
            }
        }
    }

    public void saidaDeNumero(){
        System.out.println("Numero não repetido:");
        this.listadeNumerosCopia.forEach(System.out::print);
    }

    public void run(){
        receberLista();
        transformaListaDeStringsEmInteger();
        eliminarNumerosRepetidos();
        saidaDeNumero();
    }


    public static void main(String[] args) {
        Day10Solucao day = new Day10Solucao();
        day.run();
    }

}
