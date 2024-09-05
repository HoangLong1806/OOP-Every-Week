package tuan3.bai8_cd;

public class DanhSachCD {
	private CD[] dsCD;
	private int soLuongCD;

	public DanhSachCD(int soLuongCD) {
		this.soLuongCD = soLuongCD;
		dsCD = new CD[soLuongCD];
	}

	public void themCD(CD cd) {
		if (soLuongCD == dsCD.length) {
			System.out.println("Danh sách CD đã đầy!");
			return;
		}
		dsCD[soLuongCD++] = cd;
	}

	public void xoaCD(int maCD) {
		for (int i = 0; i < soLuongCD; i++) {
			if (dsCD[i].getMaCD() == maCD) {
				for (int j = i; j < soLuongCD - 1; j++) {
					dsCD[j] = dsCD[j + 1];
				}
				dsCD[--soLuongCD] = null;
				System.out.println("Đã xóa CD có mã " + maCD);
				return;
			}
		}
		System.out.println("Không tìm thấy CD có mã " + maCD + " để xóa!");
	}

	public void hienThiDanhSachCD() {
		if (soLuongCD == 0) {
			System.out.println("Danh sách CD rỗng!");
			return;
		}
		System.out.println("Danh sách CD:");
		for (int i = 0; i < soLuongCD; i++) {
			System.out.println(dsCD[i]);
		}
	}

	public CD timCDTheoMa(int maCD) {
		for (int i = 0; i < soLuongCD; i++) {
			if (dsCD[i].getMaCD() == maCD) {
				return dsCD[i];
			}
		}
		return null;
	}

	public CD[] timCDTheoTuaCD(String tuaCD) {
        int count = 0;
        for (int i = 0; i < soLuongCD; i++) {
            if (dsCD[i].getTuaCD().equalsIgnoreCase(tuaCD)) {
                count++;
            }
        }
        if (count == 0) {
            return null;
        }
        return timCDsTheoTuaCD(tuaCD, count);
}
	}
