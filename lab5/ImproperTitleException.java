import java.lang.Exception;

public class ImproperTitleException extends Exception{

    public ImproperTitleException(){
        super("Title is invalid.");
    }

    public ImproperTitleException(String message){
        super(message);
    }

}