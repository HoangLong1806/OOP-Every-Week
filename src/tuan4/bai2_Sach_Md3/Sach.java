package tuan4.bai2_Sach_Md3;

import java.util.Date;
import java.text.DecimalFormat;
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

    public String getMaSach() {
		return maSach;
	}

	public void setMaSach(String maSach) {
		this.maSach = maSach;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(int year, int month, int day) {
		ngayNhap = new Date(year - 1900, month - 1, day);	
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
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
    
	public static void getTieuDe() {
		System.out.println(String.format("|%-10s|%-15s|%-15s|%-10s|%-20s|", "Mã sách", "Ngày nhập", "Đơn giá",
				"Số lượng", "Nhà xuất bản"));
	}
    @Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00VND");
		String dongiaString = df.format(donGia);
		String str1 = simpleDateFormat.format(ngayNhap);
		return String.format("|%-10s|%-15s|%-15s|%-10d|%-20s|", maSach, str1, dongiaString, soLuong, nhaXuatBan);
	}
}
