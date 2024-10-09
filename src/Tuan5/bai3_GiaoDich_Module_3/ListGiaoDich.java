package Tuan5.bai3_GiaoDich_Module_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListGiaoDich implements GiaoDichIpl {
	private ArrayList<GiaoDich> listGiaoDich;

	public ListGiaoDich() {
		listGiaoDich = new ArrayList<GiaoDich>();
	}

	@Override
	public void addGiaoDich(GiaoDich gd) throws Exception {
		if (!listGiaoDich.contains(gd))// hiểu dc nhờ hascode equa của lớp sach
			listGiaoDich.add(gd);
		else {
			throw new Exception("Mã Giao Dich đã trùng");
		}
	}

	@Override
	public GiaoDich timKiem(String maGiaoDich) {
		for (GiaoDich gd : listGiaoDich) {
			if (gd.getMaGiaoDich().equalsIgnoreCase(maGiaoDich))
				return gd;
		}
		return null;
	}

	@Override
	public void xoa(GiaoDich gd) {
		listGiaoDich.remove(gd);
	}

	@Override
	public ArrayList<GiaoDich> getListGiaoDichVang() {
		ArrayList<GiaoDich> DSGiaoDichVang = new ArrayList<GiaoDich>();
		for (GiaoDich gd : listGiaoDich)
			if (gd instanceof GiaoDich_Vang)
				DSGiaoDichVang.add((GiaoDich_Vang) gd);

		return DSGiaoDichVang;
	}

	public ArrayList<GiaoDich> getListGiaoDichTienTe() {
		ArrayList<GiaoDich> DSGiaoDichTienTe = new ArrayList<GiaoDich>();
		for (GiaoDich gd : listGiaoDich)
			if (gd instanceof GiaoDich_Tien)
				DSGiaoDichTienTe.add((GiaoDich_Tien) gd);

		return DSGiaoDichTienTe;
	}

	public ArrayList<GiaoDich> getListGiaoDich() {
		return listGiaoDich;
	}

	@Override
	public void sortTheoSoLuong() {
		Collections.sort(listGiaoDich, new Comparator<GiaoDich>() {
			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				return Integer.compare(o1.getSoLuong(), o2.getSoLuong());
			}
		});
		System.out.println("Đã sắp xếp theo số lượng.");
	}

}
