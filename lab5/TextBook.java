public class TextBook extends Book {
    private String subject;
    private String workBookISBN;

    public TextBook(String title, String name, String ISBN, int year, double price, String subject, String workBookISBN)
    throws ImproperTitleException, ImproperAuthorException, ImproperISBNException,
    ImproperYearException, ImproperPriceException, ImproperSubjectException, ImproperWorkException{
        super(title, name, ISBN, year, price);
        if(isISBN(workBookISBN)){
            this.workBookISBN = workBookISBN;
        }else{
            throw new ImproperWorkException();
        }
        if(!subject.equals("")){
            this.subject = subject;
        }else{
            throw new ImproperSubjectException();
        }

    }


    public String getSubject(){
        return this.subject;
    }

    public String getWorkBookISBN(){
        return this.workBookISBN;
    }

    @Override
    public String toString(){
        return String.format("TextBook { \nTitle: %s\n"
                        + "Author: %s\n"
                        + "ISBN: %s\n"
                        + "Year: %d\n"
                        + "Price: $%.2f\n"
                        + "Subject: %s\n"
                        + "WorkbookISBN: %s " + "}", this.getTitle(),
                this.getAuthor(), this.getISBN(), this.getYear(), this.getPrice(), this.subject, this.workBookISBN);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) {
            return false;
        }

        TextBook textBook = (TextBook) o;

        return this.getISBN().equals(textBook.getISBN());
    }


    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + this.getISBN().hashCode();
        return result;
    }
}
