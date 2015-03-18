package assignment4;

public class StudentAccount {

	private String id, name, address;
	private double balance;
	
	public StudentAccount(){
		id = "00000000";
		balance = 0.0;
		name = "";
		address = "";
	}
	
	public StudentAccount(String newID, double newBalance, String newName, String newAddress){
		id = newID;
		balance = newBalance;
		name = newName;
		address = newAddress;
	}
	
	double getBalance(){
		return balance;
	}
	
	void setBalance(double newBalance){
		balance = newBalance;
	}
	
	void withdraw (double withdrawal){
		balance -= withdrawal;
	}

	void deposit (double deposit){
		balance+= deposit;
	}
	void clear (){
		balance = 0.0;
	}
	
}

