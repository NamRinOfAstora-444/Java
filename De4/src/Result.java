import java.util.ArrayList;


public class Result {
    boolean status;
    String message;
    ArrayList content;

    public Result(boolean status, String message, ArrayList content)
    {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public String printRestult(){
        return "\nstatus: " + status + "\nmessage: " + message + "\ncontent: " + content;
    }
}
