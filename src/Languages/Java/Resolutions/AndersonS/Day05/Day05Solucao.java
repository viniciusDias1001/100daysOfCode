package src.Languages.Java.Resolutions.AndersonS.Day05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day05Solucao {

    private static ArrayList<Aluno> alunos = new ArrayList<>();

    private static Aluno getAluno(int ficha){
        for (Aluno aluno: alunos){
            if(aluno.ficha == ficha){
                return aluno;
            }
        }
        return null;
    }

    public static void iniciarBrincadeira() {

        int ficha = alunos.get(alunos.size() - 1).getFicha();
        Aluno alunoContagemApartirDele = alunos.get(alunos.size() - 2);

        Aluno proximoAluno = null;
        Aluno alunoPassado = null;
        int proximaFicha = 0;

        while (alunos.size() != 2) {

            if (ficha % 2 == 0) {

                if (alunos.indexOf(alunoContagemApartirDele) + ficha >= alunos.size()) {

                    proximoAluno = alunos.get((alunos.indexOf(alunoContagemApartirDele) + ficha) % alunos.size());
                    proximaFicha = proximoAluno.getFicha();

                } else {

                    proximoAluno = alunos.get((alunos.indexOf(alunoContagemApartirDele) + ficha));
                    proximaFicha = proximoAluno.getFicha();
                }
            } else if (ficha % 2 != 0) {

                Collections.reverse(alunos);

                if (alunos.indexOf(alunoContagemApartirDele) + ficha >= alunos.size()) {

                    proximoAluno = alunos.get((alunos.indexOf(alunoContagemApartirDele) + ficha) % alunos.size());
                    proximaFicha = proximoAluno.getFicha();

                } else {

                    proximoAluno = alunos.get((alunos.indexOf(alunoContagemApartirDele) + ficha));
                    proximaFicha = proximoAluno.getFicha();
                }
                Collections.reverse(alunos);
            }

            alunos.remove(alunoPassado);
            alunoPassado = proximoAluno;
            ficha = proximaFicha;
            alunoContagemApartirDele = proximoAluno;

            System.out.println(alunos);
            System.out.println(alunoPassado);
        }
        alunos.remove(alunoPassado);
        System.out.println(alunos);

    }

    public static void criaAlunoComArray(String[] arrayNomeFicha){

        for (int i = 0; i < arrayNomeFicha.length; i+=2){

            String nome = arrayNomeFicha[i];
            Integer idade = Integer.parseInt(arrayNomeFicha[i+1]);

            alunos.add(0 , new Aluno(nome, idade));
        }
        System.out.println(alunos);
    }

    public static boolean validaFicha(String[] arrayNomeFicha){

        String idadeString = arrayNomeFicha[1];

        try{
            Integer idade = Integer.parseInt(idadeString);
            if(idade > 500 || idade < 0){
                return false;
            }
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public static void recebeNomeEFicha(){

        Scanner input = new Scanner(System.in);

        String nomeEFichaString;

        do{
            nomeEFichaString = input.nextLine();
        }while (validaFicha(nomeEFichaString.split(" ")) == false);

        criaAlunoComArray(nomeEFichaString.split(" "));
    }

    public static void pergutaNomeEFicha(int numeroDeAlunos){

        for ( int i = 0; i < numeroDeAlunos; i++){

            System.out.println("Nome e a ficha do aluno "+(i+1)+ " separados por um espaço");
            recebeNomeEFicha();

        }

    }

    public static boolean verificaNumeroDeAlunos(int numeroDeAlunos){

        if(numeroDeAlunos > 0 && numeroDeAlunos<100){
            return true;
        }
        return false;
    }

    public static int validaNumeroDeAlunos(int numeroDeAlunos){

        if (verificaNumeroDeAlunos(numeroDeAlunos)){
            return numeroDeAlunos;
        }
        do{
            numeroDeAlunos = recebeNumeroDeAlunos();

        }while(!verificaNumeroDeAlunos(numeroDeAlunos));
        return numeroDeAlunos;
    }

    public static int recebeNumero(){

        Scanner input = new Scanner(System.in);

        int numeroDeAlunos = input.nextInt();
        input.nextLine();
        return numeroDeAlunos;
    }

    public static int recebeNumeroDeAlunos(){

        int numeroDeAlunos = recebeNumero();

        numeroDeAlunos = validaNumeroDeAlunos(numeroDeAlunos);

        return numeroDeAlunos;
    }

    public static void run(){

        System.out.println("Indique a quantidade de aluno | limite:100");

        int numeroDeAlunos = recebeNumeroDeAlunos();

        pergutaNomeEFicha(numeroDeAlunos);

        iniciarBrincadeira();

    }

    static class Aluno{

        private String nome;
        private int ficha;

    public Aluno(String nome, int ficha) {
        this.nome = nome;
        this.ficha = ficha;
    }

        public Aluno(String nome) {
            this.nome = nome;
        }

        public int getFicha() {
            return ficha;
        }


        @Override
        public String toString() {
            return nome + " ficha: "+ ficha;
        }
    }

    public static void main(String[] args) {
        run();
    }
}
