package OnThi.PhongHoc;

public class PhongLyThuyet extends PhongHoc {
	private boolean coMayChieu;

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int soBongDen, boolean coMayChieu) {
		super(maPhong, dayNha, dienTich, soBongDen);
		this.coMayChieu = coMayChieu;
	}

	@Override
	public boolean datChuan() {
		return duAnhSang() && coMayChieu;
	}

	@Override
	public String toString() {
		return "PhongLyThuyet [coMayChieu=" + coMayChieu + ", " + super.toString() + "]";
	}
}
