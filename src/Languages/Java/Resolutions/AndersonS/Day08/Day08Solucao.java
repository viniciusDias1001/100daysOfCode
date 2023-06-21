package src.Languages.Java.Resolutions.AndersonS.Day08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Day08Solucao {

    static class notEnhoughWordSize extends RuntimeException{
        public notEnhoughWordSize() {
            super("the word's size isn't enought");
        }
    }

    static class Abrivietion {

        public static final ArrayList<Abrivietion> allAbrivietions = new ArrayList<>();

        static final int MINIMUM_ABREVIETEBLE_WORD_SIZE = 3;

        static final String ABREVIETION_SYMBOL  = ".";

        static final String ABREVIETION_FORMAT = "%s" + ABREVIETION_SYMBOL;

        private String word;

        private String abrevietion;
        
        public Abrivietion(String word) {
            this.word = word;
            abrevieteWord();
            appendAllAbrivietions();
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public String getAbrevietion() {
            return abrevietion;
        }

        public static boolean isWordAbrevieted(String word){
            return allAbrivietions.stream().filter(abrivietion -> abrivietion.getWord().length()>=MINIMUM_ABREVIETEBLE_WORD_SIZE).toList().contains(word);
        }

        public static boolean isWordAbrevieteble(String word){

            return  word.length() >= MINIMUM_ABREVIETEBLE_WORD_SIZE;
        }

        public void abrevieteWord(){
            this.abrevietion = abrevieteWord(this.word);
        }

        public static String abrevieteWord(String word){

            if(isWordAbrevieteble(word)){
                return abrevieteAlgorithm(word);
            }
            throw new notEnhoughWordSize();
        }

        public static String abrevieteAlgorithm(String word){

            String firstLetter = String.valueOf(word.charAt(0));

            return String.format(ABREVIETION_FORMAT, firstLetter);
        }

        public static ArrayList<Abrivietion> abrevieteWords(ArrayList<String> words){

            ArrayList<Abrivietion> abrivietions = new ArrayList<>();

            words.forEach(word -> abrivietions.add(new Abrivietion(word)));

            return abrivietions;
        }

        private void appendAllAbrivietions(){
            allAbrivietions.add(this);
        }

        @Override
        public String toString(){
            return abrevietion + " = " + word;
        }
    }

    static class Phrase{

        private String phrase;

        private ArrayList<String> words;

        private ArrayList<Abrivietion> abrevietedWords;

        public Phrase(String phrase) {
            this.phrase = phrase;
            phraseToWords();
            this.abrevietedWords = Abrivietion.abrevieteWords(words);
        }

        public String getPhrase() {
            return phrase;
        }

        public void setPhrase(String phrase) {
            this.phrase = phrase;
            phraseToWords();
            this.abrevietedWords = Abrivietion.abrevieteWords(words);
        }

        public ArrayList<String> getWords() {
            return words;
        }

        public void phraseToWords(){

            this.words = phrseToWords(this.phrase);

        }

        public static ArrayList<String> phrseToWords(String phrase){

            return new ArrayList<>(Arrays.asList(phrase.split(" ")));

        }
    }

    private static Scanner input = new Scanner(System.in);

    public static String inputString(){
        return input.nextLine();
    }

    public static void run(){

        String phraseWithEspace;

        System.out.println("Write some Posts! \".\" alone in a line indicates the end");

        do{
            phraseWithEspace = inputString();

            try{
                Phrase phrase = new Phrase(phraseWithEspace);
            }catch (notEnhoughWordSize e){
                //
            }

        }while(!phraseWithEspace.equalsIgnoreCase("."));

        System.out.println(Abrivietion.allAbrivietions);

    }

    public static void main(String[] args) {

        run();

    }
}
