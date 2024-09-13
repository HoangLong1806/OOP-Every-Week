package tuan4.bai2_Sach_Md3;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
	private ArrayList<Sach> danhSachSach;

    public QuanLySach() {
        danhSachSach = new ArrayList<>();
    }

    public void nhapDanhSachSach(Scanner scanner) {
        try {
            System.out.print("Nhập số lượng sách: ");
            int soLuongSach = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < soLuongSach; i++) {
                System.out.println("Nhập thông tin sách thứ " + (i + 1));
                System.out.print("Sách giáo khoa (1) hay sách tham khảo (2): ");
                int loaiSach = Integer.parseInt(scanner.nextLine());

                Sach sach;
                if (loaiSach == 1) {
                    sach = new SachGiaoKhoa();
                } else {
                    sach = new SachThamKhao();
                }
                sach.nhapSach(scanner);
                danhSachSach.add(sach);
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi nhập danh sách sách: " + e.getMessage());
        }
    }

    public void xuatDanhSachSach() {
        try {
            for (Sach sach : danhSachSach) {
//            	sach.getTieuDe();
            	System.out.println(sach.toString());
                sach.xuatSach();
                System.out.println("Thành tiền: " + sach.thanhTien());
                System.out.println("--------------------");
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất danh sách sách: " + e.getMessage());
        }
    }

    public double tongThanhTienSachGiaoKhoa() {
        try {
            double tong = 0;
            for (Sach sach : danhSachSach) {
                if (sach instanceof SachGiaoKhoa) {
                    tong += sach.thanhTien();
                }
            }
            return tong;
        } catch (Exception e) {
            System.out.println("Lỗi khi tính tổng thành tiền sách giáo khoa: " + e.getMessage());
            return 0;
        }
    }

    public double trungBinhDonGiaSachThamKhao() {
        try {
            double tongDonGia = 0;
            int soLuongSachThamKhao = 0;
            for (Sach sach : danhSachSach) {
                if (sach instanceof SachThamKhao) {
                    tongDonGia += sach.donGia;
                    soLuongSachThamKhao++;
                }
            }
            return soLuongSachThamKhao > 0 ? tongDonGia / soLuongSachThamKhao : 0;
        } catch (Exception e) {
            System.out.println("Lỗi khi tính trung bình đơn giá sách tham khảo: " + e.getMessage());
            return 0;
        }
    }

    public void xuatSachGiaoKhoaNhaXuatBan(String nhaXuatBan) {
        try {
            for (Sach sach : danhSachSach) {
                if (sach instanceof SachGiaoKhoa && sach.nhaXuatBan.equalsIgnoreCase(nhaXuatBan)) {
                    sach.xuatSach();
                    System.out.println("--------------------");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi khi xuất sách giáo khoa của nhà xuất bản " + nhaXuatBan + ": " + e.getMessage());
        }
    }

	public void themSach(Sach sach1) {
		// TODO Auto-generated method stub
		if (sach1 != null) {
			danhSachSach.add(sach1);
		}
		
	}
}