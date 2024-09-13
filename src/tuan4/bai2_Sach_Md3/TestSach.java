package tuan4.bai2_Sach_Md3;

import java.util.Scanner;

public class TestSach {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLySach thuVien = new QuanLySach();
        boolean running = true;

        while (running) {
            try {
                System.out.println("----- MENU -----");
                System.out.println("1. Nhập danh sách sách");
                System.out.println("2. Xuất danh sách sách");
                System.out.println("3. Tính tổng thành tiền sách giáo khoa");
                System.out.println("4. Tính trung bình cộng đơn giá sách tham khảo");
                System.out.println("5. Xuất các sách giáo khoa của nhà xuất bản X");
                System.out.println("0. Thoát");
                System.out.print("Chọn chức năng: ");

                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        thuVien.nhapDanhSachSach(scanner);
                        break;
                    case 2:
                        thuVien.xuatDanhSachSach();
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
                        thuVien.xuatSachGiaoKhoaNhaXuatBan(nhaXuatBan);
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
            System.out.println("--------------------");
        }
        scanner.close();
    }
}
