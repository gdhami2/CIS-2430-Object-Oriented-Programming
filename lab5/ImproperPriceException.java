import java.lang.Exception;

public class ImproperPriceException extends Exception{

    public ImproperPriceException(){
        super("Price is invalid.");
    }


    public ImproperPriceException(String message){
        super(message);
    }

}