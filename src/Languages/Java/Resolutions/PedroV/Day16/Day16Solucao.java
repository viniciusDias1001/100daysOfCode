package src.Languages.Java.Resolutions.PedroV.Day16;
import src.Languages.Java.Resolutions.PedroV.Uteis.MetodosUteis;
import java.util.*;

public class Day16Solucao {
    public static List<Map<Integer,String>> chavesDeSubstituicao = new ArrayList<>();
    public static class Criptografador  {
        private Map<Integer,String> alfabetoComCaracter = new HashMap<>();
        private MetodosUteis uteis = new MetodosUteis();
        private int MIN_NUMERO_ALEATORIO = 65;
        private int MAX_NUMERO_ALEATORIO = 158;
        private int VALOR_INICIAL_DO_ALFABETO_MAX = 65;

        public Criptografador(){
            gerarAlfabeto();
        }
        protected String imprimirFraseCriptografada(List<Integer> chaves , Map<Integer,String> alfabeto){
            StringBuilder str  = new StringBuilder();
            for (int i  = 0; i < chaves.size(); i++){
               str.append(alfabeto.get(chaves.get(i)));
            }
            return str.toString();
        }
        protected List<Integer> gerarChavesDaStringRecebida(String fraseOriginal){
            List<Integer> listaChaves = new ArrayList<>();
            String[] listaDeLetras = tranformarStringEmList(fraseOriginal);
            for (int i = 0; i < listaDeLetras.length; i++) {
                for (Map.Entry<Integer, String> listaAlfabeto : this.alfabetoComCaracter.entrySet()) {
                    if (listaAlfabeto.getValue().equals(listaDeLetras[i])) {
                        listaChaves.add(listaAlfabeto.getKey());
                    }
                }
            }
            return listaChaves;
        }
        protected Map<Integer,String> gerarChaveSubstituicao() {
            Map<Integer,String> chaveSubstituicao = new HashMap();
            Integer contLetras = VALOR_INICIAL_DO_ALFABETO_MAX;
            List<Integer>  listafeita = gerarListaDeNumeroAleatorio();
            baguncaList(listafeita);
            for (int i= 0; i < alfabetoComCaracter.size(); i++){
                chaveSubstituicao.put(contLetras,this.alfabetoComCaracter.get(listafeita.get(i)));
                contLetras++;
            }
            chavesDeSubstituicao.add(chaveSubstituicao);

            return chaveSubstituicao;
        }
        protected String[] tranformarStringEmList(String palavras){
            String[] listaDeletras = new String[palavras.length()];
            for (int i = 0; i < palavras.length(); i++) {
                listaDeletras[i] = String.valueOf(palavras.charAt(i));
            }
            return listaDeletras;
        }
        private void gerarAlfabeto() {
            Integer contLetras = VALOR_INICIAL_DO_ALFABETO_MAX;
            Map<Character, Boolean> caracteresAdicionados = new HashMap<>();
            for (char ch = 'A'; ch <= 'z'; ch++) {
                if (!caracteresAdicionados.containsKey(ch)) {
                    alfabetoComCaracter.put(contLetras, String.valueOf(ch));
                    caracteresAdicionados.put(ch, true);
                    contLetras++;
                }
            }
            for (char ch = '!'; ch <= '~'; ch++) {
                if (!caracteresAdicionados.containsKey(ch)) {
                    alfabetoComCaracter.put(contLetras, String.valueOf(ch));
                    caracteresAdicionados.put(ch, true);
                    contLetras++;
                }
            }
        }
        private String receberStringOriginal(){
            boolean start = false;
            Scanner entrada = new Scanner(System.in);
            while (!start) {
                try{
                    System.out.println("Digite sua sequencia de letras para serem Criptografadas");
                    String letras = entrada.nextLine();
                    return letras;
                }catch (Exception e){
                    e.getMessage();
                }
            }
            return " ";
        }
        protected List<Integer> gerarListaDeNumeroAleatorio(){
           Random random = new Random();
           Set<Integer> listaSemRepeticao = new HashSet<>();
           List<Integer> listaDeNumerosAleatorios = new ArrayList<>();
           Integer numero;
           for(int i = 0; i < this.alfabetoComCaracter.size();){
               numero = random.nextInt(MAX_NUMERO_ALEATORIO - MIN_NUMERO_ALEATORIO + 1) + MIN_NUMERO_ALEATORIO;
               if (!listaSemRepeticao.contains(numero)){
                   listaSemRepeticao.add(numero);
                   i++;
               }
           }
           gerarUmaListApartirDeUmSet(listaDeNumerosAleatorios,listaSemRepeticao);
           return  listaDeNumerosAleatorios;
        }
        protected void gerarUmaListApartirDeUmSet(List<Integer> list, Set<Integer> set){
          list.addAll(set);
        }
        protected String refatorarMap(Map<Integer,String> map){
            int limite = 10;
            int contador = 0;
            String resultado = "{ ";
            for (String valor : map.values()) {
                if (contador < limite) {
                    resultado += valor + ",  ";
                    contador++;
                } else {
                    break;
                }
            }
            if (map.size() > limite) {
                resultado += "...";
            }
            resultado += " }";
            return resultado.trim();
        }
        protected void baguncaList(List<Integer> list){
            Collections.shuffle(list);
        }
        public void run(){
            String entrada = receberStringOriginal();
            List<Integer> chaves = gerarChavesDaStringRecebida(entrada);
            Map<Integer,String> alfabetoSubstituicao = gerarChaveSubstituicao();
            String mensagemCriptografada = imprimirFraseCriptografada(chaves,alfabetoSubstituicao);

            System.out.println("\n" + "Mensagem Criptografada:" + mensagemCriptografada + "\n");
            System.out.println("Chave de Substituição: " + refatorarMap(alfabetoSubstituicao) + "\n");
            System.out.println("Sua chave para Decodificação: " + chavesDeSubstituicao.size() + "\n");

        }
        public List<Map<Integer, String>> getChavesDeSubstituição() {
            return chavesDeSubstituicao;
        }
        public Map<Integer, String> getAlfabetoComCaracter() {
            return alfabetoComCaracter;
        }

    }
    public static class Descriptografador {
        private Criptografador codificador= new Criptografador();
        private MetodosUteis uteis = new MetodosUteis();
        private String palavraCriptografada = "";
        private Integer indexChaveSubstituicao;
        private Map<Integer,String> alfabetoAleatorio = new HashMap<>();
        private Map<Integer,String> alfabetoComCaracter = new HashMap<>();
        private int VALOR_INICIAL_DO_ALFABETO_MA = 65;

        public Descriptografador(){
            gerarAlfabetoTotalArrayList();
        }
        private String descriptografarMensagem(List<Integer> chaves){
            StringBuilder srb = new StringBuilder();
                for (int i = 0; i < chaves.size(); i++){
                   String lestraEncontrada = this.alfabetoComCaracter.get(chaves.get(i));
                   srb.append(lestraEncontrada);
                }
                return srb.toString();
        }
        private void receberStringOriginal(){
            boolean start = false;
            Scanner entrada = new Scanner(System.in);
            while (!start) {
                try{
                    System.out.println("Digite sua sequencia de letras para serem Descriptografadas");
                    String letras = entrada.nextLine();
                    this.palavraCriptografada = letras;

                    System.out.println("Agora digite a sua chave para Decodificação:  ");
                     this.indexChaveSubstituicao = entrada.nextInt();
                     break;

                }catch (Exception e){
                    e.getMessage();
                }
            }
        }
        private void buscarAlfabeto() {
                this.alfabetoAleatorio.putAll(codificador.getChavesDeSubstituição().get(this.indexChaveSubstituicao - 1));
                System.out.println("Chave inexistente!");

        }
        private List<Integer> gerarChaves(){
            List<Integer> listaChaves = new ArrayList<>();
            String[] listaDeLetras = tranformarStringEmList(this.palavraCriptografada);
            for (int i = 0; i < listaDeLetras.length; i++) {
                for (Map.Entry<Integer, String> listaAlfabeto : this.alfabetoAleatorio.entrySet()) {
                    if (listaAlfabeto.getValue().equals(listaDeLetras[i])) {
                            listaChaves.add(listaAlfabeto.getKey());
                    }
                }
            }
            return listaChaves;
        }
        private void gerarAlfabetoTotalArrayList() {
            Integer contLetras = VALOR_INICIAL_DO_ALFABETO_MA;
            Map<Character, Boolean> caracteresAdicionados = new HashMap<>();
            for (char ch = 'A'; ch <= 'z'; ch++) {
                if (!caracteresAdicionados.containsKey(ch)) {
                    alfabetoComCaracter.put(contLetras, String.valueOf(ch));
                    caracteresAdicionados.put(ch, true);
                    contLetras++;
                }
            }
            for (char ch = '!'; ch <= '~'; ch++) {
                if (!caracteresAdicionados.containsKey(ch)) {
                    alfabetoComCaracter.put(contLetras, String.valueOf(ch));
                    caracteresAdicionados.put(ch, true);
                    contLetras++;
                }
            }


        }
        private String[] tranformarStringEmList(String palavras){
            String[] listaDeletras = new String[palavras.length()];
            for (int i = 0; i < palavras.length(); i++) {
                listaDeletras[i] = String.valueOf(palavras.charAt(i));
            }
            return listaDeletras;
        }
        public void run(){
            receberStringOriginal();
            buscarAlfabeto();
            List<Integer> chaves = gerarChaves();
            System.out.println("Sua Mensagem Descriptografada: " + descriptografarMensagem(chaves) + "\n" + "  Caso essa não seja sua palavra, talvez sua chave para Decodificação, pode estar errada !!");
        }

    }
    public static class Menu{
        private Criptografador criptografador = new Criptografador();
        private Descriptografador descriptografador = new Descriptografador();
        public void menu(){
            Scanner entrada = new Scanner(System.in);
            Boolean pegando = false;
                while (!pegando){
                    try {
                        options();
                        Integer escolha = entrada.nextInt();
                        switch (escolha) {
                            case 1:
                                System.out.println("\n");
                                criptografador.run();
                                break;
                            case 2:
                                System.out.println("\n");
                                descriptografador.run();
                                break;
                            case 3:
                                pegando = true;
                                System.out.println("Te vejo depois :) ");
                                break;
                            default:
                                System.out.println("Opção Invalida");
                                break;
                        }
                    }catch (InputMismatchException e){
                        System.out.println("Digite Apenas uma das opções !!");
                        entrada.next();
                    }
                }


        }
        private void options() {
            System.out.println("Bem vindo ao sistema de Criptografia ;) ");
            System.out.println("[ 1 ] Criptografar");
            System.out.println("[ 2 ] Descriptografar");
            System.out.println("[ 3 ] Sair do Sistema");
        }

        private void run(){
            menu();
        }
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.run();
    }
}
