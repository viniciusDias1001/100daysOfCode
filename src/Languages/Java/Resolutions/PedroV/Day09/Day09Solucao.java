package src.Languages.Java.Resolutions.PedroV.Day09;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day09Solucao {
    private Integer quantidadeDeCartasNaPilhas = 0;

    private List<Integer> linhaIntegers = new ArrayList<>();

    private List<Integer> zeroEum = new ArrayList<>();



    public void receberQuantidadeDePilhas(){
        Scanner entrada = new Scanner(System.in);
        int input;

        while (true) {
            System.out.println("Digite um valor inteiro entre 0 e 100: |  Quantidade de cartas na Pilhas");
            if (entrada.hasNextInt()) {
                input = entrada.nextInt();
                if (input >= 0 && input <= 100) {
                    this.quantidadeDeCartasNaPilhas = input;
                    break;
                } else {
                    System.out.println("Valor inválido. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Tente novamente.");
                entrada.next();
            }
        }


    }

    public void gerarPilhasEadicionarListaZeroEum(){
        Scanner entrada = new Scanner(System.in);
        String linha;
        int sum = 0;
        for (int j = 0; j < this.quantidadeDeCartasNaPilhas; j++){
            while(true){
                System.out.println("Digite Tres valores inteiros entre 0 e 9");
                linha = entrada.nextLine();
                if (linha.matches("[\\d\\s]+")) {
                    String[] listaNumeros = linha.split(" ");
                    for (int i = 0; i < listaNumeros.length ; i++){
                        this.linhaIntegers.add(i,Integer.parseInt(listaNumeros[i]));
                    }
                    for (int k = 0; k < this.linhaIntegers.size(); k++){
                        sum += linhaIntegers.get(k);
                    }
                    if (sum % 3 == 0)
                        this.zeroEum.add(1);
                     else
                        this.zeroEum.add(0);

                    this.linhaIntegers.clear();
                    sum = 0;
                    break;
                } else {
                    System.out.println("Valor inválido. Tente novamente.");
                }

                }
            }
        }


        public void mostrarDerrotaouVitoria(){
            if (this.zeroEum.contains(0)){
                System.out.println("Saida: ");
                System.out.println("0  |" + " Não foi dessa vez !!");
            }else{
                System.out.println("Saida: ");
                System.out.println("1  | " + "  Vencedor");
            }

        }

        public void run(){
            receberQuantidadeDePilhas();
            gerarPilhasEadicionarListaZeroEum();
            mostrarDerrotaouVitoria();
        }


    public static void main(String[] args) {
        Day09Solucao day09Solucao = new Day09Solucao();
        day09Solucao.run();

    }
}





