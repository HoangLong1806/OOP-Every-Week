package tuan4.bai2_Sach_Md3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLySach {
    private ArrayList<Sach> danhSachSach;

    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    // Method to input a list of books
    public void nhapDanhSachSach(Scanner scanner) throws Exception {
        System.out.print("Nhập số lượng sách: ");
        int soLuongSach = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < soLuongSach; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1));
            System.out.print("Sách giáo khoa (1) hay sách tham khảo (2): ");
            int loaiSach = Integer.parseInt(scanner.nextLine());

            Sach sach;
            if (loaiSach == 1) {
                sach = nhapSachGiaoKhoa(scanner);
            } else {
                sach = nhapSachThamKhao(scanner);
            }
            danhSachSach.add(sach);
        }
    }
    private SachGiaoKhoa nhapSachGiaoKhoa(Scanner scanner) {
        SachGiaoKhoa sach = new SachGiaoKhoa();

        System.out.print("Nhập mã sách: ");
        sach.setMaSach(scanner.nextLine());

        System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sach.setNgayNhap(LocalDate.parse(scanner.nextLine(), formatter));

        System.out.print("Nhập đơn giá: ");
        sach.setDonGia(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhập số lượng: ");
        sach.setSoLuong(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nhập nhà xuất bản: ");
        sach.setNhaXuatBan(scanner.nextLine());

        System.out.print("Nhập tình trạng sách (true = mới, false = cũ): ");
        sach.setTinhTrang(scanner.nextBoolean());
        scanner.nextLine();  // Clear buffer

        return sach;
    }

    private SachThamKhao nhapSachThamKhao(Scanner scanner) {
        SachThamKhao sach = new SachThamKhao();

        System.out.print("Nhập mã sách: ");
        sach.setMaSach(scanner.nextLine());

        System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sach.setNgayNhap(LocalDate.parse(scanner.nextLine(), formatter));

        System.out.print("Nhập đơn giá: ");
        sach.setDonGia(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhập số lượng: ");
        sach.setSoLuong(Integer.parseInt(scanner.nextLine()));

        System.out.print("Nhập nhà xuất bản: ");
        sach.setNhaXuatBan(scanner.nextLine());

        System.out.print("Nhập thuế: ");
        sach.setThue(Double.parseDouble(scanner.nextLine()));

        return sach;
    }

    // Method to output the list of books
    public ArrayList<Sach> xuatDanhSachSach() {
        return new ArrayList<>(danhSachSach);
    }

    public void xuatSach(Sach sach) {
        System.out.println(sach.toString());
    }

    // Method to output the list of books
    

    // Method to calculate the total value of textbooks (Sach Giao Khoa)
    public double tongThanhTienSachGiaoKhoa() {
        double tong = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa) {
                tong += sach.thanhTien();
            }
        }
        return tong;
    }

    // Method to calculate the average price of reference books (Sach Tham Khao)
    public double trungBinhDonGiaSachThamKhao() {
        double tongDonGia = 0;
        int soLuongSachThamKhao = 0;
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachThamKhao) {
                tongDonGia += sach.getDonGia();
                soLuongSachThamKhao++;
            }
        }
        return soLuongSachThamKhao > 0 ? tongDonGia / soLuongSachThamKhao : 0;
    }

    // Method to output textbooks from a specific publisher
    public ArrayList<Sach> xuatSachGiaoKhoaNhaXuatBan(String nhaXuatBan) {
        ArrayList<Sach> result = new ArrayList<>();
        for (Sach sach : danhSachSach) {
            if (sach instanceof SachGiaoKhoa && sach.getNhaXuatBan().equalsIgnoreCase(nhaXuatBan)) {
                result.add(sach);
            }
        }
        return result;
    }

    // Method to add a book to the list
    public void themSach(Sach object) throws Exception {
        if(!danhSachSach.contains(object)) {
        	danhSachSach.add(object);
        } else 
        	throw new Exception("Trùng Mã Sách");
    }

    // Method to sort books by maSach
    public void sapXepTheoMaSach() {
        Collections.sort(danhSachSach);
    }

    // Method to sort books by donGia
    public void sapXepTheoDonGia() {
        Collections.sort(danhSachSach, Comparator.comparingDouble(Sach::getDonGia));
    }

    // Method to sort books by soLuong
    public void sapXepTheoSoLuong() {
        Collections.sort(danhSachSach, Comparator.comparingInt(Sach::getSoLuong));
    }
}
