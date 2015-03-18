package assignment4;

public class Tester {

	public static void main(String[] args) {
	
		double balance;
	
		StudentAccount acct = new StudentAccount( "00455420", 100.50, "John Doe", "Minneapolis");
	
		balance = acct.getBalance();
	
		System.out.println("Balance is " + balance);
	
		acct.withdraw(4.5);
		balance = acct.getBalance();
		
		System.out.println("Balance is " + balance + " after withdrawal");
		
		acct.deposit(7.75);
		balance = acct.getBalance();

		System.out.println("Balance is " + balance + " after deposit");
		
		acct.clear();
		balance = acct.getBalance();
		
		System.out.println("Balance is " + balance + " after clear");
		

	}
}
