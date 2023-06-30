package src.Languages.Java.Resolutions.PedroV.Day17;

import java.util.*;

public class Day17Solucao {
   protected static class Disco {
       private Integer tamanho;

       public Disco(Integer tamanho){
           this.tamanho = tamanho;
       }

       public Integer getTamanho() {
           return tamanho;
       }

       public void setTamanho(Integer tamanho) {
           this.tamanho = tamanho;
       }

       @Override
       public String toString() {
           return "Disco(" +
                   + tamanho +
                   ')';
       }
   }

   public static class TorreDeHanoi{
       private Deque<Disco> primeiraTorre;
       private Deque<Disco> segundaTorre;
       private Deque<Disco> terceiraTorre;
       private Integer quantidadeDiscos;
       private int cont = 0;

       public TorreDeHanoi(){
           this.primeiraTorre = new LinkedList();
           this.segundaTorre = new LinkedList();
           this.terceiraTorre = new LinkedList();
       }

       protected String obterNomeTorre(Deque<Disco> torre) {
           if (torre == primeiraTorre) {
               return "1";
           } else if (torre == segundaTorre) {
               return "2";
           } else if (torre == terceiraTorre) {
               return "3";
           }
           return "";
       }

       protected void receberQuantidadeDeDiscos() {
           Scanner entrada = new Scanner(System.in);
           while(true) {
               try {
                   System.out.println("Quantos Discos deseja Adicionar ?");
                   Integer numeroValido = entrada.nextInt();
                   if (numeroValido > 0 && numeroValido < 100){
                      this.quantidadeDiscos = numeroValido;
                      break;
                   } else
                       System.out.println("Digite um numero entre 1 e 10");
               }catch (InputMismatchException e){
                   System.out.println("Digite apenas numeros");
                   entrada.next();
               }
           }
       }
       protected List<Disco> adicionarTamanhoDosDiscos(){
           Disco disco = new Disco(this.quantidadeDiscos);
           List<Disco> listaDiscos = new ArrayList<>();
           listaDiscos.add(disco);
            for (int i = 0; i < quantidadeDiscos -1; i++){
                Disco discos = new Disco(quantidadeDiscos - (i + 1));
                listaDiscos.add(discos);
            }
            return listaDiscos;
       }
       protected void addDiscosNaTorre(List<Disco> discos){
           for (int i = 0; i < discos.size(); i++){
               this.primeiraTorre.addFirst(discos.get(i));
           }
       }

       protected void resolverTorreDeHanoi(int quantidadeDiscos, Deque<Disco> origem, Deque<Disco> destino, Deque<Disco> auxiliar) {
           if (quantidadeDiscos == 1) {
               Disco disco = origem.removeFirst();
               destino.addFirst(disco);
               System.out.println("Mover disco " + disco.toString() + " da Torre " + obterNomeTorre(origem) + " para a Torre " + obterNomeTorre(destino));
           } else {
               resolverTorreDeHanoi(quantidadeDiscos - 1, origem, auxiliar, destino);
               resolverTorreDeHanoi(1, origem, destino, auxiliar);
               resolverTorreDeHanoi(quantidadeDiscos - 1, auxiliar, destino, origem);
           }
       }

       protected void saida(){
           System.out.println("\n");
           System.out.println("Torre 1");
           primeiraTorre.forEach(System.out::println);
           System.out.println("\n");
           System.out.println("Torre 2");
           segundaTorre.forEach(System.out::println);
           System.out.println("\n");
           System.out.println("Torre 3");
           terceiraTorre.forEach(System.out::println);
       }
       protected void jogo(){
           receberQuantidadeDeDiscos();
           addDiscosNaTorre(adicionarTamanhoDosDiscos());
           System.out.println("\n" + "Sequencias de passos: ");
           resolverTorreDeHanoi(this.quantidadeDiscos,this.primeiraTorre,this.terceiraTorre,this.segundaTorre);
           saida();
       }
   }

       public static void main(String[] args) {
       TorreDeHanoi torreDeHanoi = new TorreDeHanoi();
       torreDeHanoi.jogo();


    }

}
