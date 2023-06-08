package src.Languages.Java.Resolutions.PauloHenrique.Day02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio02 {

    private static Scanner entrada = new Scanner(System.in);
    private static List<List<String>> lists = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Informe a quantidade de lista: ");
        int n = Integer.parseInt(entrada.nextLine());
        criarBlocoDeNotas(n);

        while (true) {
            int resposta = menu();
            if (resposta == 3)
                break;

            blocoNotas(resposta);
        }
    }

    private static void criarBlocoDeNotas(Integer n) {
        List<String> linha = new ArrayList<>();
        lists.add(linha);

        if (lists.size() != n)
            criarBlocoDeNotas(n);
    }

    private static int menu() {
        System.out.println("Escolha uma opcao: ");
        System.out.println("1 - ver lista de compras");
        System.out.println("2 - adicionar um produto na lista");
        System.out.println("3 - sair");
        return Integer.parseInt(entrada.nextLine());
    }

    private static void blocoNotas(int n) {
        switch (n) {
            case 1:
                System.out.println("Dentre as " + lists.size() + " listas, somente as lista com produtos sera listadas.");
                lists.stream().filter(l ->
                        !l.isEmpty()).forEach(l ->
                        System.out.println("Lista " + (lists.indexOf(l) + 1) + ": " + l));
                break;
            case 2:
                System.out.print("Qual produto voce deseja adicionar ? ");
                String produto = entrada.nextLine();

                System.out.print("Em qual lista voce deseja adicionar, lembrando que temos " + lists.size() + " Listas: ");
                int posicaoLista = (Integer.parseInt(entrada.nextLine()) - 1);

                if (validarProdutoExistente(produto, posicaoLista)) {
                    System.out.println("Este produto ja existe cadastrado nesta lista, tente adicionar outro produto ou adicionar em outra lista.");
                    blocoNotas(2);
                } else {
                    lists.get(posicaoLista).add(produto);
                }
                break;
        }
    }

    public static Boolean validarProdutoExistente(String produto, int posicaoLista) {
        return lists.get(posicaoLista).stream()
                .anyMatch(p -> p.equalsIgnoreCase(produto));
    }
}
