package src.Languages.Java.Resolutions.PedroV.Uteis;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MetodosUteis {

    public Integer receberQuantidadeDeCasosAte100(Integer quant) {
        Scanner entrada = new Scanner(System.in);
        try {
            boolean start = false;
            while (!start) {
                System.out.println("Digite quantas entradas irar mandar: ");
                Integer valor = entrada.nextInt();

                if (valor >= 1 && valor <= 100) {
                     quant = valor;
                    start = true;
                } else {
                    System.out.println("Digite um valor Entre 1 e 100");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite apenas números inteiros.");
            entrada.next();
        }
        return quant;
    }


    public String[] receberFraseEAddEmListaStrings() {
        boolean start = false;
        Scanner entrada = new Scanner(System.in);
        while (!start) {
            try{
                System.out.println("Digite sua frase");
                String cifra = entrada.nextLine();
                if (cifra.matches("[a-zA-Z ]+")){
                    String frase =  retirarEspacos(cifra);
                    String [] letras = new String[cifra.length()];
                    for (int i = 0; i < frase.length(); i++) {
                        letras[i] = String.valueOf(frase.charAt(i));
                    }
                    return letras;
                }else
                    System.out.println("Digite apenas letras");

            }catch (Exception e){
                e.getMessage();
            }
        }
        return null;
    }

    public String retirarEspacos(String frase){
        return  frase.replaceAll("\\s+", "");
    }

    public static ArrayList<String> gerarAlfabeto() {
        ArrayList<String> alphabetList = new ArrayList<>();
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            alphabetList.add(String.valueOf(ch));
        }
        return alphabetList;
    }

    public String concatenar (String textoprincipal, String textoAdicional){
        return textoprincipal.concat(textoAdicional);
    }

    public String[] tranformarStringEmList(String palavras){
        String[] listaDeletras = new String[palavras.length()];
        for (int i = 0; i < palavras.length(); i++) {
            listaDeletras[i] = String.valueOf(palavras.charAt(i));
        }
        return listaDeletras;
    }




}
