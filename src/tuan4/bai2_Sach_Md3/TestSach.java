package tuan4.bai2_Sach_Md3;

import java.util.Date;
import java.util.Scanner;

public class TestSach {
	static void nhapCung() {
		Date ngayNhap = new Date(2021 - 1900, 9 - 1, 10);
		Sach sach1 = new SachGiaoKhoa("A123", ngayNhap, 10000, 5, "NXB1", "moi");
		Sach sach2 = new SachThamKhao("B123", ngayNhap, 20000, 3, "NXB2", 0.1);
		System.out.println(sach1.toString());
		System.out.println(sach2.toString());
		
		
	}
	static void menu() {
		System.out.println("----- MENU -----");
        System.out.println("1. Nhập danh sách sách");
        System.out.println("2. Xuất danh sách sách");
        System.out.println("3. Tính tổng thành tiền sách giáo khoa");
        System.out.println("4. Tính trung bình cộng đơn giá sách tham khảo");
        System.out.println("5. Xuất các sách giáo khoa của nhà xuất bản X");
        System.out.println("6. Nhập cùng");
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
                    	nhapCung();
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
                    case 6: 
						nhapCung();
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
    public static void main(String[] args) {
        nhapSach();
    }
}