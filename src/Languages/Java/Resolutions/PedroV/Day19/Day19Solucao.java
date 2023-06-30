package src.Languages.Java.Resolutions.PedroV.Day19;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Day19Solucao {
    private Date dataInicial = null;
    private Date dataFinal;

    protected void receberDatas() {
        boolean start = false;
        Scanner entrada = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        try {
            while (!start) {
                System.out.println("Digite a Data Inicial no estilo:  dd/mm/yyyy");
                String dataInicialValida = entrada.nextLine();
                System.out.println("Digite a Data Final no estilo:  dd/mm/yyyy");
                String dataFinalValida = entrada.nextLine();

                if (dataInicialValida.matches("^[0-9/]+$") && dataFinalValida.matches("^[0-9/]+$")) {
                    this.dataInicial = format.parse(dataInicialValida);
                    this.dataFinal = format.parse(dataFinalValida);
                    start = true;
                } else {
                    System.out.println("Digite apenas a data no formato correto.");
                }
            }
        } catch (ParseException e) {
            System.out.println("Formato da data incorreto");
            e.printStackTrace();
        }

        entrada.close();
    }

    protected List<Long> contadorDias(Date inicial, Date fim){
        List<Long> diferencas = new ArrayList<>();
        long diferencaEmMillisegundos = fim.getTime() - inicial.getTime();
        long dias = TimeUnit.MILLISECONDS.toDays(diferencaEmMillisegundos);
        long horas = TimeUnit.MILLISECONDS.toHours(diferencaEmMillisegundos);
        long minutos = TimeUnit.MILLISECONDS.toMinutes(diferencaEmMillisegundos);
        long segundos = TimeUnit.MILLISECONDS.toSeconds(diferencaEmMillisegundos);
        diferencas.add(dias);
        diferencas.add(horas);
        diferencas.add(minutos);
        diferencas.add(segundos);
        return diferencas;
    }
    protected List<Integer> contadorMesAno(Date inicial, Date fim) {
        Calendar calendarInicial = Calendar.getInstance();
        calendarInicial.setTime(inicial);
        int anoInicial = calendarInicial.get(Calendar.YEAR);
        int mesInicial = calendarInicial.get(Calendar.MONTH);
        Calendar calendarFim = Calendar.getInstance();
        calendarFim.setTime(fim);
        int anoFim = calendarFim.get(Calendar.YEAR);
        int mesFim = calendarFim.get(Calendar.MONTH);
        int diferencaAnos = anoFim - anoInicial;
        int diferencaMeses = mesFim - mesInicial;
        if (diferencaMeses < 0) {
            diferencaAnos--;
            diferencaMeses += 12;
        }

        List<Integer> diferencas = new ArrayList<>();
        diferencas.add(diferencaMeses + (diferencaAnos * 12));
        diferencas.add(diferencaAnos);

        return diferencas;
    }



    public void run(){
        receberDatas();
        System.out.println("Dias entre as datas: " + contadorDias(this.dataInicial,this.dataFinal).get(0));
        System.out.println("Meses entre as datas: " + contadorMesAno(this.dataInicial,dataFinal).get(0));
        System.out.println("Anos entre as datas: " + contadorMesAno(this.dataInicial,dataFinal).get(1));
        System.out.println("Horas entre as datas: " + contadorDias(this.dataInicial,dataFinal).get(1));
        System.out.println("Minutos entre as datas: " + contadorDias(this.dataInicial,dataFinal).get(2));
        System.out.println("Segundos entre as datas: " + contadorDias(this.dataInicial,dataFinal).get(3));
    }


    public static void main(String[] args) {
        Day19Solucao day = new Day19Solucao();
        day.run();
    }
}
