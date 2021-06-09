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
import java.util.ArrayList;
import java.util.Scanner;
public class Portfolio {

     private ArrayList<Stock> stockList = new ArrayList();
     private ArrayList<MutualFund> fundList = new ArrayList();
     /**
     * Creates a new stock and adds to list
     * @param symbol The symbol associated with stock
     * @param name The name associated with stock
     * @param quantity The quantity associated with stock
     * @param price The price associated with stock
     */
     public void addStock(String symbol, String name, int quantity, double price){
         Stock newStock = new Stock(symbol, name, quantity, price);
         stockList.add(newStock);
     }
     /**
     * Creates a new mutual fund and adds to list
     * @param symbol The symbol associated with mutual fund
     * @param name The name associated with mutual fund
     * @param quantity The quantity associated with mutual fund
     * @param price The price associated with mutual fund
     */
     public void addFund(String symbol, String name, int quantity, double price){
         MutualFund newFund = new MutualFund(symbol, name, quantity, price);
         fundList.add(newFund);
     }
     /**
     * Gets the total gain
     * @return togain
     */
     public double getDoub(){
         double toGain = 0;
         for(int i = 0; i < stockList.size(); i++){
          Stock temp = stockList.get(i);
             toGain += temp.getPrice()*temp.getQuantity() - temp.getbookValue();   
         }
         for(int i = 0; i < fundList.size(); i++){
          MutualFund temp = fundList.get(i);
             toGain += temp.getPrice()*temp.getQuantity() - temp.getbookValue();   
         }
         return toGain;
     }
     /**
     * Sells the stock
     * @param symbol symbol associated with stock
     * @param sellQuantity value of sell associated with stock
     */
     public void sellStock(String symbol, int sellQuantity){
         
         if(stockList.contains(new Stock(symbol, "", 0,0))){
             int j = stockList.indexOf(new Stock(symbol, "", 0,0));
             stockList.get(j).sell(sellQuantity);
         }
        
     }
     /**
     *Sells the fund 
     * @param symbol symbol for mutual fund
     * @param sellQuantity value of sell for mutual fund
     */
     public void sellFund(String symbol, int sellQuantity){
         
         if(fundList.contains(new MutualFund(symbol, "", 0,0))){
             int j = fundList.indexOf(new MutualFund(symbol, "", 0,0));
             fundList.get(j).sell(sellQuantity);
         }
    }
     /**
     *updates the stock
     */
     public void updateStock(){
      Scanner s = new Scanner(System.in);
      for(int k = 0 ; k < stockList.size(); k++){
          System.out.println(stockList.get(k));
          System.out.println("Please enter a new price: ");
          double newPrice = s.nextDouble();
          s.nextLine();
          stockList.get(k).update(newPrice);
      }
     }
     /**
     *updates the mutual fund
     */
     public void updateFund(){
      Scanner s = new Scanner(System.in);
      for(int k = 0 ; k < fundList.size(); k++){
          System.out.println(fundList.get(k));
          System.out.println("Please enter a new price: ");
          double newPrice = s.nextDouble();
          s.nextLine();
          fundList.get(k).update(newPrice);
      }
     }
     /** 
     * @param s of type Stock 
     * @return The stock if it's in the list.
     */
     public boolean containsStock(Stock s){
         return stockList.contains(s);
     }
     /**
     * @param s of type MutualFund 
     * @return The mutual fund if it's in the list.
     */
     public boolean containsFund(MutualFund s){
         return fundList.contains(s);
     }
     /**
     *Searches the stock and then prints the information 
     * @param s of type String
     * @param w of type String
     * @param range of type String
     */
     public void searchStock(String s, String w, String range){
         for(int j = 0; j < stockList.size(); j++ ){
             if(stockList.get(j).getSymbol().toLowerCase().equals(s.toLowerCase())){
                 System.out.println(stockList.get(j));
             }
         }
         for(int x = 0; x <= stockList.size(); x++){
             if(range.equals("")){
                 break;
             }
             if(range.startsWith("-")){
                 String replace = range.replace("-", "");
                 double rng = Double.parseDouble(replace);
                 if(stockList.get(x).getPrice()< rng){
                     System.out.println(stockList.get(x));
                 }
             }
             else if(range.endsWith("-")){
                 String replace = range.replace("-", "");
                 double rng = Double.parseDouble(replace);
                 if(stockList.get(x).getPrice()> rng){
                     System.out.println(stockList.get(x));
                 }
             }
             else{
                 double d1 = Double.parseDouble(range.split("-")[0]);
                 double d2 = Double.parseDouble(range.split("-")[1]);
                 if(stockList.get(x).getPrice()< d1 && stockList.get(x).getPrice()>d2){
                     System.out.println(stockList.get(x));
                 }
             }
         }
         
     }
     /**
     *Searches the mutual fund and prints the information 
     * @param s of type String
     * @param w of type String
     * @param range of type String
     */
     public void searchFund(String s, String w, String range){
         for(int j = 0; j < fundList.size(); j++ ){
             if(fundList.get(j).getSymbol().toLowerCase().equals(s.toLowerCase())){
                 System.out.println(fundList.get(j));
             }
         }
         for(int x = 0; x <= fundList.size(); x++){
             if(range.equals("")){
                 break;
             }
             if(range.startsWith("-")){
                 String replace = range.replace("-", "");
                 double rng = Double.parseDouble(replace);
                 if(fundList.get(x).getPrice()< rng){
                     System.out.println(fundList.get(x));
                 }
             }
             else if(range.endsWith("-")){
                 String replace = range.replace("-", "");
                 double rng = Double.parseDouble(replace);
                 if(fundList.get(x).getPrice()> rng){
                     System.out.println(fundList.get(x));
                 }
             }
             else{
                 double d1 = Double.parseDouble(range.split("-")[0]);
                 double d2 = Double.parseDouble(range.split("-")[1]);
                 if(fundList.get(x).getPrice()< d1 && fundList.get(x).getPrice()>d2){
                     System.out.println(fundList.get(x));
                 }
             }
         }
         
     }
}    
