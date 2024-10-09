package Tuan5.bai8_HangHoa_Module_3;

import java.util.ArrayList;

public interface HangHoaIpl {
	public void addHang(HangHoa hh) throws Exception;

	public HangHoa timKiem(String maHang);

	public boolean xoaHang(String maHang);
	public ArrayList<HangHoa> getListHangThucPham();
	public ArrayList<HangHoa> getListHangDienMay();
	public ArrayList<HangHoa> getListHangSanhSu();
	public ArrayList<HangHoa> getListHang();
	
	public void sortTheoSoLuong();
	public void sortDonGia();
	
}
