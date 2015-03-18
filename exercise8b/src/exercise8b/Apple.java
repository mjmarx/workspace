package exercise8b;

public class Apple extends Fruit {

		String breed;
		
		Apple(){}
		
		Apple(String breed, String color, double weight){
			super();
			this.breed = breed;
			super.color = color;
			super.weight = weight;
			switch (breed){
				case "granny": setCalories(200);
								break;
				case "gala": setCalories(250);
								break;
				case "fuji": setCalories(150);
								break;
				default: setCalories(225);
			}
		}
	
		int getCalories(){
			return super.calories;
		}
		
		void setCalories(int cals){
			super.calories = cals;
		}
}
