package src.Languages.Java.Resolutions.PedroV.DayExtra01;

public class SomaMaxMin {

    public static Integer[] lista = {1,2,3,4,5};

    public static void somaMaxMin(){

        int max = lista[0];
        int soma = 0;
        int min = lista[0];
            for (int i = 0; i < lista.length; i++){
                soma += lista[i];
                if (min > lista[i])
                    min = lista[i];
                if (max < lista[i])
                    max = lista[i];
            }
        System.out.println( soma - max);
        System.out.println( soma - min);

    }

    public static void main(String[] args) {
        somaMaxMin();
    }


}
