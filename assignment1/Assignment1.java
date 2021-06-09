/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1;

/**
 *
 * @author Dhami777
 */
import java.util.Scanner;

public class Assignment1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String choice = "";
        Scanner s = new Scanner(System.in);
        
        Portfolio store = new Portfolio();
        while(!(choice.equals("quit")||choice.equals("q")||choice.equals("Quit")||choice.equals("Q"))){
          System.out.println("What would you like to do: ");
          choice = s.nextLine();
          if(choice.equals("buy")||choice.equals("Buy")||choice.equals("b")||choice.equals("B")){
              System.out.println("Would you like to buy a stock or a fund? ");
              String usrChoice = s.nextLine();
              if(usrChoice.equals("Stock")||usrChoice.equals("stock")||usrChoice.equals("s")||usrChoice.equals("S")){
                  System.out.println("Symbol: ");
                  String sym = s.nextLine();
                  System.out.println("Name: ");
                  String nme = s.nextLine();
                  System.out.println("Quantity: ");
                  int qnt = s.nextInt();
                  s.nextLine();
                  System.out.println("Price: ");
                  double price = s.nextDouble();
                  s.nextLine();
                  store.addStock(sym, nme, qnt, price);
              }
              else if(usrChoice.equals("fund")||usrChoice.equals("Fund")||usrChoice.equals("f")||usrChoice.equals("F")){
                  System.out.println("Symbol: ");
                  String sym = s.nextLine();
                  System.out.println("Name: ");
                  String nme = s.nextLine();
                  System.out.println("Quantity: ");
                  int qnt = s.nextInt();
                  s.nextLine();
                  System.out.println("Price: ");
                  double price = s.nextDouble();
                  s.nextLine();
                  store.addFund(sym, nme, qnt, price);
              }
          }
          else if(choice.equals("sell")||choice.equals("Sell")||choice.equals("s")||choice.equals("S")){
              System.out.println("Symbol: ");
              String symbol = s.nextLine();
              System.out.println("Price: ");
              int sell = s.nextInt();
              s.nextLine();
              if(store.containsStock(new Stock(symbol, "", 0, 0))){
                  store.sellStock(symbol, sell);
              }
              if(store.containsFund(new MutualFund(symbol, "", 0, 0))){
                  store.sellFund(symbol, sell);
              }
          }
          else if(choice.equals("update")||choice.equals("Update")||choice.equals("u")||choice.equals("U")){
              store.updateStock();
              store.updateFund();
          }
          else if(choice.equals("getGain")||choice.equals("GetGain")||choice.equals("g")||choice.equals("G")){
              double gain = store.getDoub();
              System.out.println(gain);
          }
          else if(choice.equals("search")||choice.equals("Search")||choice.equals("sh")||choice.equals("Sh")){
              System.out.println("Symbol: ");
              String symbol = s.nextLine();
              System.out.println("Word: ");
              String word = s.nextLine();
              System.out.println("Price Range: ");
              String priceRange = s.nextLine();
              store.searchStock(symbol, word, priceRange);
              store.searchFund(symbol, word, priceRange);
          }
          else if(choice.equals("q")||choice.equals("quit")||choice.equals("Quit")||choice.equals("Q")){
              break;
          }
          else{
              System.out.println("Invalid input!");
          }
        }
    }
    
}
