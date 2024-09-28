package tuan4.bai2_Sach_Md3;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Sach implements Comparable<Sach> {  // Thêm từ khóa abstract
    protected String maSach;
    protected LocalDate ngayNhap;
    protected double donGia;
    protected int soLuong;
    protected String nhaXuatBan;
    abstract double thanhTien();  // Phương thức abstract

    public Sach() {
    }

    public Sach(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(int year, int month, int day) {
        this.ngayNhap = LocalDate.of(year, month, day);
    }

    @Override
    public int compareTo(Sach other) {
        return this.maSach.compareTo(other.maSach);
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
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

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

   

    @Override
	public int hashCode() {
		return Objects.hash(maSach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(maSach, other.maSach);
	}

	@Override
    public String toString() {
        return String.format("|%-10s|%-15s|%-15.2f|%-10d|%-20s|", maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
    }
}
