import java.lang.Exception;

public class ImproperAuthorException extends Exception{

    public ImproperAuthorException(){
        super("Author name is invalid.");
    }

    public ImproperAuthorException(String message){
        super(message);
    }

}