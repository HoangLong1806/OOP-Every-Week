package tuan2_account;

import java.util.ArrayList; // Nhập khẩu lớp ArrayList
import java.util.List; // Nhập khẩu lớp List
import java.util.Scanner; // Nhập khẩu lớp Scanner

// Định nghĩa lớp TestAccount
public class TestAccount {

    // Phương thức main là điểm vào của chương trình
    public static void main(String[] args) {
        // Tạo đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);
        // Tạo danh sách để lưu trữ các đối tượng Account
        List<Account> accounts = new ArrayList<>();

        // Vòng lặp vô hạn để thực hiện các thao tác quản lý tài khoản
        while (true) {
            // Hiển thị menu cho người dùng
            System.out.println("\n--- Quản lý tài khoản ngân hàng ---");
            System.out.println("1. Xem danh sách tài khoản");
            System.out.println("2. Thêm tài khoản");
            System.out.println("3. Xóa tài khoản");
            System.out.println("4. Sửa thông tin tài khoản");
            System.out.println("5. Tính lãi suất cho tài khoản");
            System.out.println("6. Thoát");
            System.out.print("Chọn thao tác: ");
            
            // Đọc lựa chọn của người dùng từ bàn phím
            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm để chuẩn bị cho việc đọc chuỗi tiếp theo

            // Xử lý lựa chọn của người dùng
            switch (choice) {
                case 1:
                    // Hiển thị danh sách tài khoản
                    System.out.println("\nDanh sách tài khoản:");
                    if (accounts.isEmpty()) {
                        // Nếu danh sách tài khoản rỗng, thông báo không có tài khoản nào
                        System.out.println("Không có tài khoản nào.");
                        System.out.println("---------------------------------------------------");
                    } else {
                        // In thông tin tất cả các tài khoản trong danh sách
                        for (Account acc : accounts) {
                            System.out.println(acc);
                        }
                    }
                    break;

                case 2:
                    // Thêm tài khoản mới
                    System.out.print("Nhập số tài khoản: ");
                    long stk = scanner.nextLong();
                    scanner.nextLine(); // Xóa bộ đệm
                    System.out.print("Nhập tên tài khoản: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập số dư ban đầu: ");
                    double balance = scanner.nextDouble();

                    // Tạo đối tượng Account mới và thêm vào danh sách
                    Account newAccount = new Account(stk, name, balance);
                    accounts.add(newAccount);
                    System.out.println("Thêm tài khoản thành công.");
                    System.out.println("---------------------------------------------------");
                    break;

                case 3:
                    // Xóa tài khoản
                    System.out.print("Nhập số tài khoản cần xóa: ");
                    long stkToDelete = scanner.nextLong();
                    boolean found = false;

                    // Duyệt qua danh sách tài khoản để tìm tài khoản cần xóa
                    for (Account acc : accounts) {
                        if (acc.getStk() == stkToDelete) {
                            accounts.remove(acc); // Xóa tài khoản khỏi danh sách
                            found = true;
                            System.out.println("Xóa tài khoản thành công.");
                            System.out.println("---------------------------------------------------");
                            break;
                        }
                    }
                    // Nếu không tìm thấy tài khoản cần xóa
                    if (!found) {
                        System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
                        System.out.println("---------------------------------------------------");
                    }
                    break;

                case 4:
                    // Sửa thông tin tài khoản
                    System.out.print("Nhập số tài khoản cần sửa: ");
                    long stkToEdit = scanner.nextLong();
                    scanner.nextLine(); // Xóa bộ đệm
                    Account accountToEdit = null;

                    // Duyệt qua danh sách tài khoản để tìm tài khoản cần sửa
                    for (Account acc : accounts) {
                        if (acc.getStk() == stkToEdit) {
                            accountToEdit = acc;
                            break;
                        }
                    }

                    // Nếu tìm thấy tài khoản cần sửa
                    if (accountToEdit != null) {
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nhập số dư mới: ");
                        double newBalance = scanner.nextDouble();

                        // Cập nhật thông tin tài khoản
                        accountToEdit.setName(newName);
                        accountToEdit.setBalance(newBalance);
                        System.out.println("Sửa thông tin tài khoản thành công.");
                        System.out.println("---------------------------------------------------");
                    } else {
                        // Nếu không tìm thấy tài khoản cần sửa
                        System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
                        System.out.println("---------------------------------------------------");
                    }
                    break;

                case 5:
                    // Tính lãi suất cho tài khoản
                    System.out.print("Nhập số tài khoản cần đáo hạn: ");
                    long stkToMaturity = scanner.nextLong();
                    boolean foundMaturity = false;

                    // Duyệt qua danh sách tài khoản để tìm tài khoản cần tính lãi suất
                    for (Account acc : accounts) {
                        if (acc.getStk() == stkToMaturity) {
                            acc.maturity(); // Tính lãi suất cho tài khoản
                            foundMaturity = true;
                            System.out.println("Đáo hạn suất thành công.");
                            System.out.println("---------------------------------------------------");
                            break;
                        }
                    }
                    // Nếu không tìm thấy tài khoản cần tính lãi suất
                    if (!foundMaturity) {
                        System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
                        System.out.println("---------------------------------------------------");
                    }
                    break;

                case 6:
                    // Thoát chương trình
                    System.out.println("Thoát chương trình.");
                    System.out.println("---------------------------------------------------");
                    scanner.close(); // Đóng đối tượng Scanner để giải phóng tài nguyên
                    System.exit(0); // Kết thúc chương trình

                default:
                    // Xử lý trường hợp lựa chọn không hợp lệ
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    System.out.println("---------------------------------------------------");
            }
        }
    }
}
