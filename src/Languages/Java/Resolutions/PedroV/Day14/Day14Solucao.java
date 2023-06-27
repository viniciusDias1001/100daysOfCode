package src.Languages.Java.Resolutions.PedroV.Day14;

import java.util.*;

public class Day14Solucao {
    private int PRIMEIRO_NUMERO_MULTIPLICADOR = 10;
    private int SEGUNDO_NUMERO_MULTIPLICADOR = 11;
    private int MIN_NUMERO_ALEATORIO = 100_000_000;
    private int MAX_NUMERO_ALEATORIO = 999_999_999;
    private int NUMERO_DE_DIGITOS_DO_CPF =  11;


    protected String gerarDigitoMultiplicador(String numeros, int cont){
        Integer contador = cont;
        List<Integer> numerosGerados = new ArrayList<>();
       for (int i = 0; i < numeros.length(); i++){
           char caractere = numeros.charAt(i);
           Integer valor = Character.getNumericValue(caractere);
           numerosGerados.add(valor * cont);
           cont--;
       }
      if (numerosGerados.stream().reduce(0, (a ,b) -> a + b) % this.NUMERO_DE_DIGITOS_DO_CPF == 0 || numerosGerados.stream().reduce(0, (a ,b) -> a + b) % this.NUMERO_DE_DIGITOS_DO_CPF == 1){
            return concatenar(numeros, String.valueOf(numerosGerados.stream().reduce(0, (a ,b) -> a + b) % this.NUMERO_DE_DIGITOS_DO_CPF));
      }else{
        Integer restodaDivisao = numerosGerados.stream().reduce(0, (a ,b) -> a + b) % this.NUMERO_DE_DIGITOS_DO_CPF;
        return concatenar(numeros, String.valueOf(11 - restodaDivisao));
      }
    }

    protected String gerarOs9primeirosDigitos(){
        Random random = new Random();
        int min = this.MIN_NUMERO_ALEATORIO;
        int max = this.MAX_NUMERO_ALEATORIO;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }

    protected String concatenar (String textoprincipal, String textoAdicional){
            return textoprincipal.concat(textoAdicional);
    }


    protected String gerarCpf(){
        String primeirosNoveDigitos = gerarOs9primeirosDigitos();
        String cpfComPrimieroDigitoMultiplicador = gerarDigitoMultiplicador(gerarOs9primeirosDigitos(), this.PRIMEIRO_NUMERO_MULTIPLICADOR);
        String cpf = refatorarCPF(gerarDigitoMultiplicador(cpfComPrimieroDigitoMultiplicador, this.SEGUNDO_NUMERO_MULTIPLICADOR));
        if (verificarCpf(cpf)){
            return cpf;
        } else
            return "Algo deu errado ao Gerar CPF";
    }

    protected String refatorarCPF(String cpf){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cpf.length(); i++) {
            sb.append(cpf.charAt(i));
            if ((i + 1) % 3 == 0 && i != cpf.length() - 1 && (i + 1) != 9) sb.append('.');
            if ((i + 1) == 9) sb.append('-');
        }
        return cpf = sb.toString();
    }

    protected boolean verificarCpf(String cpf){
        cpf = cpf.replaceAll("\\D", "");
        if (cpf.length() != 11)
            return false;
         else if (cpf.matches("(\\d)\\1{10}"))
            return false;
         else
            return true;
    }


    protected Integer receberQuantidadeDeCpfsParaGerar(){
        Scanner entrada = new Scanner(System.in);
        while(true) {
            try {
                System.out.println("Quantos CPF deseja gerar ?");
                Integer numeroValido = entrada.nextInt();
                if (numeroValido > 0 && numeroValido < 10){
                    return numeroValido;
                } else
                    System.out.println("Digite um numero entre 1 e 10");
            }catch (InputMismatchException e){
                System.out.println("Digite apenas numeros");
                entrada.next();
            }
        }
    }


    protected void interfaceDoSistema(){
        for (int i = receberQuantidadeDeCpfsParaGerar(); i > 0; i--){
            String cpf = gerarCpf();
            System.out.println("\n"+"CPF gerado: " + gerarCpf());
            if (verificarCpf(cpf))
                System.out.println("CPF válido !!" + "\n");
            else
                System.out.println("CPF Invalido !!" + "\n");
        }
    }

    private void run(){
        interfaceDoSistema();
    }



    public static void main(String[] args) {
        Day14Solucao day = new Day14Solucao();
        day.run();
    }
}
