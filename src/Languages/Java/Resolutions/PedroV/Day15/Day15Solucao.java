package src.Languages.Java.Resolutions.PedroV.Day15;

import java.util.*;

public class Day15Solucao {
    private Integer VALOR_INICIAL_DO_ALFABETO = 65;
    private Map<Integer,String> alfabeto = new HashMap<>(26);

    protected String descriptografarStringParaOriginal(List<Integer> chaves){
        String fraseDescriptografada = "";
        substituirChaves(chaves);
            for (int i  = 0; i < chaves.size(); i++){
              fraseDescriptografada =  concatenar(fraseDescriptografada,this.alfabeto.get(chaves.get(i)));
            }
            return fraseDescriptografada;
    }

    private void substituirChaves(List<Integer> chaves){
        chaves.replaceAll(chave -> chave == 65 ? 88 : chave == 66 ? 89 : chave == 67 ? 90 : chave - 3);
    }

    protected List<Integer> descriptografarStringParaSuasChaves(String[] listaDeletras) {
        criarAlfabetoArrayList();
        List<Integer> listaChaves = new ArrayList<>();
        for (int i = 0; i < listaDeletras.length; i++) {
            for (Map.Entry<Integer, String> listaAlfabeto : this.alfabeto.entrySet()) {
                if (listaAlfabeto.getValue().equals(listaDeletras[i])) {// RECEBE A LETRA E BUSCA A CHAVE NO MAP
                    listaChaves.add(listaAlfabeto.getKey());
                }
            }

        }
        return listaChaves;
    }

    private String concatenar (String textoprincipal, String textoAdicional){
        return textoprincipal.concat(textoAdicional);
    }

    private void criarAlfabetoArrayList() {
        ArrayList<String> alphabetList = new ArrayList<>();
        Integer cont = VALOR_INICIAL_DO_ALFABETO;
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            this.alfabeto.put(cont,String.valueOf(ch));
            cont++;
        }
    }

    protected String[] receberFraseCifrada() {
            boolean start = false;
            Scanner entrada = new Scanner(System.in);
            while (!start) {
                try{
                    System.out.println("Digite sua sequencia de letras em cifra de César");
                    String cifra = entrada.nextLine();
                    if (cifra.matches("[a-zA-Z ]+")){
                        String cifraRefatorada =  retirarEspacos(cifra).toUpperCase();
                        String [] letras = new String[cifra.length()];
                        for (int i = 0; i < cifraRefatorada.length(); i++) {
                            letras[i] = String.valueOf(cifraRefatorada.charAt(i));
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

    private String retirarEspacos(String frase){
        return  frase.replaceAll("\\s+", "");
    }

    public void run(){
        String[] frase = receberFraseCifrada();
        List<Integer> chaves = descriptografarStringParaSuasChaves(frase);
        String fraseOriginal = descriptografarStringParaOriginal(chaves);
        System.out.println(fraseOriginal);
    }


    public static void main(String[] args) {
        Day15Solucao day = new Day15Solucao();
        day.run();
    }



}
