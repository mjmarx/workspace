import java.util.Scanner;


public class Average {
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int count = 1;
		double sum = 0;
		double next;
	
		System.out.println("Please enter the first number!");
		next = input.nextDouble();
		sum += next;
		
		while(next != -1){
			System.out.println("please enter the next number");
			next = input.nextDouble();
			if (next != -1){
				sum += next;
				count++;
			}
		}
		
		System.out.println("Sentinel value received! The average of the numbers is: " + (sum/count));
		
		input.close();
	}

}
