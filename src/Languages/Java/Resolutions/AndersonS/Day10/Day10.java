package src.Languages.Java.Resolutions.AndersonS.Day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day10 {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Digite the numbers: ");
        ArrayList<String> numbersInString = splitString(stringInput());
        ArrayList<String> nonRepeatedNumber = getNonRepeated(numbersInString);
        if(nonRepeatedNumber.isEmpty())System.out.println("every element is repeated");
        else System.out.println(nonRepeatedNumber);
    }

    static protected ArrayList<String> splitString(String string){
        return new ArrayList<>(Arrays.asList(string.split(" ")));
    }

    protected static String stringInput(){
        return input.nextLine();
    }

    protected static ArrayList<String> getNonRepeated(ArrayList<String> arrayList) {
        ArrayList<String> control = new ArrayList<>();
        for (String element : arrayList) {
            if (control.contains(element)) {
                control.remove(element);
                continue;
            }
            control.add(element);
        }
        return control;
    }
}
