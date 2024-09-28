package Tuan5.bai3_GiaoDich_Module_3;

import java.time.LocalDate;

public class GiaoDich_Tien extends GiaoDich {
	public String loaiTien;
	public double tiGia;
	
	
	public GiaoDich_Tien(String string, LocalDate localDate, double d, int i, String string2, String string3) {
		super();
		this.loaiGiaoDich = "Tiền Tệ";
	}
	
	

	public GiaoDich_Tien(String maGiaoDich, LocalDate ngayGiaoDich, double donGia, int soLuong, String loaiGiaoDich,
			String loaiTien, double tiGia) {
		super(maGiaoDich, ngayGiaoDich, donGia, soLuong, "Tiền tệ" );
		this.loaiTien = loaiTien;
		this.tiGia = tiGia;
	}



	public String getLoaiTien() {
		return loaiTien;
	}



	public void setLoaiTien(String loaiTien) {
		this.loaiTien = loaiTien;
	}



	public double getTiGia() {
		return tiGia;
	}



	public void setTiGia(double tiGia) {
		this.tiGia = tiGia;
	}



	@Override
	double thanhTien() {
		try {
			if (loaiTien.equals("USD" ) || loaiTien.equals("EURO")) {
				return soLuong * donGia * tiGia;
			}else {
                return soLuong * donGia;
			}
		} catch (Exception e) {
			System.out.println("Lỗi khi tính thành tiền giao dịch tiền tệ: " + e.getMessage());
			return 0;
		}
	}



	@Override
	public String toString() {
	    return String.format(
	        "%s|%-15s|%-20.2f", // Điều chỉnh kích thước cột nếu cần thiết
	        super.toString(), 
	        loaiTien,           // Loại tiền
	        thanhTien()         // Thành tiền
	    );
	}

	
	
	
}
