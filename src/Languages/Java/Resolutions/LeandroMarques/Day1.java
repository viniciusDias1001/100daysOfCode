package src.Languages.Java.Resolutions.LeandroMarques;
import java.util.*;

public class Day1 {
    private static List<Integer> listPares = new ArrayList<>();
    private static List<Integer> listImpares = new ArrayList<>();



    public static void ordenaNumerosNasLista(int addNumero) {
        if(addNumero % 2 == 0 && addNumero < 10000 && addNumero > 0){
            listPares.add(addNumero);
        } else if (addNumero % 2 != 0 && addNumero < 10000 && addNumero > 0)
            listImpares.add(addNumero);
        }

        public void adicionandoNumerosNaLista(int quantosNumerosVaoSerAdicionados) {
            Scanner input = new Scanner(System.in);
            int entrada;

            for (int j = 0; j < quantosNumerosVaoSerAdicionados; j++) {
                System.out.printf("Número %d: ", j + 1);
                entrada = input.nextInt();
                ordenaNumerosNasLista(entrada);
            }
        }

        public static List listaCompletaDeParesEImpares(List<Integer> listaDeParesOuImpares, List<Integer> listaDeImparesOuPares){
        List<Integer> todasAsListas = new ArrayList<>();

            Collections.sort(listPares);
            Collections.sort(listImpares, Comparator.reverseOrder());

            todasAsListas.addAll(listPares);
            todasAsListas.addAll(listImpares);

            return todasAsListas;
        }

    public static void main(String[] args) {
        Day1 solucao = new Day1();
        Scanner input = new Scanner(System.in);
        int quantosNumerosVaoSerAdicionados;

            do {
                System.out.print("Quantos numeros vai escrever: ");
                quantosNumerosVaoSerAdicionados = input.nextInt();
            } while (quantosNumerosVaoSerAdicionados < 0);

        System.out.println("Digite um número inteiro não negativo e abaixo de 10.000 e maior que 0!");
        solucao.adicionandoNumerosNaLista(quantosNumerosVaoSerAdicionados);

        System.out.println(listaCompletaDeParesEImpares(listImpares, listPares));
        //vai

    }
}
