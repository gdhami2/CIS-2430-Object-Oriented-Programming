package lab3;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private int year;
    private double price;


    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()){ return false; }
        Book book = (Book) o;

        return this.isbn.equals(book.isbn);
    }


    @Override
    public int hashCode() {
        return this.isbn.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Book { \nTitle: %s\n"
                        + "Author: %s\n"
                        + "ISBN: %s\n"
                        + "Year: %d\n"
                        + "Price: $%.2f }", this.title,
                this.author, this.isbn, this.year, this.price);
    }


    public Book(String title, String author, String isbn, int year, double price){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
    }


    public Book(){
        this("", "", "", 0, 0);
    }


    public String getTitle(){ return this.title; }


    public String getISBN(){ return this.isbn; }


    public String getAuthor(){ return this.author; }


    public int getYear(){ return this.year; }


    public double getPrice(){ return this.price; }
}


