package Tuan5.bai3_GiaoDich_Module_3;

import java.util.ArrayList;

public interface GiaoDichIpl {
	public void addGiaoDich(GiaoDich gd) throws Exception;
	public GiaoDich timKiem(String maGiaoDich);
	public void xoa(GiaoDich gd);
	public void sortTheoSoLuong();
	public ArrayList<GiaoDich> getListGiaoDichVang();
}
