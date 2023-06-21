package src.Languages.Java.Resolutions.PedroV.Day11;

import java.util.*;

public class Day11Solucao {

    private List<String[]> anagramas = new ArrayList<>();

    private String[] palavrasrecebidas;


    private void receberPalvras(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite as palvras separadas por espaço | cada palavra só pode ter até 100 letras");
        this.palavrasrecebidas = entrada.nextLine().split(" ");
        entrada.close();
    }


    public void separarAnagramas() {
        for (int i = 0; i < this.palavrasrecebidas.length; i++) {
            String palavra = this.palavrasrecebidas[i];
            Set<Character> conjunto1 = new HashSet<>();

            for (char c : palavra.toCharArray()) {
                conjunto1.add(c);
            }

            for (int j = i + 1; j < this.palavrasrecebidas.length; j++) {
                String proximaPalavra = this.palavrasrecebidas[j];
                Set<Character> conjunto2 = new HashSet<>();

                if (palavra.length() != proximaPalavra.length()) {
                    continue;
                }
                for (char c : proximaPalavra.toCharArray()) {
                    conjunto2.add(c);
                }

                if (conjunto1.equals(conjunto2)) {
                    String[] duplas = new String[2];
                    duplas[i] = palavra;
                    duplas[i+1] = proximaPalavra;

                    this.anagramas.add(duplas);

                    for (String[] anagrama : anagramas) {
                        System.out.println(Arrays.toString(anagrama));
                    }

                }
            }
        }
    }


    public static void main(String[] args) {
        Day11Solucao day = new Day11Solucao();
        day.receberPalvras();
        day.separarAnagramas();
    }
}
