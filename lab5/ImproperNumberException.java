import java.lang.Exception;

public class ImproperNumberException extends Exception{

    public ImproperNumberException(){
        super("Number of problems is invalid.");
    }


    public ImproperNumberException(String message){
        super(message);
    }

}