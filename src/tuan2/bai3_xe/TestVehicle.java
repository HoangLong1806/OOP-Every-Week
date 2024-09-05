package tuan2.bai3_xe;

import java.util.Scanner;


public class TestVehicle {

 public static void main(String[] args) {
     // Khởi tạo đối tượng Scanner để đọc dữ liệu từ bàn phím
     Scanner scanner = new Scanner(System.in);

     // Khai báo và khởi tạo ba biến đối tượng Vehicle
     Vehicle xe1 = null, xe2 = null, xe3 = null;
     
     // Vòng lặp vô hạn để chương trình luôn chạy cho đến khi người dùng chọn thoát
     while (true) {
         // Hiển thị menu cho người dùng
         System.out.println("\n--- Quản lý đăng ký xe ---");
         System.out.println("1. Nhập thông tin và tạo các đối tượng xe1, xe2, xe3");
         System.out.println("2. Xuất bảng kê khai tiền thuế trước bạ của các xe");
         System.out.println("3. Thoát");
         System.out.print("Chọn thao tác: ");
         
         // Đọc lựa chọn của người dùng từ bàn phím
         int choice = scanner.nextInt();
         scanner.nextLine(); // Xóa bộ đệm sau khi đọc số nguyên

         // Xử lý lựa chọn của người dùng
         switch (choice) {
             // Lựa chọn 1: Nhập thông tin và tạo các đối tượng xe
             case 1:
                 // Nhập thông tin cho xe1
                 System.out.print("Nhập tên chủ xe1: ");
                 String owner1 = scanner.nextLine();
                 System.out.print("Nhập trị giá xe1: ");
                 double value1 = scanner.nextDouble();
                 System.out.print("Nhập dung tích xy lanh xe1: ");
                 int engineCapacity1 = scanner.nextInt();
                 // Tạo đối tượng xe1 với thông tin đã nhập
                 xe1 = new Vehicle(owner1, value1, engineCapacity1);

                 // Xóa bộ đệm sau khi đọc số nguyên
                 scanner.nextLine();
                 // Nhập thông tin cho xe2
                 System.out.print("Nhập tên chủ xe2: ");
                 String owner2 = scanner.nextLine();
                 System.out.print("Nhập trị giá xe2: ");
                 double value2 = scanner.nextDouble();
                 System.out.print("Nhập dung tích xy lanh xe2: ");
                 int engineCapacity2 = scanner.nextInt();
                 // Tạo đối tượng xe2 với thông tin đã nhập
                 xe2 = new Vehicle(owner2, value2, engineCapacity2);

                 // Xóa bộ đệm sau khi đọc số nguyên
                 scanner.nextLine();
                 // Nhập thông tin cho xe3
                 System.out.print("Nhập tên chủ xe3: ");
                 String owner3 = scanner.nextLine();
                 System.out.print("Nhập trị giá xe3: ");
                 double value3 = scanner.nextDouble();
                 System.out.print("Nhập dung tích xy lanh xe3(cc): ");
                 int engineCapacity3 = scanner.nextInt();
                 // Tạo đối tượng xe3 với thông tin đã nhập
                 xe3 = new Vehicle(owner3, value3, engineCapacity3);

                 // Thông báo đã tạo xong các đối tượng xe
                 System.out.println("Đã tạo xong các đối tượng xe.");
                 break;

             // Lựa chọn 2: Xuất bảng kê khai tiền thuế trước bạ của các xe
             case 2:
                 System.out.println("\n--- Bảng kê khai tiền thuế trước bạ ---");
                 // Hiển thị thông tin của các xe nếu chúng đã được tạo
                 if (xe1 != null) System.out.println(xe1);
                 if (xe2 != null) System.out.println(xe2);
                 if (xe3 != null) System.out.println(xe3);
                 break;

             // Lựa chọn 3: Thoát chương trình
             case 3:
                 System.out.println("Thoát chương trình.");
                 // Đóng đối tượng Scanner để giải phóng tài nguyên
                 scanner.close();
                 // Kết thúc chương trình
                 System.exit(0);

             // Xử lý trường hợp lựa chọn không hợp lệ
             default:
                 System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
         }
     }
 }
}


