import java.lang.Exception;

public class ImproperISBNException extends Exception{

    public ImproperISBNException(){
        super("ISBN code is invalid.");
    }


    public ImproperISBNException(String message){
        super(message);
    }

}