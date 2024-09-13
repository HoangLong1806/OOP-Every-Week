package tuan4.bai2_Sach_Md3;

import java.util.Date;
import java.util.Scanner;

public class SachGiaoKhoa extends Sach {
    private String tinhTrang; // "moi" hoặc "cu"

    public SachGiaoKhoa() {
        super();
    }

    public SachGiaoKhoa(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    @Override
    public void nhapSach(Scanner scanner) {
        try {
            super.nhapSach(scanner);
            System.out.print("Nhập tình trạng sách (moi/cu): ");
            tinhTrang = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập tình trạng sách: " + e.getMessage());
        }
    }

    @Override
    public void xuatSach() {
        try {
            super.xuatSach();
            System.out.println("Tình trạng: " + tinhTrang);
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất tình trạng sách: " + e.getMessage());
        }
    }

    @Override
    public double thanhTien() {
        try {
            if (tinhTrang.equalsIgnoreCase("moi")) {
                return soLuong * donGia;
            } else {
                return soLuong * donGia * 0.5;
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi tính thành tiền: " + e.getMessage());
            return 0;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| Mã sách      | Ngày nhập   | Đơn giá  | Số lượng | Nhà xuất bản  | Tình trạng |\n");
        sb.append("|--------------|-------------|----------|----------|---------------|------------|\n");
        
        sb.append(String.format("| %-12s | %-11s | %-8.2f | %-8d | %-13s | %-10s |\n", 
            maSach, 
            new java.text.SimpleDateFormat("dd/MM/yyyy").format(ngayNhap), 
            donGia, 
            soLuong, 
            nhaXuatBan, 
            tinhTrang
        ));
        return sb.toString();
    }

}
