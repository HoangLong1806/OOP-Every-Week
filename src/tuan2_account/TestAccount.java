package tuan2_account;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestAccount {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Account> accounts = new ArrayList<>();

		// Vòng lặp để thực hiện các thao tác
		while (true) {
			System.out.println("\n--- Quản lý tài khoản ngân hàng ---");
			System.out.println("1. Xem danh sách tài khoản");
			System.out.println("2. Thêm tài khoản");
			System.out.println("3. Xóa tài khoản");
			System.out.println("4. Sửa thông tin tài khoản");
			System.out.println("5. Tính lãi suất cho tài khoản");
			System.out.println("6. Thoát");
			System.out.print("Chọn thao tác: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Xóa bộ đệm

			switch (choice) {
			case 1:
				// In danh sách tài khoản
				System.out.println("\nDanh sách tài khoản:");
				if (accounts.isEmpty()) {
					System.out.println("Không có tài khoản nào.");
				} else {
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

				Account newAccount = new Account(stk, name, balance);
				accounts.add(newAccount);
				System.out.println("Thêm tài khoản thành công.");
				break;

			case 3:
				// Xóa tài khoản
				System.out.print("Nhập số tài khoản cần xóa: ");
				long stkToDelete = scanner.nextLong();
				boolean found = false;

				for (Account acc : accounts) {
					if (acc.getStk() == stkToDelete) {
						accounts.remove(acc);
						found = true;
						System.out.println("Xóa tài khoản thành công.");
						break;
					}
				}
				if (!found) {
					System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
				}
				break;

			case 4:
				// Sửa thông tin tài khoản
				System.out.print("Nhập số tài khoản cần sửa: ");
				long stkToEdit = scanner.nextLong();
				scanner.nextLine(); // Xóa bộ đệm
				Account accountToEdit = null;

				for (Account acc : accounts) {
					if (acc.getStk() == stkToEdit) {
						accountToEdit = acc;
						break;
					}
				}

				if (accountToEdit != null) {
					System.out.print("Nhập tên mới: ");
					String newName = scanner.nextLine();
					System.out.print("Nhập số dư mới: ");
					double newBalance = scanner.nextDouble();

					accountToEdit.setName(newName);
					accountToEdit.setBalance(newBalance);
					System.out.println("Sửa thông tin tài khoản thành công.");
				} else {
					System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
				}
				break;

			case 5:
				// Tính lãi suất cho tài khoản
				System.out.print("Nhập số tài khoản cần tính lãi: ");
				long stkToMaturity = scanner.nextLong();
				boolean foundMaturity = false;

				for (Account acc : accounts) {
					if (acc.getStk() == stkToMaturity) {
						acc.maturity();
						foundMaturity = true;
						System.out.println("Tính lãi suất thành công.");
						break;
					}
				}
				if (!foundMaturity) {
					System.out.println("Không tìm thấy tài khoản với số tài khoản đã nhập.");
				}
				break;

			case 6:
				// Thoát chương trình
				System.out.println("Thoát chương trình.");
				scanner.close();
				System.exit(0);

			default:
				System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
			}
		}
	}
}
