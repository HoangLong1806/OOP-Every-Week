package tuan2_account;



public class Account {
	private long stk;
	private String name;
	private double balance;
	private static final double RATE = 0.035;
	public Account(long stk, String name, double balance) {
		super();
		this.stk = stk;
		this.name = name;
		this.balance = balance;
	}

	public Account(long stk, String name) {
		super();
		this.stk = stk;
		this.name = name;
		this.balance = 50000;
	}
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getStk() {
		return stk;
	}
	public void setStk(long stk) {
		this.stk = stk;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%-20d %-30s %-20.2f", getStk(), getName(), getBalance());
	}
	public void deposit(double amount) throws Exception {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new Exception ("Số tiền gửi không hợp lệ. Vui lòng thử lại.");
        }
    }

	public void withdraw(double amount, double withdrawalFee) throws Exception{
        if (amount > 0) {
            if (amount + withdrawalFee <= balance) {
                balance -= (amount + withdrawalFee);
            } else {
                throw new Exception("Số dư không đủ. Vui lòng thử lại.");
            }
        } else {
            throw new Exception("Số tiền rút không hợp lệ. Vui lòng thử lại.");
        }
    }
	public void maturity() {
		this.balance += this.balance*RATE;
	}
	public void transfer(Account destinationAccount, double amount) throws Exception {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                destinationAccount.deposit(amount);
            } else {
                throw new Exception("Số dư không đủ. Vui lòng thử lại.");
            }
        } else {
        	throw new Exception("Số chuyển không hợp lệ. Vui lòng thử lại.");
        }
    }
}
