package OnThi.SinhVien;

public class SinhVien {
    private int maSinhVien;
    private String hoTen;
    private String diaChi;
    private int soDienThoai; // Số điện thoại gồm 7 chữ số

    // Constructor mặc định
    public SinhVien() {
    }

    // Constructor có tham số
    public SinhVien(int maSinhVien, String hoTen, String diaChi, int soDienThoai) {
        this.maSinhVien = maSinhVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    // Getter và Setter cho từng thuộc tính
    public int getMaSinhVien() {
        return maSinhVien;
    }

    public void setMaSinhVien(int maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    // Phương thức trả về tên (tên là phần cuối cùng của họ và tên)
    public String getFirstName() {
        String[] parts = hoTen.split(" ");
        return parts[parts.length - 1]; // Trả về phần cuối cùng của chuỗi họ và tên
    }

    // Override phương thức toString
    @Override
    public String toString() {
        return "SinhVien{" +
                "maSinhVien=" + maSinhVien +
                ", hoTen='" + hoTen + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", soDienThoai=" + soDienThoai +
                '}';
    }
}

