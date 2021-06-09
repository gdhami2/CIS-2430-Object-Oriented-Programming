/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author Dhami777
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.swing.JTextArea;
/**
* Portfolio.
* 
*  
* @author Gurtej Dhami
* @version 2.0
*/
public class Portfolio {
    public Scanner k = new Scanner(System.in);
    private HashMap<String, ArrayList<Integer>> map;
    private ArrayList<Investment> list;
    public Portfolio(){
        list = new ArrayList();
        map = new HashMap();
    }
    /**
     * adds a stock or mutual fund to the array list. 
     * provided as input.
     * @param symbol The stock or fund symbol.
     * @param name The stock or fund name.
     * @param quantity The stock or fund quantity.
     * @param price the stock or fund price.
     */
    public void add(String symbol, String name, int quantity, double price, int option, JTextArea jt5){
        for(int j = 0; j <list.size();j++){
            if(list.get(j).getSymbol().equals(symbol)){
                jt5.setText("This symbol already exists");
                return;
            }
        }
        if(option == 0){
            Stock s = new Stock(symbol, name, quantity, price);
            if(!list.contains(s)){
                list.add(s);
                String[] array = name.split(" ");
                ArrayList<Integer> ints; 
                for(int i = 0;i < array.length; i++){
                    ints = map.get(array[i]);
                    if(ints != null){
                        ints.add(list.indexOf(s));
                    }
                    else{
                        map.put(array[i], new ArrayList());
                        ints = map.get(array[i]);
                        ints.add(list.indexOf(s));
                    }
                }
            }
        }
        else{
            MutualFund m = new MutualFund(symbol, name, quantity, price);
            if(!list.contains(m)){
                list.add(m);
                String[] array = name.split(" ");
                ArrayList<Integer> ints; 
                for(int i = 0;i < array.length; i++){
                    ints = map.get(array[i]);
                    if(ints != null){
                        ints.add(list.indexOf(m));
                    }
                    else{
                        map.put(array[i], new ArrayList());
                        ints = map.get(array[i]);
                        ints.add(list.indexOf(m));
                    }
                }
            }
        }
        jt5.setText("Investment has been added");
    }
    /**
     * selling the investment in the manner suggested by the user 
     * provided as input.
     * @param symbol The stock investment or fund investment symbol.
     * @param price The stock investment or fund investment price.
     * @param quantity The stock investment or fund investment quantity.
     */
    public void sell(String symbol, double price, int quantity){
        Stock stock = new Stock(symbol,"", 0, 0);
        MutualFund fund = new MutualFund(symbol,"", 0, 0);
        
        if(list.contains(new Stock(symbol,"", 0, 0))){
            int index = list.indexOf(stock);
            stock = (Stock) list.get(index);
            if(quantity > stock.getQuantity()){
                return;
            }
            stock.sell(price, quantity);
        }
        else if(list.contains(new MutualFund(symbol,"", 0, 0))){
            int index = list.indexOf(fund);
            fund = (MutualFund) list.get(index);
            fund.sell(price, quantity);
        }
        else{
            System.out.println("Investment does not exist.");
        }
    }
    /**
     * calculates and returns the gain 
     */
    public double getGain(JTextArea jta){
        double num = 0;
        for(int i = 0; i < list.size(); i++){
            num += list.get(i).gain();
            jta.append(list.get(i).getName()+ list.get(i).gain()+ "\n");
        }
        return num;
    }
    /**
     * allows the user to make price adjustments to the investment
     */
    public void update(){
        for(int i = 0; i<list.size(); i++){
            System.out.println(list.get(i));
            System.out.println("Enter the new price:");
            double price = k.nextDouble();
            k.nextLine();
            list.get(i).setPrice(price);
        }
    }
    /**
     * saves the data in text file data
     * provided as input.
     * @param str The data to be stored in a file.
     */
    public void write(String str){
        BufferedWriter bw;
        try{
            bw = new BufferedWriter(new FileWriter(str));
            Stock s = new Stock("", "", 0, 0);
            MutualFund m = new MutualFund("", "", 0, 0);
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getClass().equals(s.getClass())){
                    Stock st = (Stock)list.get(i);
                    bw.write("s\n");
                }
                else{
                    MutualFund mf = (MutualFund)list.get(i);
                    bw.write("m\n");
                }
                bw.write(list.get(i).getSymbol());
                bw.write("\n");
                bw.write(list.get(i).getName());
                bw.write("\n");
                bw.write(list.get(i).getQuantity()+"");
                bw.write("\n");
                bw.write(list.get(i).getPrice()+"");
                bw.write("\n");
                bw.write(list.get(i).getbookValue()+"");
                bw.write("\n");
                
            }
            bw.close();   
        }
        catch(IOException e){
            System.out.println("File could not be opened.");
        }
    }
    /**
     * reads in investment data from the file 
     * provided as input.
     * @param str The data to be read.
     */
    public void read(String str){
        BufferedReader br;
        try{
            br = new BufferedReader(new FileReader(str));
            String string = br.readLine();
            while(string != null){
                String symbol = br.readLine();
                String name = br.readLine();
                int quantity = Integer.parseInt(br.readLine());
                double price = Double.parseDouble(br.readLine());
                double bookValue = Double.parseDouble(br.readLine());
                if(str.equals("s")){
                    Stock ns = new Stock(symbol, name, quantity, price);
                    ns.setBookValue(bookValue);
                    list.add(ns);
                }
                else{
                    MutualFund nf = new MutualFund(symbol, name, quantity, price);
                    nf.setBookValue(bookValue);
                    list.add(nf);
                }
                string = br.readLine();
            }
            br.close();
        }
        catch(IOException e){
            System.out.println("File could not be opened.");
        }
    }
    /**
     * searches based on the user provided input 
     * provided as input.
     * @param s The stock investment or fund investment symbol.
     * @param w The stock investment or fund investment keyword.
     * @param range The stock investment or fund investment price range.
     */
     public void search(String s, String w, String range, JTextArea jta){
         ArrayList<Investment> invest = new ArrayList();
         for(int j = 0; j < list.size(); j++ ){
             if(list.get(j).getSymbol().toLowerCase().equals(s.toLowerCase())){
                 invest.add(list.get(j));
             }
         }
         if(s.equals("")){
             invest.addAll(list);
         }
         for(int x = 0; x < list.size(); x++){
             if(range.equals("-")){
                 break;
             }
             if(range.startsWith("-")){
                 String replace = range.replace("-", "");
                 double rng = Double.parseDouble(replace);
                 if(list.get(x).getPrice()< rng){
                     if(!invest.contains(list.get(x))){
                     invest.add(list.get(x));
                 }
                 }
             }
             else if(range.endsWith("-")){
                 String replace = range.replace("-", "");
                 double rng = Double.parseDouble(replace);
                 if(list.get(x).getPrice()> rng){
                     if(!invest.contains(list.get(x))){
                     invest.add(list.get(x));
                 }
                 }
             }
             else if(range.contains("-")){
                 double d1 = Double.parseDouble(range.split("-")[0]);
                 double d2 = Double.parseDouble(range.split("-")[1]);
                 if(list.get(x).getPrice()< d1 && list.get(x).getPrice()>d2){
                     if(!invest.contains(list.get(x))){
                     invest.add(list.get(x));
                 }
                 }
             }
             else{
                 double rng = Double.parseDouble(range);
                 if(list.get(x).getPrice()== rng){
                     if(!invest.contains(list.get(x))){
                     invest.add(list.get(x));
                 }
                 }
             }
         }
         ArrayList<Investment> arrInv = new ArrayList();
         for(int i = 0; i < invest.size(); i++){
             ArrayList<Integer> arrInt = new ArrayList();
             String[] arrString = w.split(" ");
             for(int j = 0; j < arrString.length; j++){
                 arrInt = map.get(arrString[j]);
                 if(arrInt != null){
                     for(int x = 0; x < arrInt.size(); x++){
                         arrInv.add(list.get(arrInt.get(x)));
                     }
                 }
             }
         }
         for(int i = 0; i < arrInv.size(); i++){
             jta.append(arrInv.get(i).toString()+ "\n");
             System.out.println(arrInv.get(i).toString()+ "\n");
         }
         if(invest.size() == 0){
             jta.append("No match found ");
         }


         
     }
}
