package exercise4a;

public class Adder {

	int addThemAll(int[][] array){
		int sum = 0;
		int x = array.length;
		int y = array[0].length; //i'm assuming this 2d array is rectangular
		
		for (int i=0;i<x;i++){
			for (int j=0; j<y;j++){
				sum+=array[i][j];
			}
		}
		
		
		return sum;
	}
	
	
}
