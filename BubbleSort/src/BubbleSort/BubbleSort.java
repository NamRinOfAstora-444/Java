package BubbleSort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 7, 2};
        Result result = bubbleSort(array);
        System.out.println(result.printRestult());
    }

    public static Result bubbleSort  (int[] array)
    {
        int n = array.length;

        if (n == 0)
        {
            return new Result(false, "day so khong co phan tu de sap xep", null);
        }

        if (n == 1)
        {
            return new Result(false, "day co 1 phan tu khong can phai sap xep", null);
        }

        int tong=n-1;

        for (int a=0; a < tong; a++)
        {
            int j=n-1-a;
            for (int i=0; i<j; i++){
                if (array[i] > array[i+1])
                {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return new Result(true, "Day da dc sap xep", array);
    }
}
