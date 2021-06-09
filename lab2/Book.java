/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Objects;

/**
 *
 * @author Dhami777
 */
public class Book {
    private String title; 
    private String isbn;
    private String author;
    private double price;
    private int Year; 
    
    public Book(String title, String isbn, String author, double price, int year){
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this. price = price;
        this.Year = year;
    }
    
    public String getTitle(){
        return title;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getAuthor(){
        return author;
    }
    public double getPrice(){
        return price;
    }
    public int getYear(){
        return Year;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.isbn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "title=" + title + ", isbn=" + isbn + ", author=" + author + ", price=" + price + ", Year=" + Year + '}';
    }
    
}
