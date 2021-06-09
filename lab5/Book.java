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
        return this.isbn.hashCode() * 31;
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


    public Book(String title, String author, String isbn, int year, double price) 
    throws ImproperTitleException, ImproperAuthorException, ImproperISBNException,
    ImproperYearException, ImproperPriceException{

        if(!(title.equals(""))){
            this.title = title;
        }else{
            throw new ImproperTitleException();
        }

        if(!author.equals("")){
            this.author = author;
        }else{
            throw new ImproperAuthorException();
        }

        if(isISBN(isbn)){
            this.isbn = isbn;
        }else{
            throw new ImproperISBNException();
        }

        if(year < 2018 && year >= -2600){
            this.year = year;
        }else{
            throw new ImproperYearException();
        }

        if(price > 0.0){
            this.price = price;
        }else{
            throw new ImproperPriceException();
        }

    }


    public String getTitle(){ return this.title; }


    public String getISBN(){ return this.isbn; }


    public String getAuthor(){ return this.author; }


    public int getYear(){ return this.year; }


    public double getPrice(){ return this.price; }


    public boolean isISBN(String isbn){
        if(isbn.length() == 13 || isbn.length() == 10){
            try{
                Long.parseLong(isbn);
                return true;
            }catch(NumberFormatException e){
                return false;
            }
        }

        return false;
    }

}

