package tuan2_Xe;

public class Vehicle {
    private String owner;
    private double value;
    private int engineCapacity;

    public Vehicle(String owner, double value, int engineCapacity) {
        this.owner = owner;
        this.value = value;
        this.engineCapacity = engineCapacity;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public double calculateTax() {
        if (engineCapacity < 100) {
            return value * 0.01;
        } else if (engineCapacity <= 200) {
            return value * 0.03;
        } else {
            return value * 0.05;
        }
    }

    @Override
    public String toString() {
        return String.format("Chủ sở hữu: %s\nTrị giá xe: %.2f\nDung tích xy lanh: %d cc\nThuế trước bạ: %.2f",
                owner, value, engineCapacity, calculateTax());
    }
}

