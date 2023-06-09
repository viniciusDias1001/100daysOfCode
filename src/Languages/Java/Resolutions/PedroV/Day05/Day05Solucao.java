package src.Languages.Java.Resolutions.PedroV.Day05;


import java.util.*;

public class Day05Solucao {
    public List<Aluno> alunos;
    public Integer quant = 0;

    static class Aluno{
        public String nome;
        public Integer ficha;

        public Aluno(String nome, Integer senha){
            this.nome = nome;
            this.ficha = senha;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getFicha() {
            return ficha;
        }

        public void setFicha(Integer ficha) {
            this.ficha = ficha;
        }
    }


    public void quantidadeDeAlunos(){

        try{
            Scanner entrada = new Scanner(System.in);
            boolean start = false;
            Integer quantVdd = 0;

            while(!start){
                System.out.println("Digite a quantidade de alunos que farão da Brincadeira  obs: Entre 1 e 100");
                quantVdd = entrada.nextInt();
                if (quantVdd >= 1 && quantVdd <= 100){
                    start = true;
                }else
                    System.out.println("Digite um valor entre 1 e 100");

            }
            this.quant = quantVdd;
            this.alunos = new ArrayList<>(quantVdd);

        }catch (InputMismatchException e){
            System.out.println("Digite apenas numero");
        }

    }
    public void addAlunosNaLista(){
        Scanner entrada = new Scanner(System.in);
       for(int i = 0; i < this.quant; i++){
           System.out.println("Digite o Nome do Aluno " + i +"e a ficha  obs: Separado por espaço e ficha entre 1 e 500");
           String nomeFicha = entrada.nextLine();
           String separando [] = nomeFicha.split(" ");
           Integer fichaCerta = Integer.parseInt(separando[1]);

           if (fichaCerta >= 1 && fichaCerta <= 500 && separando[0].length() <= 30 && !separando[0].contains("´") && !separando[0].contains("~") && !separando[0].contains("^")  ){
               Aluno aluno = new Aluno(separando[0],fichaCerta);
               alunos.add(alunos.size() ,aluno);
           }else {
               System.out.println("Impossivel adicionar. Ocorreu um erro.");
           }

       }
    }
    public void JogoCompleto(){

        try{


            while (quant > 0) {
                int indiceAtual = 0;
                int indiceAlunoEliminado = 0;
                int valorAtualFicha = alunos.get(indiceAtual).getFicha();

                for (int i = 0; i < quant - 1; i++) {


                    if (valorAtualFicha % 2 == 0) {

                        indiceAlunoEliminado = (alunos.size() - (valorAtualFicha % alunos.size()) + indiceAtual) % alunos.size();

                    } else if (valorAtualFicha % 2 != 0) {

                        indiceAlunoEliminado = (valorAtualFicha % alunos.size() + indiceAtual) % alunos.size();

                    }
                    valorAtualFicha = (alunos.get(indiceAlunoEliminado).getFicha());
                    alunos.remove(indiceAlunoEliminado);

                    indiceAtual = (valorAtualFicha % 2 == 0) ?
                            ((indiceAlunoEliminado <= alunos.size() - 1) ?
                                    indiceAlunoEliminado : 0) :
                            ((indiceAlunoEliminado == 0) ?
                                    (alunos.size() - 1) : (indiceAlunoEliminado - 1));


                }
                System.out.println("Vencedor(a): " + alunos.get(0).nome);

            }

        }catch (ArithmeticException e){}

    }


    public static void main(String[] args) {
        Day05Solucao day05Solucao = new Day05Solucao();
        day05Solucao.quantidadeDeAlunos();
        day05Solucao.addAlunosNaLista();
        day05Solucao.JogoCompleto();
    }

}
