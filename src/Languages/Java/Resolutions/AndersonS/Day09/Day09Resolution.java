package src.Languages.Java.Resolutions.AndersonS.Day09;

import java.util.*;

public class Day09Resolution {

    static int numberOfColumns = 3;
    protected static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        run();
    }
    
    private static void run(){
        System.out.println("Welcome to Magic Heart Game!");

        int numberOfCarts;
        do{
            System.out.print("Digit the number of carts for each stack:");
            numberOfCarts = intInput();
            if(numberOfCarts==0) break;

            System.out.println("Describe the cards value between spaces from the top until the bottom");
            ArrayList<ArrayList<Integer>> lineValues = reciveLinesWithCardsValues(numberOfCarts);

            Game game = new Game(numberOfColumns);
            lineValues.forEach(game::forEachCardValueAddToColmun);

            System.out.println("This game is winnable: " + game.isGameWinnable());
        }while (true);
        System.out.println("Thanks for playing!");
    }
    
    protected static int intInput(){
        int interger = input.nextInt();
        input.nextLine();
        return interger;
    }

    protected static String stringInput(){
        return input.nextLine();
    }

    protected static ArrayList<ArrayList<Integer>> reciveLinesWithCardsValues(int numberOfCarts){
        ArrayList<ArrayList<Integer>> lineValues = new ArrayList<>();
        for (int i = 0; i<numberOfCarts; i++){
            String cardsValuesWithSpaces = stringInput();
            ArrayList<Integer> numbers = stringToNumbers(cardsValuesWithSpaces);
            lineValues.add(numbers);
        }
        return lineValues;
    }

    protected static ArrayList<Integer> stringToNumbers(String numbersBetweenSpaces){
        ArrayList<String> numbersString = splitString(numbersBetweenSpaces);
        return arrayListStringToInterger(numbersString);
    }

    protected static ArrayList<String> splitString(String string){
        return new ArrayList<>(Arrays.asList(string.split(" ")));
    }

    protected static ArrayList<Integer> arrayListStringToInterger(ArrayList<String> numberString){
        ArrayList<Integer> numbers = new ArrayList<>();
        numberString.forEach(number -> numbers.add(Integer.valueOf(number)));
        return numbers;
    }


    static class Game {

        private int divisionNumber = 3;
        private int numberOfCloumns;
        private ArrayList<Deque<Integer>> columns;

        public Game(int numberOfCloumns) {
            this.numberOfCloumns = numberOfCloumns;
            this.columns = instantieteColumns();
        }

        protected void addColumn(Deque<Integer> column){
            if(columns.size()== numberOfCloumns){
                throw new ArrayIndexOutOfBoundsException("Too much stacks! bigger than allowed");
            }
            columns.add(column);
        }

        protected ArrayList<Deque<Integer>> instantieteColumns(){
            ArrayList<Deque<Integer>> columns = new ArrayList<>();
            for(int i=0; i<numberOfCloumns; i++){
                columns.add(new LinkedList<>());
            }
            return columns;
        }

        protected void forEachCardValueAddToColmun(ArrayList<Integer> numbers){
            for(int j=0; j<columns.size(); j++){
                columns.get(j).addLast(numbers.get(j));
            }
        }

        protected boolean isGameWinnable(){
            while (isNextMovePossible() && isNextMovePossible()){
                doNextMove();
            }
            if(isThereSomeCardsRemaining()) return false;
            return true;
        }

        protected boolean isThereSomeCardsRemaining(){
            for(Deque<Integer> column : columns){
                if (column.size()>0) return true;
            }
            return false;
        }

        protected boolean isNextMovePossible(){

            if(isAnyTopNumberDivisible()) return true;
            if(isSumTopNumberDivisible()) return true;
            if(isThereTopNumberToSubtractToBeDivisible()) return true;

            return false;
        }

        protected Game doNextMove(){

            if(isAnyTopNumberDivisible()){
                removeTopNumberWhitchIsDivisible();
                return this;
            }
            if(isSumTopNumberDivisible()){
                removeAllTopNumbers();
                return this;
            }
            if(isThereTopNumberToSubtractToBeDivisible()){
                removeOthersTopNumbers(getColumnWithTopNumberToSubtractIsDivisible());
                return this;
            }

            throw new NoSuchElementException("can't do next move");
        }

        protected boolean isSumTopNumberDivisible(){
           try {
               if(sumTopNumbers() % divisionNumber == 0 && sumTopNumbers() != 0) return true;
           }catch (NoSuchElementException e){
           }
            return false;
        }

        protected void removeAllTopNumbers(){
            columns.forEach(this::removeTopNumber);
        }

        protected boolean isAnyTopNumberDivisible(){

            for(Deque<Integer> colmun: columns){
                int firtsNumber = getFirst(colmun);
                if(firtsNumber % divisionNumber == 0 && firtsNumber > 0) return true;
            }
            return false;
        }

        protected void removeTopNumberWhitchIsDivisible(){
            Deque<Integer> column = getColumnWhitchTopNumberIsDivisble();
            removeTopNumber(column);
        }

        protected Deque<Integer> getColumnWhitchTopNumberIsDivisble(){
            for(Deque<Integer> colmun: columns){
                if(getFirst(colmun) % divisionNumber == 0 && getFirst(colmun) >0 && !colmun.isEmpty()) return colmun;
            }
            throw new NoSuchElementException("Top number divisible do not exist");
        }

        protected int getFirst(Deque<Integer> column){
            int firstNumber = 0;
            try {
                firstNumber = column.getFirst();
            }catch (NoSuchElementException e){
            }
            return firstNumber;
        }

        protected Deque<Integer> removeTopNumber(Deque<Integer> column){
            try{
                column.removeFirst();
            }catch (NoSuchElementException e){
                return column;
            }
            return column;
        }

        protected int sumTopNumbers() {
            int sum = 0;
            for(Deque<Integer> column : columns){
                sum+= getFirst(column);
            }
            return sum;
        }

        protected boolean isThereTopNumberToSubtractToBeDivisible(){
            int sum = sumTopNumbers();
            for(Deque<Integer> column : columns){
                int topNumber = getFirst(column);
                int difference = sum - topNumber;
                if(difference <= 0) return false;
                if((difference) % divisionNumber == 0) return true;
            }
            return false;
        }

        protected Deque<Integer> getColumnWithTopNumberToSubtractIsDivisible(){
            int sum = sumTopNumbers();
            for(Deque<Integer> column : columns){
                int topMumber = getFirst(column);
                int difference = sum - topMumber;
                if(difference <= 0) continue;
                if((difference) % divisionNumber == 0){
                    return column;
                }
            }
            throw new NoSuchElementException("no number to remove to be divisible");
        }

        protected void removeOthersTopNumbers(Deque<Integer> columnToPreserve){

            int numberToPreserve = getFirst(columnToPreserve);

            removeAllTopNumbers();

            int indexOfTheColumn = columns.indexOf(columnToPreserve);
            columns.get(indexOfTheColumn).addFirst(numberToPreserve);

        }

        public int getNumberOfCloumns() {
            return numberOfCloumns;
        }

        public ArrayList<Deque<Integer>> getColumns() {
            return columns;
        }
    }
}
