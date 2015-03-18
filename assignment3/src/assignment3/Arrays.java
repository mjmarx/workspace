package assignment3;

public class Arrays {
	
	public static int[] createArray(){
		int array[] = new int[100];	
		for (int i=0;i<100;i++){
			array[i]=(int) Math.random()*100;
		}
		return array;
	}
	
	public static void statsDisplay(int[] array){
		int oddCount = 0;
		int evenCount = 0;
		int sum = 0;
		
		for (int i=0; i<100; i++){
			int temp = array[i];
			if (temp%2 == 0){
				evenCount++;
			}
			else oddCount++;
			
			sum+=temp;
		}
		
		System.out.println("The total number of odd integers is: " + oddCount);
		System.out.println("The total number of even integers is " + evenCount);
		System.out.println("The average of all the numbers is: " + (sum/100.00));
		
	}
	

}
