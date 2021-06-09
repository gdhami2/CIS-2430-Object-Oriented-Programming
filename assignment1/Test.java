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
public class Test {
    public static void main(String[] args){
    Stock stock = new Stock("N", "Naruto",10, 10);
    stock.update(20);
    System.out.println("Expected: ");
    System.out.println("80.02");
    System.out.println("Recieved: ");
    System.out.println(stock.getGain());
    
    MutualFund fund = new MutualFund("n", "Naruto",10, 10);
    fund.update(20);
    System.out.println("Expected: ");
    System.out.println("55");
    System.out.println("Recieved: ");
    System.out.println(fund.getGain());
    
    
    stock.update(20);
    System.out.println("Expected: ");
    System.out.println("20");
    System.out.println("Recieved: ");
    System.out.println(stock.getPrice());
    
    fund.update(20);
    System.out.println("Expected: ");
    System.out.println("20");
    System.out.println("Recieved: ");
    System.out.println(fund.getPrice());
    }
}
