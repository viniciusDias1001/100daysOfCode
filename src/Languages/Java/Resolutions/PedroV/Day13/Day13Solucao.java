package src.Languages.Java.Resolutions.PedroV.Day13;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Day13Solucao {
    private String[] palvras;


    public void receberLista(){
            Scanner entrada = new Scanner(System.in);
            while(true) {
                try {
                    System.out.println("Digite seu texto com Até 106 caracteres.");
                    String texto = entrada.nextLine();
                    if (texto.length() <= 106){
                        this.palvras = texto.split(" ");
                        break;
                    } else
                        System.out.println("Digite um texto apenas em uma linha");
                }catch (InputMismatchException e){
                    System.out.println("Digite apenas o texto");
                    entrada.next();
                }
            }

    }

    private Integer contadorDePalavras(){
        return this.palvras.length;
    }

    public void saidaDoContador(){
        System.out.println("A quantidade de palavras nesse texto é de: " + contadorDePalavras());
    }

    public void run(){
        receberLista();
        saidaDoContador();
    }

    public static void main(String[] args) {
        Day13Solucao day = new Day13Solucao();
        day.run();
    }
}
