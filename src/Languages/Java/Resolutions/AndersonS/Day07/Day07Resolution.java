package src.Languages.Java.Resolutions.AndersonS.Day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.BinaryOperator;

public class Day07Resolution {

    static class AlphaBet{

        ArrayList<Character> alphabet;

        public AlphaBet() {
            this.alphabet = generateAlphabet();
        }

        public ArrayList<Character> getAlphabet(){
            return alphabet;
        }

        public int indexOf(char letter){
            return alphabet.indexOf(letter);
        }

        private ArrayList<Character> generateAlphabet(){

            ArrayList<Character> alphabet = new ArrayList<>();

            for(char letter = 'A'; letter <= 'Z'; letter++){
                alphabet.add(letter);
            }
            return alphabet;
        }
    }

    static class MagicHash{

        private static ArrayList<ArrayList<String>> allWords = new ArrayList<>();

        private ArrayList<String> words;
        private int magicHash;

        public MagicHash(String phrase) {
            this.words = splitPhrase(phrase);
            this.magicHash = genereteMagicHashCode();
            allWords.add(words);
        }

        public int getMagicHash() {
            return magicHash;
        }

        private ArrayList<String> splitPhrase(String phrase) {
            return new ArrayList<>(Arrays.asList(phrase.split(" ")));
        }

        private int positionLetterValue(String word, char letter){
            return word.indexOf(letter);
        }

        private int wordLineValue(){
            return allWords.indexOf(words);
        }

        private int aphabetLetterValue(char letter){
            AlphaBet alphaBet = new AlphaBet();
            return alphaBet.indexOf(letter);
        }

        public int calculateLetterMagicHash(char letter){

            int letterMagicHash = 0;

            letterMagicHash+= aphabetLetterValue(letter) + wordLineValue()
//                    + positionLetterValue(word, letter)
                    ;

            return letterMagicHash;
        }

        private int calculateWordMagicHashCode(String word){

            int wordMagicHash = 0;

            for(int i =0; i< word.length(); i++){

                char letter = word.charAt(i);
                // +i becouse to calculate the magic hash it needs to sum the indicie too
                wordMagicHash+= calculateLetterMagicHash(letter) + i;
            }
            return wordMagicHash;
        }

        public int genereteMagicHashCode(){

            int magicHash = 0;

            for (String word: words){

                magicHash+= calculateWordMagicHashCode(word);
            }

            return magicHash;

        }
        public String toString(){

            StringBuilder stringBuilder = new StringBuilder();

            for (String word: words){

                stringBuilder.append(word +":\n");
                for(int i =0; i< word.length(); i++){

                    char letter = word.charAt(i);
                    // +i becouse to calculate the letter magic hash it needs to sum the indicie too
                     stringBuilder.append((calculateLetterMagicHash(letter) + i ) + " = " + aphabetLetterValue(letter)+ " + " + wordLineValue() + " + " + i);
                     stringBuilder.append("\n");

                }

            }

            return stringBuilder.toString();
        }
    }

    private static Scanner input = new Scanner(System.in);

    private static String inputString(){
        return input.nextLine().toUpperCase();
    }

    private static int inputInt(){

        int interger = input.nextInt();
        input.nextLine();

        return interger;

    }

    public static void run(){

        ArrayList<MagicHash> userHashMagics = new ArrayList<>();

        System.out.println("Write the N cases number");
        int numberCases = inputInt();

        System.out.println("Write some words and then see their magic hashs!");
        for (int i = 0; i < numberCases; i++){

            userHashMagics.add(new MagicHash(inputString()));

        }

        userHashMagics.forEach(System.out::println);

    }

    public static void main(String[] args) {
        run();
    }

}
