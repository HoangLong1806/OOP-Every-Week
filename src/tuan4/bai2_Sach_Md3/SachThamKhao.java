package tuan4.bai2_Sach_Md3;

import java.time.LocalDate;

public class SachThamKhao extends Sach {
    private double thue;

    // Default constructor
    public SachThamKhao() {
        super();
    }

    // Parameterized constructor
    public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    // Method to calculate total price including tax
    @Override
    public double thanhTien() {
        return soLuong * donGia + thue;  // Total price is quantity * price + tax
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    // toString method for formatted output
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------------------------------------------------------\n");
        sb.append("| Mã sách      | Ngày nhập   | Đơn giá  | Số lượng | Nhà xuất bản  | Thuế      | Thành tiền  |\n");
        sb.append("|--------------|-------------|----------|----------|---------------|-----------|-------------|\n");

        sb.append(String.format(
            "| %-12s | %-11s | %-8.2f | %-8d | %-13s | %-9.2f | %-11.2f |\n",
            maSach,
            ngayNhap.toString(),  // Using LocalDate's toString() method for date formatting
            donGia,
            soLuong,
            nhaXuatBan,
            thue,
            thanhTien()  // Calls the thanhTien method to calculate the total price
        ));

        return sb.toString();
    }
}
