package lab6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab6 {

	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		
		System.out.println("Please enter a double value for the length of the board and an integer value for the amount of pieces to be cut");
		
		try {
			double length = s1.nextDouble();
			int pieces = s1.nextInt();
			if((pieces<0)||(length<0))
				throw new IllegalArgumentException();
			if (pieces == 0)
				throw new ArithmeticException();
			double size = length/pieces;
			System.out.println("The " + length + " foot board was cut into " + pieces + " pieces of size " + size + " each.");
		}
		catch(InputMismatchException ex){
			System.out.println("Bad Input!");
		}
		catch(ArithmeticException ex){
			System.out.println("Can not be cut into zero pieces");
		}
		catch(IllegalArgumentException ex){
			System.out.println("Values must be positive.");
		}
		finally{
			s1.close();
		}
	}


}
