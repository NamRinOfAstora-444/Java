package LinearSearch;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args){
        Result result = linearSearch();
        System.out.println(result.printRestult());

        
    }

    public static Result linearSearch(){
        Scanner sc = new Scanner(System.in); //Khai báo 
        System.out.print("Nhap so luong phan tu");
        if (! sc.hasNextInt()){
            return new Result (false, "So luong phan tu phai la so nguyen", -1);
        }
        int n = sc.nextInt();
        
        int[] array = new int[n];

        if (n == 0){
            return new Result(false,  "Day khong co phan tu de tim kiem", -1);
        }

        for (int i = 0; i < n; i ++){
            System.out.print("Nhap gia tri phan tu" + i + "");
            if (! sc.hasNextInt()){
                return new Result (false, "Phan tu khong phai la so nguyen", -1);
            }
            array[i] = sc.nextInt();
        }
        System.out.print("Day so vua nhap: ");

        for (int i = 0; i < n; i ++){
            System.out.print(array[i] + "");
        }

        System.out.print("Nhap so can tim");
        if (! sc.hasNextInt()){
            return new Result(false, "So can tim phai la so nguyen", -1);
        }
        int x = sc.nextInt();
      sc.close();
        for (int i = 0; i < n; i++){
            if (array[i] == x){
                return new Result(true, "Tim thay phan tu", i);          
            }
        }
        return new Result(false, "Khong tim thay phan tu", -1);
    }
}