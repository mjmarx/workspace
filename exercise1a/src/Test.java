import java.util.Scanner;


public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a pair of integers and I'll add them!");
		
		int val = input.nextInt();
		int sum = val + input.nextInt();
		
		System.out.println("The sum is " + sum + ".");
		
		input.close();
	}

}
