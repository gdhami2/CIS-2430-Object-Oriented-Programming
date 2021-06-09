package lab3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Lab3 extends JFrame{
    private BookStore store;
    private JTextField inputField;
    private JTextArea outputArea;
    String title;
    String author;
    String isbn;
    int year;
    double price;
    String subject;
    String workISBN;
    int numProbs;

    int userInput;
    int state1 = 000;
    int state2 = 000;
    int bookType = 000;

    public Lab3(){
        super("A Bookstore");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 2));

        store = new BookStore();
        

        inputField = new JTextField(50);
        inputField.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
                
                
                if(state1 == 0){
                    if(validateInt(inputField.getText())){
                        userInput = Integer.parseInt(inputField.getText());
                    }else{
                        userInput = -1;
                    }
                    
                    if(userInput == 1){
                        state1 = 1;
                        outputArea.setText("1 - To add a book\n");
                        outputArea.append(" 2 -To add a Textbook\n");
                        outputArea.append(" 3 - To add Workbook\n");
                        outputArea.append("Enter your choice:\n");
                    }else if(userInput == 2){
                        outputArea.setText("");
                        ArrayList<String> books = store.getBooks();
                        for(String s : books){
                            outputArea.append(s + "\n");
                        }
                        outputArea.append("\n");
                    }else if(userInput == 3){
                        ArrayList<String> values = store.getAverage();
                        outputArea.setText("");
                        for(String v : values){
                            outputArea.append(v + "\n");
                        }
                    }else if(userInput == 4){
                        ArrayList<String> authors = store.getAuthors();
                        outputArea.setText("");
                        for(String a : authors){
                            outputArea.append(a + "\n");
                        }
                    }else if(userInput == 5){
                        outputArea.setText("");
                        ArrayList<String> matches = store.getMatching();
                        for(String m : matches){
                            outputArea.append(m + "\n");
                        }
                    }else if(userInput == 6){
                        outputArea.setText("Saved books to file.\n");
                        store.saveBooks();
                    }else if(userInput == 7){
                        outputArea.setText("Loaded books to file.\n");
                        store.loadBooks();
                    }else{
                        outputArea.append("Invalid input, please try again.\n");
                    }
                }else if(state1 == 1){
                    if(state2 == 0){
                        userInput = Integer.parseInt(inputField.getText());
                        if(userInput == 1){   
                            bookType = 001;  
                        }else if(userInput == 2){
                            bookType = 2;
                        }else{
                            bookType = 3;
                        }
                        state2 = 1;
                        outputArea.setText("Enter the title of the book:\n");
                    }else if(state2 == 1){
                        title = inputField.getText();
                        if(validateString(title)){
                            outputArea.setText("Please enter the author of the book:\n");
                            state2 = 2;
                        }else{
                            outputArea.append("Input is invalid, please try again.\n");
                        }
                    }else if(state2 == 2){
                        author = inputField.getText();
                        if(validateString(author)){
                            outputArea.setText("Please enter the ISBN code:\n");
                            state2 = 3;
                        }else{
                            outputArea.append("Input is invalid, please try again.\n");
                        }
                    }else if(state2 == 3){
                        isbn = inputField.getText();
                        if(validateISBN(isbn)){
                            outputArea.setText("Please enter the publish year:\n");
                            state2 = 4;
                        }else{
                            outputArea.append("ISBN is invalid, please try again.\n");
                        }
                        
                    }else if(state2 == 4){
                        if(validateYear(inputField.getText())){
                            year = Integer.parseInt(inputField.getText());
                            outputArea.setText("Please enter the price of the book:\n");
                            state2 = 5;
                        }else{
                            outputArea.append("Year is invalid, please try again.\n");
                        }
                    }else if(state2 == 5){
                        if(validatePrice(inputField.getText())){
                            price = Double.parseDouble(inputField.getText());
                            if(bookType == 1){
                                String str = store.addBook(title, author, isbn, year, price);
                                outputArea.setText(str + "\n");
                                state1 = 0;
                                state2 = 0;
                            }else if(bookType == 2){
                                outputArea.setText("Please enter the subject:\n");
                                state2 = 6;
                            }else{
                                outputArea.setText("Please enter the number of problems:\n");
                                state2 = 6;
                            }
                        }else{
                            outputArea.append("Invalid price, please try again.\n");
                        }
                        
                    }else if(state2 == 6){
                        if(bookType == 3){
                            if(validateInt(inputField.getText())){
                                numProbs = Integer.parseInt(inputField.getText());
                                String str = store.addWorkBook(title, author, isbn, year, price, numProbs);
                                state1 = 0;
                                state2 = 0;
                                outputArea.setText(str + "\n");
                            }else{
                                outputArea.append("Invalid input, please try again.\n");
                            }
                        }else if(bookType == 2){
                            subject = inputField.getText();
                            if(validateString(subject)){
                                outputArea.setText("Please enter the workbook ISBN code:\n");
                                state2 = 7;
                            }else{
                                outputArea.append("Invalid input, please try again.\n");
                            }
                            
                        }
                    }else if(state2 == 7){
                        workISBN = inputField.getText();
                        if(validateISBN(workISBN)){
                            String str = store.addTextBook(title, author, isbn, year, price, subject, workISBN);
                            outputArea.setText(str + "\n");
                            state1 = 0;
                            state2 = 0;
                        }else{
                            outputArea.append("Invalid ISBN code, please try again.\n");
                        }
                        
                    }
                }

                inputField.setText("");
                if(state1 == 0){
                    outputArea.append("Enter your choice:\n");
                }
                
                
                
            }
        });

        outputArea = new JTextArea(10, 10);
        outputArea.setLineWrap(true);
        outputArea.setEditable(false);
        outputArea.setText("Please enter your choice:\n");
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputField);
        add(scrollPane);

    }

    public static void main(String[] args){
        Lab3 prog = new Lab3();
        prog.setVisible(true);
    }


    private boolean validateInput(String input){
        int n = 0;
        try{
            n = Integer.parseInt(input);
            if(n > 4 || n <= 0){
                outputArea.append("Invalid input, please try again.");
                return false;
            }
        }catch(NumberFormatException e){
            outputArea.append("Invalid, please enter a number.");
            return false;
        }

        return true;
    }

    public boolean validateString(String str){
        if(!str.equals("")){
            return true;
        }
        return false;
    }


    public boolean validateInt(String str){
        int n = 0;
        try{
            n = Integer.parseInt(str);
            if(n > 0){
                return true;
            }else{
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
    }


    public boolean validateISBN(String str){
        if(str.length() == 13 || str.length() == 10){
            return true;
        }
        return false;
    }


    public boolean validatePrice(String str){
        double num = 0.0;
        try{
            num = Double.parseDouble(str);
            if(num > 0.0){
                return true;
            }else{
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
    }


    public boolean validateYear(String str){
        int n = 0;
        try{
            n = Integer.parseInt(str);
            if(n >= -2600 && n <= 2017){
                return true;
            }else{
                return false;
            }
        }catch(NumberFormatException e){
            return false;
        }
    }


}
