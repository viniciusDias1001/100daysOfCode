package src.Languages.Java.Resolutions.PedroV.Day04;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day04Solucao {
  private Integer numberOfClients;
  private List<String> arraysClients = new ArrayList<>();;
  private String [] receivedList;



  public void Queuesize(){
      Scanner input = new Scanner(System.in);
      System.out.println("What is the Queue Size ?");
      this.numberOfClients = input.nextInt();
      System.out.println("\n");

  }


  public void receiveClientsAndAddClients(){
      boolean start = false;
      while(!start){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the list of clients by values between 1 and 1000 and separated by space");
            String list = input.nextLine();
            if (validListNumber(list)){
                this.receivedList = list.split(" ");
                start = true;
            }else
                System.out.println("enter numbers only");

  }}
  public void addClients(){
          if (this.receivedList.length == this.numberOfClients) {
              for (String client : this.receivedList) {
                  this.arraysClients.add(client);
              }

          } else
              System.out.println("add a list with " + this.numberOfClients + " client/clients");
      }




      public void checkHowmManyCustomersAreOutOfPlace(){
          List<Integer> newListOfInteger = new ArrayList<>();
          Integer quant = 0;
            for (String clientString : this.arraysClients){
                newListOfInteger.add(Integer.parseInt(clientString));


            }

            int position = 0;
          for (int i = 1; i < newListOfInteger.size(); i++){
              if (newListOfInteger.get(i) < newListOfInteger.get(position)){
                  System.out.println("Menor");
                  position++;

              } else
                  System.out.println("maior");
              position++;

          }

          System.out.println(quant);
      }

  public boolean validListNumber(String list){
      if (list.matches("(\\d+\\s+)*\\d+"))
          return true;
      else
        return false;
  }


  public void bank(){
      Queuesize();
      receiveClientsAndAddClients();
      addClients();
      checkHowmManyCustomersAreOutOfPlace();
      System.out.println(this.arraysClients);



  }
















    public void run(){
      this.bank();
    }
    public static void main(String[] args) {
      Day04Solucao day04 = new Day04Solucao();
      day04.run();

    }



}









