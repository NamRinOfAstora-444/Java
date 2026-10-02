import java.util.ArrayList;

public class Result {
    boolean status;
    String message;
    ArrayList<Integer> content;

    public Result(boolean status, String message, ArrayList<Integer> content)
    {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public String printRestult(){
        return "status" + status + "message" + message + "content" + content;
    }
}
