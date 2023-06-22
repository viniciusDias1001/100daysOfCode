package src.Languages.Java.Resolutions.AndersonS.Day08;

import java.util.*;

public class Day08Solucao {

    static class Abrivietion implements Comparable<Abrivietion> {

        private static final ArrayList<Abrivietion> allAbrivietions = new ArrayList<>();
        private static final int MINIMUM_ABREVIETEBLE_WORD_SIZE = 3;
        private static final String ABREVIETION_SYMBOL  = ".";
        private static final String ABREVIETION_FORMAT = "%s" + ABREVIETION_SYMBOL;
        private String word;
        private String abrevietion;
        private boolean wereAbrevieted;
        
        public Abrivietion(String word) {
            this.word = word;
            this.abrevietion = abrevieteWord(this.word);
            this.wereAbrevieted = this.abrevietion.length() < this.word.length();
            appendAllAbrivietions(this);
        }

        public String getWord() {
            return word;
        }

        public String getAbrevietion() {
            return abrevietion;
        }

        public boolean wereAbrevieted() {
            return wereAbrevieted;
        }

        public static boolean isWordAbrevieted(String word){
            if(allAbrivietions.stream().filter(Abrivietion::wereAbrevieted).filter(abrivietion -> abrivietion.getWord().equalsIgnoreCase(word)).toList().size() > 0 && (allAbrivietions.stream().filter(Abrivietion::wereAbrevieted).filter(abrivietion -> abrivietion.getAbrevietion().equalsIgnoreCase(String.valueOf(word.charAt(0) + ABREVIETION_SYMBOL))).toList().size() > 0)) return true;
            return false;
        }

        public static boolean isFirstLetterUsed(String word){
            if(allAbrivietions.stream().filter(Abrivietion::wereAbrevieted).filter(abrivietion -> abrivietion.getAbrevietion().equalsIgnoreCase(String.valueOf(word.charAt(0) + ABREVIETION_SYMBOL))).toList().size() > 0) return true;
            return false;
        }

        public static boolean isWordAdequate(String word){
            if(word.length() >= MINIMUM_ABREVIETEBLE_WORD_SIZE && !isWordAbrevieted(word)) return true;
            return false;
        }

        public static boolean isWordAbrevieteble(String word){
            if(isWordAbrevieted(word)) return true;
            if(isFirstLetterUsed(word)) return false;
            if(isWordAdequate(word)) return true;
            return false;
        }

        public static String abrevieteWord(String word){

            if(isWordAbrevieteble(word)){
                return abrevieteAlgorithm(word);
            }
            return word;
        }

        private static String abrevieteAlgorithm(String word){

            String firstLetter = String.valueOf(word.charAt(0));

            return String.format(ABREVIETION_FORMAT, firstLetter);
        }

        public static ArrayList<Abrivietion> abrevieteWords(ArrayList<String> words){

            ArrayList<Abrivietion> abrivietions = new ArrayList<>();

            words.forEach(word -> abrivietions.add(new Abrivietion(word)));

            return abrivietions;
        }

        private void appendAllAbrivietions(Abrivietion abrivietion){
            if (wereAbrevieted() && !allAbrivietions.contains(this)){
                allAbrivietions.add(abrivietion);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Abrivietion that = (Abrivietion) o;
            return wereAbrevieted == that.wereAbrevieted && Objects.equals(word, that.word) && Objects.equals(abrevietion, that.abrevietion);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word, abrevietion, wereAbrevieted);
        }

        @Override
        public String toString(){
            return abrevietion + " = " + word;
        }

        @Override
        public int compareTo(Abrivietion abrivietion) {
            return this.word.compareTo(abrivietion.getAbrevietion());
        }
    }

    static class Phrase{

        private String phrase;
        private String abrevietedPhrase;
        private ArrayList<String> words;
        private ArrayList<Abrivietion> abrevietedWords;

        public Phrase(String phrase) {
            this.phrase = phrase;
            this.words = phrseToWords(this.phrase);
            this.abrevietedWords = Abrivietion.abrevieteWords(words);
            this.abrevietedPhrase = genereteAbrevietedPhrase();
        }

        public String getPhrase() {
            return phrase;
        }

        public void setPhrase(String phrase) {
            this.phrase = phrase;
            this.words = phrseToWords(this.phrase);
            this.abrevietedWords = Abrivietion.abrevieteWords(words);
        }

        public String getAbrevietedPhrase() {
            return abrevietedPhrase;
        }

        public ArrayList<String> getWords() {
            return words;
        }

        public ArrayList<Abrivietion> getAbrevietedWords() {
            return abrevietedWords;
        }

        public static ArrayList<String> phrseToWords(String phrase){

            return new ArrayList<>(Arrays.asList(phrase.split(" ")));

        }

        private String genereteAbrevietedPhrase(){

            StringBuilder stringBuilder = new StringBuilder();
            abrevietedWords.forEach(abrevietion -> stringBuilder.append(abrevietion.getAbrevietion() + " "));
            return stringBuilder.toString();
        }
    }

    private static final Scanner input = new Scanner(System.in);

    public static String inputString(){
        return input.nextLine();
    }

    public static void run(){

        String phraseWithEspace;

        System.out.println("Write some Posts! \".\" alone in a line indicates the end");

        ArrayList<Phrase> userPhrases = new ArrayList<>();

        do{
            phraseWithEspace = inputString();

            userPhrases.add(new Phrase(phraseWithEspace));

        }while(!phraseWithEspace.equalsIgnoreCase("."));

        //removing the last phrase becouse "." is not a phrase
        userPhrases.remove(userPhrases.size()-1);

        System.out.println("All posts:");
        userPhrases.forEach(phrase -> System.out.println(phrase.abrevietedPhrase));

        System.out.println("\nThe meaning of each symbol:");
        Collections.sort(Abrivietion.allAbrivietions);
        Abrivietion.allAbrivietions.forEach(System.out::println);

    }

    public static void main(String[] args) {

        run();

    }
}
