package src.Languages.Java.Resolutions.PedroV.Day18;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;


public class Day18Solucao {
    private String senhaDesajada = "#Yu4P";
    private String possibilidade;
    private Integer tentativa = 0;



    protected void decodificarSenha(int numThreads) {
        AtomicLong tempoInicial = new AtomicLong(System.currentTimeMillis());
        AtomicBoolean senhaEncontrada = new AtomicBoolean(false);

        Stream.generate(this::gerarPossibilidade)
                .parallel()
                .peek(possibilidade -> {
                    if (!senhaEncontrada.get() && senhaDesajada.equals(possibilidade)) {
                        long tempoFinal = System.currentTimeMillis();
                        long tempoTotal = tempoFinal - tempoInicial.get();
                        senhaEncontrada.set(true);
                        System.out.println("Senha encontrada: " + possibilidade);
                        System.out.println("Possibilidades geradas: " + tentativa);
                        System.out.println("Encontrado na tentativa número: " + tentativa);
                        System.out.println("Tempo de execução: " + tempoTotal / 1000.0 + " segundos");
                    }
                })
                .takeWhile(possibilidade -> !senhaEncontrada.get())
                .count();
    }



    protected List<String> dividirEspacoDeBusca() {
        List<String> subconjuntos = new ArrayList<>();
        int numSubconjuntos = 100;
        int tamanhoSubconjunto = 1000000;
        for (int i = 0; i < numSubconjuntos; i++) {
            StringBuilder subconjunto = new StringBuilder();
            for (int j = 0; j < tamanhoSubconjunto; j++) {
                subconjunto.append(gerarPossibilidade()).append("\n");
            }
            subconjuntos.add(subconjunto.toString());
        }

        return subconjuntos;
    }

    protected String gerarPossibilidade() {
        StringBuilder senha = new StringBuilder();
        Random random = new Random();
        String caracteres = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&*-+=?_~|/:;.,";
        for (int i = 0; i < 5; i++) {
            int indiceAleatorio = random.nextInt(caracteres.length());
            senha.append(caracteres.charAt(indiceAleatorio));
        }
        return senha.toString();
    }

    public static void main(String[] args) {
        Day18Solucao day = new Day18Solucao();
        day.decodificarSenha(8);
    }

}
