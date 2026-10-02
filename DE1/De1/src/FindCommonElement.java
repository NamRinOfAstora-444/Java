import java.util.ArrayList;
import java.util.Scanner;

public class FindCommonElement {
    public static void main(String[] args) {
        Result result = findCommonElement();
        System.out.println(result.printRestult());
    }

    public static Result findCommonElement() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong mang con: ");
        if (!sc.hasNextInt()) {
            return new Result(false, "So luong mang con phai la so nguyen", null);
        }

        int n = sc.nextInt();

        if (n <= 0) {
            return new Result(false, "Mang dau vao khong co mang con, khong kiem tra phan tu trung lap", null);
        }

        int[][] array = new int[n][];

        for (int i = 0; i < n; i++) {
            System.out.print("Nhap so luong phan tu cua mang con thu " + (i+1) + ": ");
            if (!sc.hasNextInt()) {
                return new Result(false, "So luong phan tu trong mang phai la so nguyen, khong tim kiem trung lap", null);
            }

            int m = sc.nextInt();


            if (m <= 0) {
                return new Result(false, "Co mang con khong chua phan tu, khong tim kiem trung lap", null);
            }

            array[i] = new int[m];

            for (int k = 0; k < m; k++) {
                System.out.print("Nhap phan tu thu " + (k+1) + ": ");
                if (!sc.hasNextInt()) {
                    return new Result(false, "Phan tu phai la so nguyen, khong tim kiem trung lap", null);
                }

                array[i][k] = sc.nextInt();

                if (array[i][k] <= 0) {
                    return new Result(false, "Mang con chua phan tu khong phai so tu nhien, khong tim kiem trung lap", null);
                }
            }

            for (int k = 0; k < m - 1; k++) {
                for (int p = k + 1; p < m; p++) {
                    if (array[i][k] == array[i][p]) {
                        return new Result(false, "Mang con chau phan tu trung lap, khong tim kiem trung lap", null);
                    }
                }
            }
        }

        System.out.print(array);

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < array[i].length; k++) {
                System.out.print(array[i][k] + "; ");
            }
            System.out.println();
        }

        ArrayList<Integer> KQ = new ArrayList<>();

        if (n == 1) {
            for (int value : array[0]) {
                KQ.add(value);
            }
            return new Result(true, "Chi co 1 mang con", KQ);
        }

        int[] root = array[0];
        int count = root.length;
        int j = 0;

        while (j < count) {
                    int temp = root[j];
                    int i = 1;

                    while (i < n) {
                        boolean flag = false;
                        int m = array[i].length;
                        int k = 0;

                        while (k < m) {
                            if (array[i][k] == temp) {
                                flag = true;
                                break;
                            }
                            k++;
                        }
                        if (flag == true) {
                            i++;
                        }
                        else{
                            break;
                        }

                    }
                    if (i == n) {
                        KQ.add(temp);
                    }
                    j++;
        }
        if (KQ.size() > 0){
            return new Result(true, "Tìm thấy phần tử trùng:", KQ);
        }
        
        return new Result(false, "Khong Tim thay phan tu chung", KQ);
    }
}