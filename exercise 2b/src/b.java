import java.util.Scanner;


public class b {

	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		int n;
		double sum = 0;
	
		System.out.println("How many values will be entered?");
		n = input.nextInt();
		System.out.println("Enter values separated by a space");
		
		for(int i =0; i<n; i++){
			sum+=input.nextDouble();
		}
		
		
		System.out.println("The average of the numbers is: " + (sum/n));
		
		input.close();
	}
	
}
