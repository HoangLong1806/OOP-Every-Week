package tuan4.bai2_Sach_Md3;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Sach {
    protected String maSach;
    protected Date ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;

    public Sach() {}

    public Sach(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public void nhapSach(Scanner scanner) {
        try {
            System.out.print("Nhập mã sách: ");
            maSach = scanner.nextLine();
            
            System.out.print("Nhập ngày nhập (dd/MM/yyyy): ");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ngayNhap = sdf.parse(scanner.nextLine());
            
            System.out.print("Nhập đơn giá: ");
            donGia = Double.parseDouble(scanner.nextLine());

            System.out.print("Nhập số lượng: ");
            soLuong = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhập nhà xuất bản: ");
            nhaXuatBan = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập dữ liệu: " + e.getMessage());
        }
    }

    public void xuatSach() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Mã sách: " + maSach);
            System.out.println("Ngày nhập: " + sdf.format(ngayNhap));
            System.out.println("Đơn giá: " + donGia);
            System.out.println("Số lượng: " + soLuong);
            System.out.println("Nhà xuất bản: " + nhaXuatBan);
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất dữ liệu: " + e.getMessage());
        }
    }

    public double thanhTien() {
        return 0;
    }
}
