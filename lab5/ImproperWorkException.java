import java.lang.Exception;

public class ImproperWorkException extends Exception{

    public ImproperWorkException(){
        super("Workbook ISBN code is invalid.");
    }


    public ImproperWorkException(String message){
        super(message);
    }

}