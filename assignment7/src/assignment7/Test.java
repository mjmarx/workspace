package assignment7;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the first complex number: ");
		double c1Real = input.nextDouble();
		double c1Imag = input.nextDouble();
		Complex c1 = new Complex(c1Real, c1Imag);

		System.out.print("Enter the second complex number: ");
		double c2Real = input.nextDouble();
		double c2Imag = input.nextDouble();
		Complex c2 = new Complex(c2Real, c2Imag);

		System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
		System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
		System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
	}
  
}
