package src.Languages.Java.Resolutions.AndersonS.Day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import src.Languages.Java.Resolutions.AndersonS.Day01.Day01Solucao;

import java.util.ArrayList;

public class Day01Test {

    final int NUMERO_DE_TESTES = 10;

    @Test
    public void testaMargemDeNumerosTeste(){

        int numeroAcimaDaMargem = 10001;
        int numeroAceitavavel = 500;
        int numeroAbaixoDaMargem = -1;

        Assertions.assertFalse(Day01Solucao.testaMargemDeNumeros(numeroAcimaDaMargem));
        Assertions.assertTrue(Day01Solucao.testaMargemDeNumeros(numeroAceitavavel));
        Assertions.assertFalse(Day01Solucao.testaMargemDeNumeros(numeroAbaixoDaMargem));
    }

    @Test
    public void testaParidadeTeste(){

        int numeroImpar = 3;
        int numeroPar = 4;

        Assertions.assertTrue(Day01Solucao.testaParidade(numeroPar));
        Assertions.assertFalse(Day01Solucao.testaParidade(numeroImpar));

    }

    @Test
    public void juntarListasParesImpares(){

        int numerosDeTestes = 2000;

        ArrayList<Integer> numerosImperas = new ArrayList<>();
        ArrayList<Integer> numerosPares = new ArrayList<>();

        int numeroFinalImpar = 1;

        for(; numeroFinalImpar <= numerosDeTestes; numeroFinalImpar+=2){
            numerosImperas.add(numeroFinalImpar);
        }
        //no ultimo loop é somado mais 2, e sai do for quando numeroFinalImpar <= numerosDeTestes retorna false
        numeroFinalImpar = numeroFinalImpar - 2;

        int numeroRodadaFinalPares = 0;

        for(; numeroRodadaFinalPares < numerosDeTestes; numeroRodadaFinalPares+=2){
            numerosPares.add(numeroRodadaFinalPares);
        }
        numeroRodadaFinalPares = numeroRodadaFinalPares - 2;

        ArrayList<Integer> arrayFinal = Day01Solucao.juntarListasParesImpares(numerosPares, numerosImperas);

       Assertions.assertEquals(0, arrayFinal.get(0));
        Assertions.assertEquals(numeroFinalImpar, arrayFinal.get(arrayFinal.size()-1));
}
}
