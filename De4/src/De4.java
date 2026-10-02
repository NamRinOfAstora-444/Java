import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class De4 {

    public static class listUV {
        String tenUV;
        String vtu;
        LocalTime startUV;
        LocalTime endUV;
        
        public listUV (String tenUV, String vtu, LocalTime startUV, LocalTime endUV) {
            this.tenUV = tenUV;
            this.vtu = vtu;
            this.startUV = startUV;
            this.endUV = endUV;
        }
    }

    public static class listNPV {
        String tenNPV;
        String cm;
        int sluv;
        LocalTime startNPV;
        LocalTime endNPV;
        
        public listNPV (String tenNPV, String cm, int sluv, LocalTime startNPV, LocalTime endNPV) {
            this.tenNPV = tenNPV;
            this.cm = cm;
            this.sluv = sluv;
            this.startNPV = startNPV;
            this.endNPV = endNPV;
        }
    }

    public static class listLPV {
        String tenUV;
        String tenNPV;
        String vtu;
        LocalTime startUV;
        LocalTime endUV;
        
        public listLPV (String tenUV, String tenNPV, String vtu, LocalTime startUV, LocalTime endUV) {
            this.tenUV = tenUV;
            this.tenNPV = tenNPV;
            this.vtu = vtu;
            this.startUV = startUV;
            this.endUV = endUV;
        }

        @Override
        public String toString() {
            return "\n  - [Ung vien: " + tenUV 
                 + " | Nguoi phong van: " + tenNPV 
                 + " | Vi tri: " + vtu 
                 + " | Thoi gian: " + startUV + " - " + endUV + "]";
        }
    }

    public static void main(String[] args) {
        Result result = XepLich();
        System.out.println(result.printRestult());
    }

    public static Result XepLich() {
        Scanner sc = new Scanner (System.in);
        System.out.print("Nhap so luong ung vien: ");

        if(!sc.hasNextInt()){
            return new Result(false, "So luong ung vien phai la so nguyen", null);
        }
        int n = sc.nextInt();
        sc.nextLine();
        if(n <= 0){
            return new Result(false, "Khong co ung vien de sap xep lich phong van", null);
        }

        ArrayList<listUV> listUV = new ArrayList<>(n);

        // Nhap danh sach ung vien start//
        for(int i = 0; i < n; i++){
            System.out.print("Nhap ten ung vien: ");
            String tenUV = sc.nextLine();
            if (!tenUV.matches("[\\p{L}]+( [\\p{L}]+)*")) {
                return new Result(false, "Ten ung vien khong hop le, khong the thuc hien sap xep lich", null);
            }

            System.out.print("Nhap vi tri ung tuyen: ");
            String vtu = sc.nextLine();
            if (!vtu.matches("[\\p{L}]+( [\\p{L}]+)*")) {
                return new Result(false, "Ten vi tri ung tuyen khong hop le, khong the thuc hien sap xep lich", null);
            }

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            System.out.print("Nhap thoi gian bat dau tham gia phong van duoc cua ung vien: ");
            String startTime = sc.nextLine();
            if (!startTime.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
                return new Result ( false, "Thoi gian tham gia phong van duoc cua ung vien khong hop le", null );
            }
            LocalTime startUV = LocalTime.parse(startTime, formatter);

            System.out.print("Nhap thoi gian ket thuc tham gia phong van duoc cua ung vien: ");
            String endTime = sc.nextLine();
            if (!endTime.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
                return new Result ( false, "Thoi gian tham gia phong van duoc cua ung vien khong hop le", null );
            }
            LocalTime endUV = LocalTime.parse(endTime, formatter);

            if (!endUV.isAfter(startUV)) {
                return new Result(false, "Thoi gian tham gia phong van duoc cua ung vien khong hop le", null);
            }

            listUV.add(new listUV(tenUV, vtu, startUV, endUV));
        }
        // Nhap danh sach ung vien end//

        System.out.print("Nhap so luong nguoi phong van: ");
        if(!sc.hasNextInt()){
            System.out.print("So luong nguoi phong van phai la so nguyen.");
        }
        int m = sc.nextInt();
        sc.nextLine();
        if(m <= 0){
            return new Result(false, "Khong co nguoi phong van de sap xep lich phong van", null);
        }

        ArrayList<listNPV> listNPV = new ArrayList<>(m);

        // Nhap danh sach nguoi phong van start//
        for(int j = 0; j < m; j++){
            System.out.print("Nhap ten nguoi phong van: ");
            String tenNPV = sc.nextLine();
            if (!tenNPV.matches("[\\p{L}]+( [\\p{L}]+)*")) {
                return new Result( false, "Ten nguoi phong van khong hop le, khong the thuc hien sap xep lich", null);
            }

            System.out.print("Nhap vi tri ung tuyen: ");
            String cm = sc.nextLine();
            if (!cm.matches("[\\p{L}]+( [\\p{L}]+)*")) {
                return new Result(false, "Ten vi tri ung tuyen khong hop le, khong the thuc hien sap xep lich", null);
            }

            int sluv = 0;

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            System.out.print("Nhap thoi gian bat dau tham gia phong van duoc cua nguoi phong van: ");
            String startTime = sc.nextLine();
            if (!startTime.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
                return new Result ( false, "Thoi gian tham gia phong van duoc cua nguoi phong van khong hop le", null );
            }
            LocalTime startNPV = LocalTime.parse(startTime, formatter);

            System.out.print("Nhap thoi gian ket thuc tham gia phong van duoc cua nguoi phong van: ");
            String endTime = sc.nextLine();
            if (!endTime.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
                return new Result ( false, "Thoi gian tham gia phong van duoc cua nguoi phong van khong hop le", null );
            }
            LocalTime endNPV = LocalTime.parse(endTime, formatter);

            if (!endNPV.isAfter(startNPV)) {
                return new Result(false, "Thoi gian tham gia phong van duoc cua nguoi phong van khong hop le", null);
            }

            listNPV.add(new listNPV(tenNPV, cm, sluv, startNPV, endNPV));
        }
        // Nhap danh sach nguoi phong van end//

        // Sap xep danh sach ung vien Start//
        for (int sortUV = 0; sortUV < n - 1; sortUV++) {
            for (int i = 0; i < n - 1 - sortUV; i++) {
                listUV uv1 = listUV.get(i);
                listUV uv2 = listUV.get(i + 1);

                if (uv1.startUV.isAfter(uv2.startUV) || (uv1.startUV.equals(uv2.startUV) && uv1.endUV.isAfter(uv2.endUV))) {
                    listUV.set(i, uv2);
                    listUV.set(i + 1, uv1);
                }
            }
        }

        ArrayList<listLPV> listLPV = new ArrayList<>();
        // Xep lich Start//
        for (int i = 0; i < n; i++) {
            
            // Sap xep danh sach nguoi phong van Start//
            for (int sortNPV = 0; sortNPV < m - 1; sortNPV++) {
                for (int j = 0; j < m - 1 - sortNPV; j++) {
                    listNPV npv1 = listNPV.get(j);
                    listNPV npv2 = listNPV.get(j + 1);

                    if (npv1.startNPV.isAfter(npv2.startNPV) || (npv1.startNPV.equals(npv2.startNPV) && npv1.endNPV.isAfter(npv2.endNPV)) || (npv1.startNPV.equals(npv2.startNPV) && npv1.endNPV.equals(npv2.endNPV) && (npv1.sluv > npv2.sluv))){
                        listNPV.set(j, npv2);
                        listNPV.set(j + 1, npv1);
                    }
                }
            }
            // Sap xep danh sach nguoi phong van End//

            // Xep lich Real 100% Start//
            for (int j = 0; j < m; j++) {
                if (listUV.get(i).vtu.equals(listNPV.get(j).cm)) {
                    LocalTime startA = listUV.get(i).startUV.isAfter(listNPV.get(j).startNPV) 
                           ? listUV.get(i).startUV 
                           : listNPV.get(j).startNPV;

                    LocalTime endA = listUV.get(i).endUV.isBefore(listNPV.get(j).endNPV) 
                         ? listUV.get(i).endUV 
                         : listNPV.get(j).endNPV;

                    if (!startA.plusMinutes(30).isAfter(endA)) {
                        listLPV.add(new listLPV(listUV.get(i).tenUV, listNPV.get(j).tenNPV, listUV.get(i).vtu, startA, endA));
                        listNPV.get(j).sluv++;
                        listNPV.get(j).startNPV = startA.plusMinutes(30);
                        break;
                    }
                }
            }
        }

        if (listLPV.isEmpty()) {
            return new Result (false, "Khong co lich phong van nao duoc sap xep", null);
        }
            
        return new Result (true, "Lich phong van da duoc sap xep", listLPV);
    }
}