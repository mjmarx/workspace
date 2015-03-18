package assignment2;

import java.util.Scanner;



public class Rectangulator {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter x and y coordinates");
		
		double x = Math.abs(input.nextDouble());
		double y = Math.abs(input.nextDouble());

		if (x==10 || y == 7.5)
			System.out.println("The point (" + x + ", " + y + ") is on the border of the rectangle");
		else if (x<10 && y < 7.5)
			System.out.println("The point (" + x + ", " + y + ") is in the rectangle");
		else System.out.println("The point (" + x + ", " + y + ") is outside the rectangle");
		
		input.close();
	}
	

}