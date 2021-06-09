/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

/**
 *
 * @author Dhami777
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Bookstore{
    private ArrayList<Book> bookList = new ArrayList();
    public void run(){
        int choice = 0;
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("1. Add a unique book to the inventory");
        System.out.println("2. Print out information on each book");
        System.out.println("3. Print out all unique authors");
        System.out.println("4. Print out average book price, along with the number of books ");
        System.out.println("5. Quit");
        
        while(choice != 5){
            System.out.println("What would you like to do?");
            try{
                choice = s.nextInt();
                s.nextLine();
            }
            catch(InputMismatchException e){
                s.nextLine();
            }
            if(choice != 5&&choice != 4&&choice != 3&&choice != 2&&choice != 1){
                    System.out.println("Please enter a valid integer");
                }
            else if(choice == 1){
                this.run1();
            }
            else if(choice == 2){
                this.run2();
            }
            else if(choice == 3){
                this.run3();
            }
            else if(choice == 4){
                this.run4();
            }
        }
    }
    public void run1(){
        Scanner s = new Scanner(System.in);
        System.out.println("Title:");
        String curTitle = s.nextLine();
        System.out.println("Author:");
        String curAuthor = s.nextLine();
        int curYear;
        do{
        System.out.println("Year:");
        curYear = -2601;
        try{
            curYear = s.nextInt();
            s.nextLine();
        }
        catch(InputMismatchException e){
            System.out.println("Input not valid");
            s.nextLine();
        }
        }while(curYear < -2600 || curYear > 2017);
        String curIsbn;
        do{
        System.out.println("isbn:");
        curIsbn = s.nextLine();
        }while(curIsbn.length() < 10 || curIsbn.length() > 13);
        double curPrice;
        do{
            System.out.println("Price:");
            curPrice = -10;
            try{
                curPrice = s.nextDouble();
                s.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println("Input not valid");
                s.nextLine();
            }
        }while(curPrice < 0);
        
                
        Book b = new Book(curTitle,curIsbn,curAuthor,curPrice,curYear);
                this.bookList.add(b);
    }
    public void run2(){
        for(int i =0; i < bookList.size(); i++){
            System.out.println(bookList.get(i));
        }
    }
    public void run3(){
        ArrayList<String> str = new ArrayList();
        for(int i = 0; i < bookList.size(); i++){
            if(!str.contains(bookList.get(i).getAuthor())){
                str.add(bookList.get(i).getAuthor());
            }
        }
        for(int i =0; i < str.size(); i++){
            System.out.println(str.get(i));
        }
    }
    public void run4(){
        double avg = 0.0;
        for(int i =0; i < bookList.size(); i++){
            avg+= bookList.get(i).getPrice();
        }
        System.out.println("Avg; " + avg/(double) bookList.size());
        System.out.println("Number of books; " + bookList.size());
    }
    
}
