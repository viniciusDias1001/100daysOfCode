package src.Languages.Java.Resolutions.PauloHenrique.Day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Desafio01Test {

    @Test
    void ordenarNumerosTeste1() {
        List<Integer> esperado = List.of(2, 4, 8, 111, 93, 3);
        List<Integer> response = Desafio01.ordenarNumeros(List.of(111, 2, 8, 93, 4, 3));

        Assertions.assertEquals(esperado, response);
    }

    @Test
    void ordenarNumerosTeste2() {
        List<Integer> esperado = List.of(2, 8, 930, 1110, 33, 9);
        List<Integer> response = Desafio01.ordenarNumeros(List.of(2, 1110, 930, 8, 33, 9));

        Assertions.assertEquals(esperado, response);
    }
}