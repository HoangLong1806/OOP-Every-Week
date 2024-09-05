package tuan2.bai4_acount;




public class Account {
 // Các thuộc tính của lớp
 private long stk; // Số tài khoản (số dài)
 private String name; // Tên của chủ tài khoản
 private double balance; // Số dư tài khoản
 private static final double RATE = 0.035; // Tỉ lệ lãi suất

 // Constructor để khởi tạo đối tượng Account với tất cả các thuộc tính
 public Account(long stk, String name, double balance) {
     super(); // Gọi constructor của lớp cha (Object) (không cần thiết nếu lớp không kế thừa lớp khác)
     this.stk = stk; // Gán số tài khoản
     this.name = name; // Gán tên chủ tài khoản
     this.balance = balance; // Gán số dư tài khoản
 }

 // Constructor để khởi tạo đối tượng Account với số tài khoản và tên, số dư mặc định là 50000
 public Account(long stk, String name) {
     super(); // Gọi constructor của lớp cha (Object)
     this.stk = stk; // Gán số tài khoản
     this.name = name; // Gán tên chủ tài khoản
     this.balance = 50000; // Gán số dư tài khoản mặc định là 50000
 }
 
 // Constructor không tham số
 public Account() {
     super(); // Gọi constructor của lớp cha (Object)
     // TODO Auto-generated constructor stub
     // Constructor này không làm gì cả, có thể để lại như vậy hoặc thêm logic khởi tạo nếu cần
 }

 // Phương thức truy xuất số tài khoản
 public long getStk() {
     return stk; // Trả về số tài khoản
 }

 // Phương thức cập nhật số tài khoản
 public void setStk(long stk) {
     this.stk = stk; // Cập nhật số tài khoản
 }

 // Phương thức truy xuất tên chủ tài khoản
 public String getName() {
     return name; // Trả về tên chủ tài khoản
 }

 // Phương thức cập nhật tên chủ tài khoản
 public void setName(String name) {
     this.name = name; // Cập nhật tên chủ tài khoản
 }

 // Phương thức truy xuất số dư tài khoản
 public double getBalance() {
     return balance; // Trả về số dư tài khoản
 }

 // Phương thức cập nhật số dư tài khoản
 public void setBalance(double balance) {
     this.balance = balance; // Cập nhật số dư tài khoản
 }

 // Phương thức chuyển đổi đối tượng Account thành chuỗi để dễ dàng hiển thị
 @Override
 public String toString() {
     // Định dạng chuỗi để hiển thị thông tin của tài khoản
     return String.format("%-20d %-30s %-20.2f", getStk(), getName(), getBalance());
 }

 // Phương thức gửi tiền vào tài khoản
 public void deposit(double amount) throws Exception {
     if (amount > 0) {
         balance += amount; // Cộng số tiền gửi vào số dư tài khoản
     } else {
         // Ném ngoại lệ nếu số tiền gửi không hợp lệ
         throw new Exception("Số tiền gửi không hợp lệ. Vui lòng thử lại.");
     }
 }

 // Phương thức rút tiền từ tài khoản, tính phí rút tiền
 public void withdraw(double amount, double withdrawalFee) throws Exception {
     if (amount > 0) {
         // Kiểm tra số dư tài khoản và phí rút tiền
         if (amount + withdrawalFee <= balance) {
             balance -= (amount + withdrawalFee); // Giảm số dư tài khoản theo số tiền và phí rút tiền
         } else {
             // Ném ngoại lệ nếu số dư không đủ
             throw new Exception("Số dư không đủ. Vui lòng thử lại.");
         }
     } else {
         // Ném ngoại lệ nếu số tiền rút không hợp lệ
         throw new Exception("Số tiền rút không hợp lệ. Vui lòng thử lại.");
     }
 }

 // Phương thức tính lãi suất cho tài khoản
 public void maturity() {
     this.balance += this.balance * RATE; // Tính lãi suất và cộng vào số dư tài khoản
 }

 // Phương thức chuyển tiền từ tài khoản này sang tài khoản khác
 public void transfer(Account destinationAccount, double amount) throws Exception {
     if (amount > 0) {
         // Kiểm tra số dư tài khoản
         if (amount <= balance) {
             balance -= amount; // Giảm số dư tài khoản
             destinationAccount.deposit(amount); // Gửi số tiền vào tài khoản đích
         } else {
             // Ném ngoại lệ nếu số dư không đủ
             throw new Exception("Số dư không đủ. Vui lòng thử lại.");
         }
     } else {
         // Ném ngoại lệ nếu số tiền chuyển không hợp lệ
         throw new Exception("Số chuyển không hợp lệ. Vui lòng thử lại.");
     }
 }
}
