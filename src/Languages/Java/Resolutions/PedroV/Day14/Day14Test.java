package src.Languages.Java.Resolutions.PedroV.Day14;

import org.junit.Assert;
import org.junit.Test;


public class Day14Test {

    private Day14Solucao day = new Day14Solucao();


    @Test
    public void gerarNumeroAleatorioNoveDigitosTest(){
        Assert.assertEquals(9, day.gerarOs9primeirosDigitos().length());
    }

    @Test
    public void gerarNumerosAleatoriosTest(){
        Assert.assertNotEquals(day.gerarOs9primeirosDigitos(), day.gerarOs9primeirosDigitos());
    }

    @Test
    public void concatenarTest(){
        Assert.assertEquals("1234567891", day.concatenar("123456789","1"));
    }

    @Test
    public void validaçãoDeCPFTest(){
        Assert.assertEquals(true,day.verificarCpf("702.912.940-73"));

    }


}
