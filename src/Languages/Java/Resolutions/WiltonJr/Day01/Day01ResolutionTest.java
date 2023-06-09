package src.Languages.Java.Resolutions.WiltonJr.Day01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Day01ResolutionTest {

    @Test
    void ordenarNumeros() {
        List<List<Integer>> esperado = new ArrayList<>();
        List<Integer> pares = List.of(2,4,40);
        List<Integer> impares = List.of(9,5,3);
        esperado.add(pares);
        esperado.add(impares);

        List<List<Integer>> response = Day01Resolution.ordenarNumeros(List.of(4,9,40,3,5,2));

        Assertions.assertEquals(esperado, response);
    }

    @Test
    void ordenarNumeros1() {
        List<List<Integer>> esperado = new ArrayList<>();
        List<Integer> pares = List.of(10,44,400);
        List<Integer> impares = List.of(91,51,3);
        esperado.add(pares);
        esperado.add(impares);

        List<List<Integer>> response = Day01Resolution.ordenarNumeros(List.of(400,91,44,3,51,10));

        Assertions.assertEquals(esperado, response);
    }

}