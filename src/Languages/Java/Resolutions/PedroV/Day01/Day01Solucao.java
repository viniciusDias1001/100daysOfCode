package src.Languages.Java.Resolutions.PedroV.Day01;
import java.util.*;

public class Day01Solucao {
    private List<Integer> numbsPar = new ArrayList<>();
    private List<Integer> numbsImpar = new ArrayList<>();



    public void addNumbsToAnArrays (Integer number) throws IllegalArgumentException {
        if (number > 0 && number < 10000 && number % 2 ==0){
            this.numbsPar.add(number);
            sortNumbersPar(numbsPar);
        }else if (number > 0 && number < 10000 && number % 2 != 0){
            this.numbsImpar.add(number);
            sortNumbersImpar(numbsImpar);
        }  else {
            throw new IllegalArgumentException("Number Invalid");
        }

    }

    public void sortNumbersPar(List<Integer> listPar){
        Collections.sort(listPar);
    }

    public void sortNumbersImpar(List<Integer> listImpar){
        Collections.sort(listImpar, Comparator.reverseOrder());
    }

    public List<Integer> responseAndListOfOut(){

        return  sortfullList();
    }

    public List<Integer> sortfullList(){
        List<Integer> allNumbsToInput = new ArrayList<>();
        allNumbsToInput.addAll(this.numbsPar);
        allNumbsToInput.addAll(this.numbsImpar);
        return allNumbsToInput;
    }



    public static void main(String[] args)  {

        try{
            Day01Solucao day01Solucao = new Day01Solucao();
            Scanner input = new Scanner(System.in);

            System.out.println("How many numbers do you want to add to the Array ?");
            Integer lengthOdArray = input.nextInt();


            for (int i = lengthOdArray; i > 0; i--){
                System.out.println("enter a number " + " |   need to add " + i + " numbers");
                Integer numberOfInput = input.nextInt();
                day01Solucao.addNumbsToAnArrays(numberOfInput);
                day01Solucao.sortfullList();
            }
            input.close();

            System.out.println(day01Solucao.responseAndListOfOut());
        } catch (IllegalArgumentException e){
            System.out.println(e);
        }


    }
}
