package OnThi.SinhVien;

import java.util.Arrays;
import java.util.Scanner;

import OnThi.SinhVien.QuanLySinhVien.SortByFirstName;

public class SinhVienTest {

    // Hàm nhập cứng danh sách sinh viên
    public static void nhapCung(QuanLySinhVien qlsv) {
        SinhVien sv1 = new SinhVien(1, "Nguyễn Văn A", "Hà Nội", 1234567);
        SinhVien sv2 = new SinhVien(2, "Trần Thị B", "TP Hồ Chí Minh", 7654321);
        SinhVien sv3 = new SinhVien(3, "Lê Văn C", "Đà Nẵng", 2345678);
        SinhVien sv4 = new SinhVien(4, "Phạm Văn D", "Hải Phòng", 8765432);

        qlsv.nhapSinhVien(sv1);
        qlsv.nhapSinhVien(sv2);
        qlsv.nhapSinhVien(sv3);
        qlsv.nhapSinhVien(sv4);
    }

    // Hàm nhập tay danh sách sinh viên
    public static void nhapTay(QuanLySinhVien qlsv, Scanner sc) {
        System.out.print("Nhập số lượng sinh viên cần thêm: ");
        int soLuong = sc.nextInt();
        sc.nextLine(); // Bỏ qua dòng thừa

        for (int i = 0; i < soLuong; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));
            System.out.print("Mã sinh viên: ");
            int ma = sc.nextInt();
            sc.nextLine();  // Bỏ qua ký tự xuống dòng
            System.out.print("Họ tên: ");
            String hoTen = sc.nextLine();
            System.out.print("Địa chỉ: ");
            String diaChi = sc.nextLine();
            System.out.print("Số điện thoại (7 chữ số): ");
            int soDienThoai = sc.nextInt();

            SinhVien sv = new SinhVien(ma, hoTen, diaChi, soDienThoai);
            if (!qlsv.nhapSinhVien(sv)) {
                System.out.println("Không thể thêm sinh viên, danh sách đã đầy.");
            }
        }
    }

    // Hàm hiển thị danh sách sinh viên
    public static void hienThiDanhSach(QuanLySinhVien qlsv) {
        System.out.println("Danh sách sinh viên:");
        for (int i = 0; i < qlsv.getSoLuongSinhVien(); i++) {
            System.out.println(qlsv.getDanhSachSinhVien()[i]);
        }
    }

    // Hàm sắp xếp danh sách sinh viên theo tên
    public static void sapXepSinhVienTheoTen(QuanLySinhVien qlsv) {
        SinhVien[] danhSach = qlsv.getDanhSachSinhVien();
        Arrays.sort(danhSach, qlsv.new SortByFirstName());
        System.out.println("Danh sách sinh viên đã được sắp xếp theo tên:");
        hienThiDanhSach(qlsv);
    }

    // Hàm menu để chọn chức năng
    public static void menu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Nhập danh sách sinh viên cứng");
        System.out.println("2. Nhập danh sách sinh viên tay");
        System.out.println("3. Sắp xếp danh sách sinh viên theo tên");
        System.out.println("4. Hiển thị danh sách sinh viên");
        System.out.println("5. Thoát");
        System.out.println("================");
        System.out.print("Chọn chức năng: ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Tạo đối tượng QuanLySinhVien không giới hạn trước
        QuanLySinhVien qlsv = new QuanLySinhVien();

        // Menu lựa chọn
        int choice;
        do {
            menu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    nhapCung(qlsv); // Nhập cứng
                    break;
                case 2:
                    nhapTay(qlsv, sc); // Nhập tay
                    break;
                case 3:
                    sapXepSinhVienTheoTen(qlsv); // Sắp xếp theo tên
                    break;
                case 4:
                    hienThiDanhSach(qlsv); // Hiển thị danh sách
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 5);

        sc.close();
    }
}
