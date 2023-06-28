package src.Languages.Java.Resolutions.PedroV.Day18;
import java.util.Random;


public class Day18Solucao {
    private String senhaDesajada = "narutO#1";
    private String possibilidade;
    private Integer tentativa = 0;
    Integer cont = 0;



    protected void decodificarSenha(){
        long tempoInicial = System.currentTimeMillis();
        while (!senhaDesajada.equals(possibilidade)){
            tentativa++;
            this.possibilidade = gerarPossibilidade();
            if (senhaDesajada.equals(this.possibilidade)){
                long tempoFinal = System.currentTimeMillis();
                long tempoTotal = tempoFinal - tempoInicial;
                System.out.println("Senha encontrada: " + possibilidade);
                System.out.println("Possibilidades geradas: " + this.tentativa);
                System.out.println("Encontrado na tentiva numero: " + this.tentativa);
                System.out.println("Tempo de execução: " + tempoTotal / 1000.0 + " segundos");
            }
        }
    }

    protected String gerarPossibilidade() {
        StringBuilder senha = new StringBuilder();
        Random random = new Random();
        String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&*-+=?_~|/:;.,";
        int tamanhoSenha = 8;
        for (int i = 0; i < tamanhoSenha; i++) {
            int indiceAleatorio = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(indiceAleatorio));
        }
        return senha.toString();
    }

    public static void main(String[] args) {
        Day18Solucao day = new Day18Solucao();
        day.decodificarSenha();
    }

}
