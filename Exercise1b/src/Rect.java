import java.util.Scanner;

public class Rect {
	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		
		System.out.println("Enter height and width in integer values");
		
		int h = Input.nextInt();
		int w = Input.nextInt();
		
		if ( h<0 | w< 0 ){
			System.out.println("invalid input!");
		}
		else{
			System.out.println("The area is " + (h*w) +  ". ");
		}
		Input.close();
	}
}
