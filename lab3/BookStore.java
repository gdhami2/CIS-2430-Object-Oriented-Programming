package lab3;

import java.util.HashMap;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class BookStore{
    private HashMap<Integer, Book> booksMap;
    public static final String FILENAME = "books.txt";


    public BookStore(){
        booksMap = new HashMap<>();
    }


    public String addBook(String title, String author, String isbn, int year, double price){
        Book newBook = new Book(title, author, isbn, year, price);
        if(booksMap.containsValue(newBook)){
            return "Book already exists.";
        }else{
            int hashNum = newBook.hashCode();
            booksMap.put(hashNum, newBook);
            
            return "Book has been added";
        }
    }


    public String addTextBook(String title, String author, String isbn, int year, double price, String subject, String workISBN){
        TextBook newTextBook = new TextBook(title, author, isbn, year, price, subject, workISBN);
        if(booksMap.containsValue(newTextBook)){
            return "Textbook with the same ISBN already exists.";
        }else{
            int hashNum = newTextBook.hashCode();
            booksMap.put(hashNum, newTextBook);

            return "Textbook has been added";
        }
    }


    public String addWorkBook(String title, String author, String isbn, int year, double price, int numProbs){
        WorkBook newWorkBook = new WorkBook(title, author, isbn, year, price, numProbs);
        if(booksMap.containsValue(newWorkBook)){
            return "Textbook with the same ISBN already exists.";
        }else{
            int hashNum = newWorkBook.hashCode();
            booksMap.put(hashNum, newWorkBook);

            return "Workbook has been added";
        }
    }


    public ArrayList<String> getAuthors(){
        Collection<Book> booksList = booksMap.values();
        ArrayList<String> authorList = new ArrayList<>();

        for(Book b : booksList){
            if(!authorList.contains(b.getAuthor().toLowerCase())){
                authorList.add(b.getAuthor().toLowerCase());
            }
        }

        return authorList;
    }


    public ArrayList<String> getAverage(){
        Collection<Book> booksList = booksMap.values();
        ArrayList<String> values = new ArrayList<>();
        double avg = 0.0;

        for(Book b : booksList){
            avg += b.getPrice();
        }

        values.add("Number of Books: " + booksList.size());        
        values.add("Average Price: " + avg);

        return values;
    }


    public ArrayList<String> getMatching(){
        Collection<Book> booksList = booksMap.values();
        ArrayList<String> values = new ArrayList<>();

        for(Book b : booksList){
            if(b.getClass() == TextBook.class){
                for(Book sb : booksList){
                    if(sb.getClass() == WorkBook.class){
                        TextBook tb = (TextBook) b;
                        WorkBook wb = (WorkBook) sb;
                        if(tb.getWorkBookISBN().equals(wb.getISBN())){
                            values.add("TextBook: (" + tb.getTitle() + ")" + " \u00A1 = \u00BF " + "Workbook: (" + wb.getTitle() + ").");
                        } 
                    }
                }
            }
        }

        return values;
    }


    public boolean saveBooks(){
        Collection<Book> booksList = booksMap.values();
        BufferedWriter writer;

        try{
            writer = new BufferedWriter(new FileWriter(FILENAME));
            for(Book b : booksList){
                writer.write(b.getClass().getSimpleName().toLowerCase() + "\n");
                writer.write(b.getTitle() + "\n");
                writer.write(b.getAuthor() + "\n");
                writer.write(b.getISBN() + "\n");
                writer.write(b.getYear()  + "\n");
                writer.write(b.getPrice() + "\n");
                if(b.getClass() == TextBook.class){
                    TextBook tb = (TextBook) b;
                    writer.write(tb.getSubject() + "\n");
                    writer.write(tb.getWorkBookISBN() + "\n");
                }
                if(b.getClass() == WorkBook.class){
                    WorkBook wb = (WorkBook) b;
                    writer.write(wb.getNumProblems() + "\n");
                }
            }
            
            writer.close();
            return true;
        }catch(IOException e){
            System.out.println("Could not write to file - " + FILENAME + ".");
            return false;
        }

    }


    public void loadBooks(){
        BufferedReader reader = null;
        String title = "";
        String author = "";
        String ISBN = "";
        String subject = "";
        String workISBN = "";
        int year = 0;
        int numProbs = 0;
        double price = 0.0;

        try{
            reader = new BufferedReader(new FileReader(FILENAME));
            String line = reader.readLine();
            while(line != null){
                title = reader.readLine();
                author = reader.readLine();
                ISBN = reader.readLine();
                year = Integer.parseInt(reader.readLine());
                price = Double.parseDouble(reader.readLine());
                if(line.equals("textbook")){
                    subject = reader.readLine();
                    workISBN = reader.readLine();
                    addTextBook(title, author, ISBN, year, price, subject, workISBN);
                }else if(line.equals("workbook")){
                    numProbs = Integer.parseInt(reader.readLine());
                    addWorkBook(title, author, ISBN, year, price, numProbs);
                }else if(line.equals("book")){
                    addBook(title, author, ISBN, year, price);
                }
                line = reader.readLine();
            }
        }catch(IOException e){
            System.out.println("Could not read the file - " + FILENAME + ".");
        }
    }

    public ArrayList<String> getBooks(){
        ArrayList<String> bookStrings = new ArrayList<>();
        Collection<Book> books = booksMap.values();
        for(Book b : books){
            bookStrings.add(b.toString());
        }

        return bookStrings;
    }


}
