package assignment1;

import java.util.Scanner;

public class calculator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Which temperature scale would you like to have converted (F or C)?");
		
		String type = input.next();
		if (type.equalsIgnoreCase("c")){
			System.out.println("Please enter degrees in Celcius: ");
			double degrees = input.nextDouble();
			degrees = (degrees*(9.0/5.0)) + 32;
			System.out.println("The corresponding temperature is " + degrees + " degrees Fahrenheit");
			
		}
		else{
			System.out.println("Please enter degrees in Fahrenheit: ");
			double degrees = input.nextDouble();
			degrees = (degrees - 32)/(9.0/5.0);
			System.out.println("The corresponding temperature is " + degrees + " degrees Celsius");
		}
	
		
		input.close();
	}
	

}
