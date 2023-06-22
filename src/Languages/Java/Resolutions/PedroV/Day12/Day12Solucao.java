package src.Languages.Java.Resolutions.PedroV.Day12;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Day12Solucao {
    private Integer numero;
    private Boolean numeroPerfeiro;


    public  void receberNumero(){
        Scanner entrada = new Scanner(System.in);
        while(true) {
                try {
                    System.out.println("Digite um numero inteiro");
                    Integer numeroValido = entrada.nextInt();
                    if (numeroValido > 0 && numeroValido < 100000){
                        setNumero(numeroValido);
                        break;
                    } else
                        System.out.println("Digite um numero entre 1 e 100000");
                }catch (InputMismatchException e){
                    System.out.println("Digite apenas numeros");
                    entrada.next();
                }
        }
    }

    public void verificarNumeroPerfeito(){
        List<Integer> numerosDivisiveis = new ArrayList<>();
        if (this.numero == 1)
            this.numeroPerfeiro = true;
        else {
            for (int i = 1; i < this.numero; i++){
                if (this.numero % i == 0)
                    numerosDivisiveis.add(i);
            }
            this.numeroPerfeiro = numerosDivisiveis.stream().reduce(0,(a , b) -> a + b).equals(this.numero)? true : false;
        }

    }

    public void saida(){
        if ( this.numeroPerfeiro == true)
            System.out.println("SIM");
        else
            System.out.println("NÃO");
    }


    public void run(){
        receberNumero();
        verificarNumeroPerfeito();
        saida();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public static void main(String[] args) {
        Day12Solucao day = new Day12Solucao();
        day.run();
    }
}
