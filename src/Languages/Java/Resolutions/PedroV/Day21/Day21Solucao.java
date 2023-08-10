package src.Languages.Java.Resolutions.PedroV.Day21;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Day21Solucao {

    private List<Integer> numerosEntrada = new ArrayList<>();
    private int contadorThreads = 0;


    public void receberLista(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a lista de numeros para verificação | digite os numeros separados por espaços ex: 13 507 991 809 1555");
        String[] numeros = entrada.nextLine().split(" ");
        for (String numString : numeros) {
            Integer num = Integer.parseInt(numString);
            numerosEntrada.add(num);
        }
        entrada.close();
    }

    public void verificarNumerosPrimos() {
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<String>> resultados = new ArrayList<>();

        for (int i = 0; i < this.numerosEntrada.size(); i++) {
            int numero = numerosEntrada.get(i);
            Future<String> resultado = executor.submit(() -> {
                contadorThreads++;
                boolean primo = isPrime(numero);
                return "O número " + numero + (primo ? " é primo." : " não é primo.");
            });
            resultados.add(resultado);
        }
        for (Future<String> resultado : resultados) {
            try {
                System.out.println(resultado.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        System.out.println("Total de threads criadas: " + contadorThreads);
    }


    public boolean isPrime(Integer numero) {
        if (numero <= 1) {
            return false;
        }
        if (numero <= 3) {
            return true;
        }
        if (numero % 2 == 0 || numero % 3 == 0) {
            return false;
        }

        for (int i = 5; i * i <= numero; i += 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public  void run(){
        receberLista();
        verificarNumerosPrimos();
    }

    public static void main(String[] args) {
        Day21Solucao day21Solucao = new Day21Solucao();
        day21Solucao.run();
    }
}
