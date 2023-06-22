package src.Languages.Java.Resolutions.AndersonS.Day08;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class Day08Teste {

    @Test
    public void isWordAbrevieteble(){

        new Day08Solucao.Phrase("hello world");

        Assertions.assertTrue(Day08Solucao.Abrivietion.isWordAbrevieted("world"));

        Assertions.assertFalse(Day08Solucao.Abrivietion.isWordAbrevieted("hi"));

        Assertions.assertTrue(Day08Solucao.Abrivietion.isWordAbrevieteble("world"));

        Assertions.assertTrue(Day08Solucao.Abrivietion.isWordAbrevieteble("hello"));

        Assertions.assertTrue(Day08Solucao.Abrivietion.isWordAbrevieteble("pao"));



    }

}
