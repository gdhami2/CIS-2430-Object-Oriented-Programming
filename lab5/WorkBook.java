public class WorkBook extends Book {
    private int numProblems;

    public WorkBook(String title, String author, String ISBN, int year, double price, int numProblems)
    throws ImproperTitleException, ImproperAuthorException, ImproperISBNException,
    ImproperYearException, ImproperPriceException, ImproperNumberException{
        super(title, author, ISBN, year, price);

        if(numProblems > 0){
            this.numProblems = numProblems;
        }else{
            throw new ImproperNumberException();
        }

    }


    public int getNumProblems(){
        return this.numProblems;
    }

    @Override
    public String toString() {
        return String.format("WorkBook { \nTitle: %s\n"
                        + "Author: %s\n"
                        + "ISBN: %s\n"
                        + "Year: %d\n"
                        + "Price: $%.2f\n"
                        + "Number of Problems: %d" + " }", this.getTitle(),
                this.getAuthor(), this.getISBN(), this.getYear(), this.getPrice(), this.numProblems);
    }

    @Override
    public boolean equals(Object o){
        if(this == o) { return true; }
        if(o == null || getClass() != o.getClass()) { return false; }
        if(!super.equals(o)) { return false; }

        WorkBook workBook = (WorkBook) o;

        return this.getISBN().equals(workBook.getISBN());
    }

    @Override
    public int hashCode(){
        return 31 * super.hashCode();
    }

}
