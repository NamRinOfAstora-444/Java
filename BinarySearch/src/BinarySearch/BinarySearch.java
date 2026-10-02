package BinarySearch;

import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Result result = binarySearch();
        System.out.print(result.printRestult());
    }

    public static Result binarySearch() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong phan tu: ");
        if (! sc.hasNextInt()) {
            return new Result(false, "So luong phan tu phai la so nguyen", -1);
        }
        int n = sc.nextInt();

        int[] array = new int[n];

        if (n <= 0) {
            return new Result(false, "Day so khong co phan tu de tim kiem", -1);
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap gia tri phan tu " + (i+1) + ": ");
            if (! sc.hasNextInt()) {
                return new Result(false, "Phan tu khong phai la so nguyen", -1);
            }
            array[i] = sc.nextInt();
        }

        System.out.print("Day so vua nhap: ");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            if (array[i] > array[i + 1]) {
                return new Result(false, "Day chua duoc sap xep", -1);
            }
            if (array[i] == array[i + 1]) {
                return new Result(false, "Day chua phan tu trung nhau", -1);
            }
        }

        System.out.println("Nhap so can tim: ");
        if (! sc.hasNextInt()) {
            return new Result(false, "So can tim khong phai so nguyen", -1);
        }
        int x = sc.nextInt();

        int l = 0;
        int r = n - 1;

        while (l <= r) {
            int m = l + (r - l)/2;

            if (array[m] == x) {
                return new Result(true, "Tim thay phan tu", m);
            }
            else if (x < array[m]) {
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }
        return new Result(false, "Khong tim thay phan tu", -1);
    }
}
