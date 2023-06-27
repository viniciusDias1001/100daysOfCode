package src.Languages.Java.Resolutions.AndersonS.Day08;

import java.util.*;
import java.util.function.UnaryOperator;

public class Day08Solucao {

    static class AbrevietionRules{

        private  String abrevietionSymbol;
        private  String abrevietionFormat;
        private  UnaryOperator<String> abrevieteFunction;
        private int minimumWordSize;

        public AbrevietionRules(String abrevietionSymbol, String abrevietionFormat,int minimumWordSize, UnaryOperator<String> abrevieteFunction) {
            this.abrevietionSymbol = abrevietionSymbol;
            this.abrevietionFormat = abrevietionFormat;
            this.abrevieteFunction = abrevieteFunction;
            this.minimumWordSize = minimumWordSize;
        }

        public String getAbrevietionSymbol() {
            return abrevietionSymbol;
        }

        public void setAbrevietionSymbol(String abrevietionSymbol) {
            this.abrevietionSymbol = abrevietionSymbol;
        }

        public String getAbrevietionFormat() {
            return abrevietionFormat;
        }

        public void setAbrevietionFormat(String abrevietionFormat) {
            this.abrevietionFormat = abrevietionFormat;
        }

        public int getMinimumWordSize() {
            return minimumWordSize;
        }

        public void setMinimumWordSize(int minimumWordSize) {
            this.minimumWordSize = minimumWordSize;
        }

        public UnaryOperator<String> getAbrevieteFunction() {
            return abrevieteFunction;
        }

        public void setAbrevieteFunction(UnaryOperator<String> abrevieteFunction) {
            this.abrevieteFunction = abrevieteFunction;
        }
    }
    static class Abrevietion implements Comparable<Abrevietion> {

        private static final ArrayList<Abrevietion> ALL_ABREVIETIONS = new ArrayList<>();
        private AbrevietionRules abrevietionRules;
        private String word;
        private String abrevietion;
        private boolean wereAbrevieted;

        public Abrevietion(String word, AbrevietionRules abrevietionRules) {
            this.word = word;
            this.abrevietionRules = abrevietionRules;
            this.abrevietion = abrevieteWord();
            this.wereAbrevieted = isWordAbrevieteble();
            appendToAllAbrivietions(this);
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
            this.abrevietion = abrevieteWord();
            this.wereAbrevieted = isWordAbrevieteble();
        }

        public String getAbrevietion() {
            return abrevietion;
        }

        public boolean wereAbrevieted() {
            return wereAbrevieted;
        }

        private boolean isWordAbrevieteble(){
            if(isWordAbrevieted(this.word)) return true;
            if(isThisWordAbrevietionEqualsAnotherAbrevietion(this.word)) return false;
            if(isWordAdequate()) return true;
            return false;
        }

        private boolean isWordAdequate(){
            if(word.length() >= abrevietionRules.getMinimumWordSize() && !isWordAbrevieted(word)) return true;
            return false;
        }

        public String abrevieteWord(){

            if(isWordAbrevieteble()) return abrevietionRules.getAbrevieteFunction().apply(this.word);
            return word;
        }

        private boolean isThisWordAbrevietionEqualsAnotherAbrevietion(String word){
            if(getAbrevitionsEqualsThisAbrevietionWord(word).size() > 0) return true;
            return false;
        }

        private ArrayList<Abrevietion> getAbrevitionsEqualsThisAbrevietionWord(String word){
            return new ArrayList<>(ALL_ABREVIETIONS.stream().filter(Abrevietion::wereAbrevieted).filter(abrevietion -> abrevietion.getAbrevietion().equalsIgnoreCase(abrevietionRules.getAbrevieteFunction().apply(word))).toList());
        }

        private ArrayList<Abrevietion> getAbrevietionWithThisWord(String word){
            return new ArrayList<>(ALL_ABREVIETIONS.stream().filter(Abrevietion::wereAbrevieted).filter(abrevietion -> abrevietion.getWord().equalsIgnoreCase(word)).toList());
        }

        private boolean isWordAbrevieted(String word){
            if(getAbrevietionWithThisWord(word).size() > 0) return true;
            return false;
        }

        public static ArrayList<Abrevietion> getAllAbrevietions(){
            return ALL_ABREVIETIONS;
        }

        private void appendToAllAbrivietions(Abrevietion abrevietion){
            if (wereAbrevieted() && !ALL_ABREVIETIONS.contains(this)) ALL_ABREVIETIONS.add(abrevietion);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Abrevietion that = (Abrevietion) o;
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
        public int compareTo(Abrevietion abrevietion) {
            return this.word.compareTo(abrevietion.getAbrevietion());
        }
    }

    static class AbrevietedPhrase{

        private Phrase phrase;
        private AbrevietionRules abrevietionRules;
        private String abrevietedPhraseString;
        private ArrayList<Abrevietion> abrevietedWords;

        public AbrevietedPhrase(Phrase phrase, AbrevietionRules abrevietionRules) {
            this.phrase = phrase;
            this.abrevietionRules = abrevietionRules;
            this.abrevietedWords = genereteAbrevietedWords();
            this.abrevietedPhraseString = genereteAbrevietedPhrase();
        }

        public String getAbrevietedPhraseString() {
            return abrevietedPhraseString;
        }

        private String genereteAbrevietedPhrase(){
            StringBuilder stringBuilder = new StringBuilder();
            abrevietedWords.forEach(abrevietion -> stringBuilder.append(abrevietion.getAbrevietion() + " "));
            return stringBuilder.toString();
        }

        private ArrayList<Abrevietion> genereteAbrevietedWords(){
            ArrayList<Abrevietion> abrevietedWords = new ArrayList<>();
            phrase.getWords().forEach(word -> abrevietedWords.add(new Abrevietion(word, abrevietionRules)));
            return abrevietedWords;
        }
    }

    static class Phrase{

        private String phraseString;
        private ArrayList<String> words;

        public Phrase(String phraseString) {
            this.phraseString = phraseString;
            this.words = phrseToWords(this.phraseString);
        }

        public String getPhraseString() {
            return phraseString;
        }

        public void setPhraseString(String phraseString) {
            this.phraseString = phraseString;
            this.words = phrseToWords(this.phraseString);
        }

        public ArrayList<String> getWords() {
            return words;
        }

        public static ArrayList<String> phrseToWords(String phrase){
            return new ArrayList<>(Arrays.asList(phrase.split(" ")));
        }
    }

    private static final Scanner input = new Scanner(System.in);

    public static String inputString(){
        return input.nextLine();
    }

    public static void run(){

        AbrevietionRules abrevietionRules;
        String abrevietionSymbol = ".";
        String abrevietionFormat = "%s" + abrevietionSymbol;
        int minimunWordSize = 3;
        UnaryOperator<String> abrevietionFunction = word -> String.format(abrevietionFormat, word.charAt(0));

        abrevietionRules = new AbrevietionRules(abrevietionSymbol,abrevietionFormat, minimunWordSize, abrevietionFunction);

        ArrayList<AbrevietedPhrase> userAbrevietedPhrases = new ArrayList<>();
        Phrase userPhrase;
        String stopSymbol = ".";
        System.out.println("Write some Posts! \".\" alone in a line indicates the end");
        do{
            userPhrase = new Phrase(inputString());
            userAbrevietedPhrases.add(new AbrevietedPhrase(userPhrase,abrevietionRules));
        }while(!userPhrase.getPhraseString().equals(stopSymbol));

        //removing the last phrase becouse "." is not a phrase
        userAbrevietedPhrases.remove(userAbrevietedPhrases.size()-1);

        System.out.println("All posts:");
        userAbrevietedPhrases.forEach(abrevietedPhrase -> System.out.println(abrevietedPhrase.getAbrevietedPhraseString()));

        System.out.println("\nThe meaning of each symbol:");
        Collections.sort(Abrevietion.getAllAbrevietions() );
        Abrevietion.getAllAbrevietions().forEach(System.out::println);

    }

    public static void main(String[] args) {

        run();

    }
}
