package test;

import java.util.Scanner;

public class Handling {
	static int getVal (int val, int[] arr){
    	if ((val<0) || (val>9))
    		throw new NullPointerException("Out of bounds");
    	return arr[val];
    }
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] array = {11,33,55,77,99,22,44,66,88,10};
		
	
    
		//Prompt the user to enter an array spot [0-9].
		System.out.print("Enter a spot in the array and I will return the value[0-9]: ");
		int index = input.nextInt();
		
		try {
			int result = getVal(index, array);
			System.out.println("Your value at index " + index + " is " + result + "!");
		}
		catch (NullPointerException b) {
			System.out.println("Bad index!");
		}
	}

	private static int getVal(int index) {
		// TODO Auto-generated method stub
		return 0;
	}
}
