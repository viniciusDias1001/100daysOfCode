package src.Languages.Java.Resolutions.AndersonS.Day04;

import java.util.ArrayList;
import java.util.Scanner;

public class Day04Solucao {

    private static Scanner input = new Scanner(System.in);

    private static ArrayList<Integer> arrayListSmsInteiro = new ArrayList<>();

    private static int numeroDeCLientes;

    public static void ordenarMaiorParaMenor(ArrayList<Integer> arrayListSmsInteiro){

        ArrayList<Integer> trocaveis = new ArrayList<>();
        int trocas = 0;

        for (int i = 0; i < arrayListSmsInteiro.size() -1 ; i++){

            for (int b = i ; b < arrayListSmsInteiro.size(); b++){
                if (arrayListSmsInteiro.get(i) < arrayListSmsInteiro.get(b) && !trocaveis.contains(arrayListSmsInteiro.get(b))){
                    trocaveis.add(arrayListSmsInteiro.get(b));
                    trocas++;
                    break;
                }
            }

        }
        System.out.println(trocas);

    }

    public static void smsTransformaStringParaInteiro(String[] arraySms){

        if (boleanoTransformarEmArrayListInteiroSms(arraySms) == false){
            arraySms = validadorTransformarArrayStringParaInteiro(arraySms);
        }
        for (String smsSring: arraySms){
            Integer smsInteiro = Integer.parseInt(smsSring);
            arrayListSmsInteiro.add(smsInteiro);
        }
    }

    public static String[] validadorTransformarArrayStringParaInteiro(String[] arraySms){

        do {
            arraySms= recebeArraySMS();
        } while (boleanoTransformarEmArrayListInteiroSms(arraySms) == false);

        return arraySms;
    }

    public static boolean boleanoTransformarEmArrayListInteiroSms(String[] arraySms){

        for (String StringSms: arraySms){
            try {
                Integer smsInteiro = Integer.parseInt(StringSms);
            }catch (NumberFormatException e){
                return false;
            }
        }
        return true;

    }

    public static String[] validadorDeTamanhoArrayStringSms(String[] smsArryString) {

        if (validaTamanhoArrayStringSms(smsArryString, numeroDeCLientes) == true) {
            return smsArryString;
        } else {

            do {
                smsArryString = recebeArraySMS();
            } while (validaTamanhoArrayStringSms(smsArryString, numeroDeCLientes) == false);
            return smsArryString;
        }
    }

    public static boolean validaTamanhoArrayStringSms(String [] arrayStringSms, int numeroDeCLientes){

        if (arrayStringSms.length > numeroDeCLientes){
            return false;
        }
        return true;

    }

    public static String[] recebeArraySMS(){

        ArrayList<String> arrayListSmsString = new ArrayList<>();

        String sms = input.nextLine();

        String [] smsArrayString = sms.split(" ");

       return validadorDeTamanhoArrayStringSms(smsArrayString);

    }

    public static ArrayList<Integer> entradaSMS(){

        smsTransformaStringParaInteiro(recebeArraySMS());

        return arrayListSmsInteiro;

    }

    public static int recebeInteiro(){

        Scanner input = new Scanner(System.in);
        int numeroDeClientes = input.nextInt();
        input.nextLine();

        if (validacaoBooleanaNumeroDeClientes(numeroDeClientes) == false){
            numeroDeClientes = validadorDeEntrada();
        }

        return numeroDeClientes;

    }

    public static int validadorDeEntrada(){

        int numero;

        do{
            System.out.println("número fora da margem!");
            numero = input.nextInt();
        }while(validacaoBooleanaNumeroDeClientes(numero) == false);

        return numero;
    }

    public static boolean validacaoBooleanaNumeroDeClientes(int numeroDeClientes){

        if (numeroDeClientes < 1 || numeroDeClientes > 1000){
            return false;
        }
        return true;
    }

    public static void printEntradaNumeroDeClientes(){
        System.out.println("Digite o número de clientes");
    }

    public static void main(String[] args) {
        printEntradaNumeroDeClientes();

        numeroDeCLientes = recebeInteiro();

        System.out.println("Digite os SMS do clientes separados por espaço");
        entradaSMS();

        ordenarMaiorParaMenor(arrayListSmsInteiro);

    }

}
