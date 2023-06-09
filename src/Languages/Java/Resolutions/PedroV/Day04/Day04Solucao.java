package src.Languages.Java.Resolutions.PedroV.Day04;
import java.util.*;

public class Day04Solucao {
  private Integer numberOfClients;
  private List<String> arraysClients = new ArrayList<>();;
  private String [] receivedList;


  public void Queuesize(){
      Scanner input = new Scanner(System.in);
      boolean start = false;


      while (!start){

          try{
              System.out.println("What is the Queue Size ?");
              this.numberOfClients = input.nextInt();
              System.out.println("\n");
              start = true;
          }catch (InputMismatchException e){
              System.out.println("enter numbers only");
              input.next();

          }

      }

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

  public List<Integer> sortList(List<String> list){
      List<Integer> newListOfIntegerOut = new ArrayList<>();
      for (String clientString : list){
          newListOfIntegerOut.add(Integer.parseInt(clientString));
      }
      Collections.sort(newListOfIntegerOut, Comparator.reverseOrder());
      System.out.println("SortList: " + newListOfIntegerOut);

      return newListOfIntegerOut;
  }

  public Integer checkHowmManyCustomersAreOutOfPlace(List<String> list){
          List<Integer> newListOfInteger = new ArrayList<>();
          Integer quant = 0;
            for (String clientString : list){
                newListOfInteger.add(Integer.parseInt(clientString));
            }
            int position = 0;
            int fm = 1;
          for (int i = 0; i < newListOfInteger.size(); i++){
              if (newListOfInteger.get(position) > newListOfInteger.get(fm )){
                position++;
                fm++;
              } else{
                  position++;
                  fm++;
                  quant++;
              }
          }
          System.out.println("\n" + "Number of customers who moved: " + quant);

          return quant;
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
      checkHowmManyCustomersAreOutOfPlace(this.arraysClients);
      sortList(this.arraysClients);
  }


    public void run(){
      this.bank();
    }
    public static void main(String[] args) {
      Day04Solucao day04 = new Day04Solucao();
      day04.run();
    }


}









