package QuickSort;

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
        Result result = sort();
        System.out.println(result.printRestult());
    }

    public static Result sort () {
        Scanner sc = new Scanner(System.in); 
        System.out.print("Nhap so luong phan tu: ");
        if (! sc.hasNextInt()){
            return new Result (false, "So luong phan tu phai la so nguyen", null);
        }
        int n = sc.nextInt();

        int[] array = new int[n];

        if (n <= 0){
            return new Result(false,  "Day khong co phan tu de tim kiem", null);
        }

        if (n == 1){
            return new Result(false,  " Day chi co 1 phan tu, khong the sap xep", null);
        }

        for (int i = 0; i < n; i ++){
            System.out.print("Nhap gia tri phan tu" + (i + 1) + ": ");
            if (! sc.hasNextInt()){
                return new Result (false, "Phan tu khong phai la so nguyen", null);
            }
            array[i] = sc.nextInt();
        }
        System.out.print("Day so vua nhap: ");

        for (int i = 0; i < n; i ++){
            System.out.print(array[i] + ": ");
        }

        int i ;
        for (i = 1; i < n; i++){
            if (array[0] != array[i]){
                break;
            }
        }
        if (i == n) {
            return new Result (false, "Tat ca pha tu trong day bang nhau", array);
        }

        for (i = 0; i < n - 1; i++){
            if (array[i] > array[i+1]){
                break;
            }
        }
        if (i == n - 1) {
	        return new Result (false,"Day da duoc sap xep san", array);
        }

        int[] sortedArray = quickSort(array, 1);
        return new Result(true, "Day da duoc sap xep", sortedArray);
    }

    public static int[] quickSort(int[] pv, int tang) {
        int count = pv.length;

        if (count <= 1) {
            return pv;
        }

        int pivot = pv[0];

	    int leftCount = 0;
        int rightCount = 0;
        for (int i = 1; i < count; i++) {
            if (pv[i] <= pivot) {
                leftCount++;
            } else {
                rightCount++;
            }
        }

        int[] left = new int[leftCount];
        int[] right = new int[rightCount];
        int leftIdx = 0;
        int rightIdx = 0;
        int i = 0;
        do {
            i++;
            if (pv[i] <= pivot) {
                left[leftIdx++] = pv[i]; // Đưa sang trái
            } else {
                right[rightIdx++] = pv[i]; // Đưa sang phải
            }
        }
        while (i < count - 1);

        int[] leftSorted = quickSort(left, tang + 1);
        int[] rightSorted = quickSort(right, tang + 1);

        int[] GT = new int[count];

        System.arraycopy(leftSorted, 0, GT, 0, leftSorted.length);

        GT[leftSorted.length] = pivot;

        System.arraycopy(rightSorted, 0, GT, leftSorted.length + 1, rightSorted.length);

        return GT;
    }
}