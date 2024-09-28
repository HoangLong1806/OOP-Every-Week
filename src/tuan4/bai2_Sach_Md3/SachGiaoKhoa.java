package tuan4.bai2_Sach_Md3;

import java.time.LocalDate;

public class SachGiaoKhoa extends Sach {
    private boolean tinhTrang; // true = mới, false = cũ

    // Default constructor
    public SachGiaoKhoa() {
        super();
    }

    // Parameterized constructor
    public SachGiaoKhoa(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan, boolean tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;
    }

    // Method to calculate total price based on the condition of the book
    @Override
    public double thanhTien() {
        if (tinhTrang) { // true = mới
            return soLuong * donGia;  // New books are sold at full price
        } else { // false = cũ
            return soLuong * donGia * 0.5;  // Used books are sold at 50% of the price
        }
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    // toString method for formatted output
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------------------------------------------------------\n");
        sb.append("| Mã sách      | Ngày nhập   | Đơn giá  | Số lượng | Nhà xuất bản  | Tình trạng | Thành tiền  |\n");
        sb.append("|--------------|-------------|----------|----------|---------------|------------|-------------|\n");

        String trangThai = tinhTrang ? "mới" : "cũ";
        sb.append(String.format(
            "| %-12s | %-11s | %-8.2f | %-8d | %-13s | %-10s | %-11.2f |\n",
            maSach,
            ngayNhap.toString(),  // Using LocalDate's toString() method for date formatting
            donGia,
            soLuong,
            nhaXuatBan,
            trangThai,
            thanhTien()  // Calls the thanhTien method to calculate the total price
        ));

        return sb.toString();
    }
}
