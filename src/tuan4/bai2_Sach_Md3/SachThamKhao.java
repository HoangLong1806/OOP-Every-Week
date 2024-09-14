package tuan4.bai2_Sach_Md3;

import java.util.Date;
import java.util.Scanner;

public class SachThamKhao extends Sach {
    private double thue;

    public SachThamKhao() {
        super();
    }

    public SachThamKhao(String maSach, Date ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    @Override
    public void nhapSach(Scanner scanner) {
        try {
            super.nhapSach(scanner);
            System.out.print("Nhập thuế: ");
            thue = Double.parseDouble(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập thuế: " + e.getMessage());
        }
    }

    @Override
    public void xuatSach() {
        try {
            super.xuatSach();
            System.out.println("Thuế: " + thue);
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất thông tin thuế: " + e.getMessage());
        }
    }

    @Override
    public double thanhTien() {
        try {
            return soLuong * donGia + thue;
        } catch (Exception e) {
            System.out.println("Lỗi khi tính thành tiền sách tham khảo: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("| Mã sách      | Ngày nhập   | Đơn giá  | Số lượng | Nhà xuất bản  | Thuế      | Thành tiền  |\n");
        sb.append("|--------------|-------------|----------|----------|---------------|-----------|-------------|\n");
        
        sb.append(String.format(
            "| %-12s | %-11s | %-8.2f | %-8d | %-13s | %-9.2f | %-11.2f |\n", 
            maSach, 
            new java.text.SimpleDateFormat("dd/MM/yyyy").format(ngayNhap), 
            donGia, 
            soLuong, 
            nhaXuatBan, 
            thue, 
            thanhTien()  // Tính thành tiền trực tiếp từ phương thức thanhTien()
        ));
        return sb.toString();
    }


    
}
