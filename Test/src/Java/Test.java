package Java;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        drawPineTree();
    }

    public static void drawPineTree() {
        Scanner sc = new Scanner(System.in);

        System.out.print("So tang cua goc can ve: ");
        
        if (!sc.hasNextInt()) {
            System.out.println("So tang cua goc phai la so nguyen");
            return;
        }
  
        int tg = sc.nextInt();

        if (tg <= 1) {
            System.out.println("So tang cua goc phai lon hon 1");
            return;
        }
        sc.close();
        for (int i = 1; i <= tg; i ++) {
            int kt = tg;
            for (int lt = 0; lt < kt; lt++) {
                System.out.print(" ");
            }
                System.out.println("*");
        }

        int tan = tg;

        for (int j = 1; j <= tan; j ++) {
            int tt = tan - j + 2;
            for (int i = 1; i <= tt; i++) {
                int kt = (2*j + 2*i - 4) / 2;
                for (int lt = 0; lt < kt; lt ++) {
                    System.out.print(" ");
                }
                int ds = (2*(tt - i + 1)) - 1;
                for (int ls = 0; ls < ds; ls ++) {		
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
