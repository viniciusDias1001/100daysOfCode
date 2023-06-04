package src.Languages.Java.Resolutions.PedroV;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Day01Teste {

    private Day01Solucao day01Solucao = new Day01Solucao();

    @Test
    public void TestNumberOrdenados() throws IllegalAccessException {
        ArrayList<Integer> OrderedListExpected = new ArrayList<>();
        OrderedListExpected.add(2);
        OrderedListExpected.add(4);
        OrderedListExpected.add(3);
        OrderedListExpected.add(1);


        day01Solucao.addNumbsToAnArrays(1);
        day01Solucao.addNumbsToAnArrays(2);
        day01Solucao.addNumbsToAnArrays(3);
        day01Solucao.addNumbsToAnArrays(4);
        day01Solucao.sortfullList();


        Assertions.assertEquals(OrderedListExpected, day01Solucao.responseAndListOfOut());
    }

    @Test
    public void TestIllegalArgumentInNumber() throws IllegalArgumentException {

        Assertions.assertThrows(IllegalArgumentException.class ,() -> {
            day01Solucao.addNumbsToAnArrays(0);
        });
    }
}



