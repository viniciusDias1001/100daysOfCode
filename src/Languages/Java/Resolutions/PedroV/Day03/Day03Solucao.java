package src.Languages.Java.Resolutions.PedroV.Day03;

import java.util.*;



public class Day03Solucao {


    private Map<Integer, List<YearEndUniform>> classes = new HashMap<>(7);

    static class YearEndUniform {
        private String name;
        private String uniformSize;
        private String uniformColor;

        public YearEndUniform(String name, String uniformColor, String uniformSize) {
            this.name = name;
            this.uniformSize = uniformSize;
            this.uniformColor = uniformColor;
        }

        public String getName() {
            return name;
        }

        public String getUniformSize() {
            return uniformSize;
        }

        public String getUniformColor() {
            return uniformColor;
        }
    }


    public void layout(){
        Scanner input = new Scanner(System.in);
        Boolean start = false;



        while (!start){

            options();
            Integer choice = input.nextInt();

            switch (choice){
                case 1 :
                    creatingClasses();
                    createYearEndUniform();
                    break;
                case 2:
                    seeClassesAndUniforms();
                    break;

                case 3 :
                    start = true;
                    System.out.println("See you later :) ");
                    break;

                default:
                    System.out.println("wrong/non-existent option");
                    break;
            }
        }



    }



    public void createYearEndUniform(){
        Scanner input = new Scanner(System.in);

        System.out.println("Which class create the uniforms");

        Integer classId = input.nextInt();


        System.out.println("How many uniforms you want to create, limit: 60");

        Integer amount = input.nextInt();

        YearEndUniform uniformExample = new YearEndUniform("Vinicius","White or Red", "P , M or G");
        System.out.println("This is an example of the characteristics of a uniform" + "\n");
        System.out.println("Name of the student : " + uniformExample.getName() + "\n");
        System.out.println("Color: " + uniformExample.uniformColor + " | " + "Size : " + uniformExample.getUniformSize() + "\n");

        for (int i =0; i < amount; i++){

            System.out.println("Enter student name");
            String nameOfStudent = input.next();
            System.out.println("Enter the color");
            String colorOfUniform = input.next();

            System.out.println("Enter the size");
            String sizerOfUniform = input.next();

            YearEndUniform uniform = new YearEndUniform(nameOfStudent,colorOfUniform,sizerOfUniform);

            for (Map.Entry<Integer, List<YearEndUniform>> entry : this.classes.entrySet()) {
                List<YearEndUniform> class1Uniforms = this.classes.get(classId);
                class1Uniforms.add(uniform);
            }


        }

        System.out.println("Successfully created uniforms");

    }


    public void seeClassesAndUniformsAndChoice(){
        Scanner input = new Scanner(System.in);
        for (Map.Entry<Integer, List<YearEndUniform>> entry : this.classes.entrySet()) {
            Integer classNumber = entry.getKey();
            List<YearEndUniform> uniforms = entry.getValue();
            String out;
            if (uniforms.isEmpty()){
                out = "Doesn't have any uniforms yet";
            } else
                out = ":)";
            System.out.println("Class " + classNumber + ": " + out );
        }
        System.out.println("want to create uniform for which class?");

    }

    public void seeClassesAndUniforms(){
        Scanner input = new Scanner(System.in);
        for (Map.Entry<Integer, List<YearEndUniform>> entry : this.classes.entrySet()) {
            Integer classNumber = entry.getKey();
            List<YearEndUniform> uniforms = entry.getValue();
            String out;
            if (uniforms.isEmpty()){
                out = "Doesn't have any uniforms yet";
            } else
                out = "created uniforms: " + uniforms.size();
            System.out.println("Class " + classNumber + ": " + out );
        }

        if (this.classes.isEmpty()){
            System.out.println("no class created");
        }
    }


    public void creatingClasses(){
        for (int i = 1; i <= 7; i++) {
            List<YearEndUniform> listOfUniforms = new ArrayList<>(60);
            this.classes.put(i, listOfUniforms);
        }
    }
    public void options(){
        System.out.println("Welcomer the creater of YearEndUniform");
        System.out.println("[ 1 ] Create new Uniforms");
        System.out.println("[ 2 ] See Class");
        System.out.println("[ 3 ] Close App");


    }


    public void run(){
        layout();
    }


    public static void main(String[] args) {
        Day03Solucao day03Solucao = new Day03Solucao();
        day03Solucao.run();
    }
}
