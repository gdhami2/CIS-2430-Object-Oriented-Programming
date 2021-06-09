import java.lang.Exception;

public class ImproperSubjectException extends Exception{

    public ImproperSubjectException(){
        super("Subject is invalid.");
    }


    public ImproperSubjectException(String message){
        super(message);
    }

}