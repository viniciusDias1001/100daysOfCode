package src.Languages.Java.Resolutions.AndersonS.Day09;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class Day09Test {
    int numberOfTestColumns =3;
    int numberOfCards = 3;

    @Before
    public void setUp(){

    }

    @Test
    public void splitStringTest(){
        ArrayList<String> expectedString = new ArrayList<>(Arrays.asList("Test", "Phrase"));

        Assertions.assertEquals(expectedString, Day09Resolution.splitString("Test Phrase"));
    }

    @Test
    public void arrayStringToInterger(){
        ArrayList<Integer> expectedsNumberString = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<String> numbersString = new ArrayList<>(Arrays.asList("1", "2"));

        Assertions.assertEquals(expectedsNumberString, Day09Resolution.arrayListStringToInterger(numbersString));
    }

    @Test
    public void stringToNumberTest(){
        String numbersString = "1 2";
        ArrayList<Integer> expectedsNumberString = new ArrayList<>(Arrays.asList(1, 2));

        Assertions.assertEquals(expectedsNumberString,Day09Resolution.stringToNumbers(numbersString));
    }

    @Test
    public void addStackTest(){
        Day09Resolution.Game game = new Day09Resolution.Game(numberOfTestColumns);

        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            tryAddNewColumn(game);
        });
    }
    private Day09Resolution.Game tryAddNewColumn(Day09Resolution.Game game){
        game.addColumn(new LinkedList<>());
        return game;
    }

    @Test
    void forEachCardValueAddToColmunTest(){
        Day09Resolution.Game game = new Day09Resolution.Game(numberOfTestColumns);

        ArrayList<Integer> topLine = Day09Resolution.stringToNumbers("1 2 3");
        ArrayList<Integer> mediumLine = Day09Resolution.stringToNumbers("3 2 1");
        ArrayList<Integer> bottomLine = Day09Resolution.stringToNumbers("5 4 3");

        game.forEachCardValueAddToColmun(topLine);
        for(int i=0; i<game.getNumberOfCloumns(); i++){
            Assertions.assertEquals(Arrays.asList(topLine.get(i)), game.getColumns().get(i));
        }

        game.forEachCardValueAddToColmun(mediumLine);
        for(int i=0; i<game.getNumberOfCloumns(); i++){
            Assertions.assertEquals(Arrays.asList(topLine.get(i), mediumLine.get(i)), game.getColumns().get(i));
        }

        game.forEachCardValueAddToColmun(bottomLine);
        for(int i=0; i<game.getNumberOfCloumns(); i++){
            Assertions.assertEquals(Arrays.asList(topLine.get(i), mediumLine.get(i), bottomLine.get(i)), game.getColumns().get(i));
        }

    }
}
