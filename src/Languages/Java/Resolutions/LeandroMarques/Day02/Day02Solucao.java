package src.Languages.Java.Resolutions.LeandroMarques.Day02;

import java.util.*;

public class Day02Solucao {
    private List<List<String>> todasAsListas = new ArrayList<>();
    //exclua os itens duplicados da lista de compras e que os ordene alfabeticamente.

    public void criadorDelistas(int quantidadeDeListasParaCriar) {
        for (int i = 0; i < quantidadeDeListasParaCriar; i++) {
            List<String> novaLista = new ArrayList<>(1000);
            todasAsListas.add(novaLista);
        }
    }

    public void selecionarListaEAddObjetos(int index, String objeto) {
        List<String> listaBuscada = todasAsListas.get(index);
        Collections.sort(listaBuscada);
        listaBuscada.add(objeto);
        Collections.sort(listaBuscada);
    }

    public List<List<String>> getTodasAsListas() {
        return todasAsListas;
    }

    public static void main(String[] args) {
        Day02Solucao day2 = new Day02Solucao();
        Scanner input = new Scanner(System.in);
        int escolhaDoUsuario;

        System.out.print("Quantas listas de compras você \ndeseja organizar (menor que 100): ");
        int quantidadeDeListasParaCriar = input.nextInt();
        if (quantidadeDeListasParaCriar > 0 && quantidadeDeListasParaCriar < 100) {
            day2.criadorDelistas(quantidadeDeListasParaCriar);
        } else {
            System.out.println("Quantidade maior que a capacidade.");
        }

        do {
            System.out.println("[1]addObjetoNaLista [2]printAllList [3]exit");
            System.out.print("O que deseja fazer: ");
            escolhaDoUsuario = input.nextInt();

            switch (escolhaDoUsuario) {
                case 1 -> {
                    System.out.print("Digite o objeto: ");
                    String objeto = input.next().toLowerCase();

                    System.out.print("Digite o index: ");
                    int index = input.nextInt();

                    day2.selecionarListaEAddObjetos(index, objeto);
                }
                case 2 -> {
                    System.out.println(day2.getTodasAsListas());
                }
            }
        } while (escolhaDoUsuario == 1 || escolhaDoUsuario == 2);

        input.close();
    }
}
