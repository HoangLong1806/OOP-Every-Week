package OnThi.SinhVien;

import java.util.Comparator;
import java.util.Scanner;

public class QuanLySinhVien {
	private SinhVien[] danhSachSinhVien;
	private int soLuongSinhVien;

	public QuanLySinhVien() {
		danhSachSinhVien = new SinhVien[soLuongSinhVien];
		soLuongSinhVien = 0;
	}

	// Thêm sinh viên
	public boolean themSinhVien(SinhVien sv) {
		if (soLuongSinhVien < danhSachSinhVien.length) {
			danhSachSinhVien[soLuongSinhVien] = sv;
			soLuongSinhVien++;
			return true;
		}
		return false;
	}

	// Sửa thông tin sinh viên theo mã sinh viên
	public boolean suaSinhVien(int maSinhVien, String hoTenMoi, String diaChiMoi, int soDienThoaiMoi) {
		for (int i = 0; i < soLuongSinhVien; i++) {
			if (danhSachSinhVien[i].getMaSinhVien() == maSinhVien) {
				danhSachSinhVien[i].setHoTen(hoTenMoi);
				danhSachSinhVien[i].setDiaChi(diaChiMoi);
				danhSachSinhVien[i].setSoDienThoai(soDienThoaiMoi);
				return true;
			}
		}
		return false;
	}

	// Xóa sinh viên theo mã sinh viên
	public boolean xoaSinhVien(int maSinhVien) {
		for (int i = 0; i < soLuongSinhVien; i++) {
			if (danhSachSinhVien[i].getMaSinhVien() == maSinhVien) {
				for (int j = i; j < soLuongSinhVien - 1; j++) {
					danhSachSinhVien[j] = danhSachSinhVien[j + 1];
				}
				danhSachSinhVien[soLuongSinhVien - 1] = null; // Xóa phần tử cuối
				soLuongSinhVien--;
				return true;
			}
		}
		return false;
	}

	class SortByFirstName implements Comparator<SinhVien> {
		@Override
		public int compare(SinhVien a, SinhVien b) {
			// TODO Auto-generated method stub
			return a.getFirstName().compareTo(b.getFirstName());
		}
	}

	// Trả về danh sách sinh viên
	public SinhVien[] getDanhSachSinhVien() {
		return danhSachSinhVien;
	}

	// Trả về số lượng sinh viên hiện tại
	public int getSoLuongSinhVien() {
		return soLuongSinhVien;
	}

	// Nhập sinh viên
	public boolean nhapSinhVien(SinhVien sv) {
		return themSinhVien(sv);
	}
}
