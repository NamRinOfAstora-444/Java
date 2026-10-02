package QuickSort;

import java.util.Arrays;

public class Result {
    boolean status;
    String message;
    int[] content;

    public Result(boolean status, String message, int[] content)
    {
        this.status = status;
        this.message = message;
        this.content = content;
    }

    public String printRestult(){
        return "status: " + status + "\nmessage: " + message + "\ncontent: " + Arrays.toString(content);
    }
}
