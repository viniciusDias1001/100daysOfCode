package src.Languages.Java.Resolutions.PedroV.Day04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;


public class Day04Test {


    @Test
    public void VerificarSaida(){
        Day04Solucao day04Solucao = new Day04Solucao();
        List<String> listaAtual = new ArrayList<>();
        listaAtual.add("10");
        listaAtual.add("8");
        listaAtual.add("15");
        listaAtual.add("3");
        listaAtual.add("12");
        Assertions.assertEquals(2, day04Solucao.checkHowmManyCustomersAreOutOfPlace(listaAtual));
    }


    @Test
    public void sortList(){
        Day04Solucao day04Solucao = new Day04Solucao();
        List<String> listaAtual = new ArrayList<>();
        listaAtual.add("10");
        listaAtual.add("8");
        listaAtual.add("15");
        listaAtual.add("3");
        listaAtual.add("12");

        List<Integer> listaEsperada = new ArrayList<>();
        listaEsperada.add(15);
        listaEsperada.add(12);
        listaEsperada.add(10);
        listaEsperada.add(8);
        listaEsperada.add(3);

        Assertions.assertEquals(listaEsperada,day04Solucao.sortList(listaAtual));


    }
}
