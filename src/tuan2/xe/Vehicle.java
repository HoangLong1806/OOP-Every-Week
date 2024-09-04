package tuan2.xe;


public class Vehicle {
 // Thuộc tính của lớp
 private String owner; // Tên của chủ sở hữu phương tiện
 private double value; // Giá trị của phương tiện
 private int engineCapacity; // Dung tích động cơ (theo đơn vị cc)

 // Constructor để khởi tạo đối tượng Vehicle
 public Vehicle(String owner, double value, int engineCapacity) {
     this.owner = owner; // Gán tên chủ sở hữu
     this.value = value; // Gán giá trị phương tiện
     this.engineCapacity = engineCapacity; // Gán dung tích động cơ
 }

 // Phương thức truy xuất tên chủ sở hữu
 public String getOwner() {
     return owner; // Trả về tên chủ sở hữu
 }

 // Phương thức cập nhật tên chủ sở hữu
 public void setOwner(String owner) {
     this.owner = owner; // Cập nhật tên chủ sở hữu
 }

 // Phương thức truy xuất giá trị phương tiện
 public double getValue() {
     return value; // Trả về giá trị phương tiện
 }

 // Phương thức cập nhật giá trị phương tiện
 public void setValue(double value) {
     this.value = value; // Cập nhật giá trị phương tiện
 }

 // Phương thức truy xuất dung tích động cơ
 public int getEngineCapacity() {
     return engineCapacity; // Trả về dung tích động cơ
 }

 // Phương thức cập nhật dung tích động cơ
 public void setEngineCapacity(int engineCapacity) {
     this.engineCapacity = engineCapacity; // Cập nhật dung tích động cơ
 }

 // Phương thức tính toán thuế
 public double calculateTax() {
     // Nếu dung tích động cơ nhỏ hơn 100 cc
     if (engineCapacity < 100) {
         return value * 0.01; // Thuế là 1% giá trị phương tiện
     // Nếu dung tích động cơ từ 100 cc đến 200 cc
     } else if (engineCapacity <= 200) {
         return value * 0.03; // Thuế là 3% giá trị phương tiện
     // Nếu dung tích động cơ lớn hơn 200 cc
     } else {
         return value * 0.05; // Thuế là 5% giá trị phương tiện
     }
 }

 // Phương thức chuyển đổi đối tượng thành chuỗi
 @Override
 public String toString() {
     // Trả về thông tin của phương tiện dưới dạng chuỗi
     return String.format("Chủ sở hữu: %s\nTrị giá xe: %.2f\nDung tích xy lanh: %d cc\nThuế trước bạ: %.2f",
             owner, // Tên chủ sở hữu
             value, // Giá trị phương tiện
             engineCapacity, // Dung tích động cơ
             calculateTax()); // Thuế trước bạ được tính bằng phương thức calculateTax
 }
}
