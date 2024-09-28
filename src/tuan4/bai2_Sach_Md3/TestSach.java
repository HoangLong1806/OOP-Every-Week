package tuan4.bai2_Sach_Md3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TestSach {

    static void nhapCung(QuanLySach thuVien) throws Exception {
        thuVien.themSach(new SachGiaoKhoa("A123", LocalDate.of(2021, 9, 10), 10000, 5, "NXB1", true));
        thuVien.themSach(new SachThamKhao("B123", LocalDate.of(2021, 9, 10), 20000, 3, "NXB2", 0.1));

        for (Sach sach : thuVien.xuatDanhSachSach()) {
            thuVien.xuatSach(sach);
        }
    }

    static void menu() {
        System.out.println("----- MENU -----");
        System.out.println("1. Nhập danh sách sách");
        System.out.println("2. Xuất danh sách sách");
        System.out.println("3. Tính tổng thành tiền sách giáo khoa");
        System.out.println("4. Tính trung bình cộng đơn giá sách tham khảo");
        System.out.println("5. Xuất các sách giáo khoa của nhà xuất bản X");
        System.out.println("6. Nhập cùng");
        System.out.println("7. Sắp xếp sách theo mã sách");
        System.out.println("8. Sắp xếp sách theo đơn giá");
        System.out.println("9. Sắp xếp sách theo số lượng");
        System.out.println("0. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    static void nhapSach() {
        Scanner scanner = new Scanner(System.in);
        QuanLySach thuVien = new QuanLySach();
        boolean running = true;

        while (running) {
            try {
                menu();
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        thuVien.nhapDanhSachSach(scanner);
                        break;
                    case 2:
                        for (Sach sach : thuVien.xuatDanhSachSach()) {
                            thuVien.xuatSach(sach);
                        }
                        break;
                    case 3:
                        System.out.println("Tổng thành tiền sách giáo khoa: " + thuVien.tongThanhTienSachGiaoKhoa());
                        break;
                    case 4:
                        System.out.println("Trung bình cộng đơn giá sách tham khảo: " + thuVien.trungBinhDonGiaSachThamKhao());
                        break;
                    case 5:
                        System.out.print("Nhập nhà xuất bản cần tìm sách giáo khoa: ");
                        String nhaXuatBan = scanner.nextLine();
                        for (Sach sach : thuVien.xuatSachGiaoKhoaNhaXuatBan(nhaXuatBan)) {
                            thuVien.xuatSach(sach);
                        }
                        break;
                    case 6:
                        nhapCung(thuVien);
                        break;
                    case 7:
                        thuVien.sapXepTheoMaSach();
                        for (Sach sach : thuVien.xuatDanhSachSach()) {
                            thuVien.xuatSach(sach);
                        }
                        break;
                    case 8:
                        thuVien.sapXepTheoDonGia();
                        for (Sach sach : thuVien.xuatDanhSachSach()) {
                            thuVien.xuatSach(sach);
                        }
                        break;
                    case 9:
                        thuVien.sapXepTheoSoLuong();
                        for (Sach sach : thuVien.xuatDanhSachSach()) {
                            thuVien.xuatSach(sach);
                        }
                        break;
                    case 0:
                        running = false;
                        System.out.println("Kết thúc chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        nhapSach();
    }
}
