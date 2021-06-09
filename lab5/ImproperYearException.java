import java.lang.Exception;

public class ImproperYearException extends Exception{

    public ImproperYearException(){
        super("Year is invalid.");
    }


    public ImproperYearException(String message){
        super(message);
    }

}