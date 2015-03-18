package exercise3a;

import java.util.Scanner;

public class basic {
		
		public static void main(String[] args){
			
			Scanner input = new Scanner(System.in);
			String a, b;
		
			System.out.println("Please enter the first string!");
			a = input.next();
			
			System.out.println("Please enter the second string!");
			b = input.next();
			
			
			swap(a,b);
			
			System.out.println("A is now: " + a + " and B is now: " + b);
			
			input.close();
		}
		
		public static void swap(String a, String b){
			String temp = a;
			a=b;
			b=temp;
		}

}

