package OnThi.PhongHoc;

public class PhongMayTinh extends PhongHoc {
    private int soMayTinh;

    public PhongMayTinh(String maPhong, String dayNha, double dienTich, int soBongDen, int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    @Override
    public boolean datChuan() {
        return duAnhSang() && (getDienTich() / soMayTinh >= 1.5);
    }

    public void capNhatSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    @Override
    public String toString() {
        return "PhongMayTinh [soMayTinh=" + soMayTinh + ", " + super.toString() + "]";
    }
}
