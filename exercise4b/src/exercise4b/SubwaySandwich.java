package exercise4b;

public class SubwaySandwich {
	
	int length;
	String meat;
	String cheese;
	Boolean mayo;
	String bread;
	String[] toppings = new String[5];
	
	
	public SubwaySandwich( int orderLength, String meatOrder, String cheeseOrder){
		length = orderLength;
		meat = meatOrder;
		cheese = cheeseOrder;
		bread = "Italian herbs and cheese"; //the only right choice
		mayo = true; //no choice here
		toppings[0] = "lettuce"; //or any of these
		toppings[1] = "tomatoes"; //tomatoes are bad but GO WITH IT
		toppings[2] = "green peppers";
	}
	
	void bite(){
		length--;
		System.out.println("there are " + length + " inches left of your sub");
	}
	
	void removeTomatoes(){
		for(int i = 0; i<5; i++){
			if (toppings[i].equals("tomatoes")){
				for(int j=i;j<4;j++){ //moving all the other toppings up in the list
					toppings[j] = toppings[j+1]; //no more tomatoes! :)
				}
			}
		}
	}
		
	
}



