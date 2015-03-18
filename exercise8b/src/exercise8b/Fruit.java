package exercise8b;

public abstract class Fruit {

	double weight;
	String color;
	int calories;
	
	public Fruit(){}
	
	//this must be implemented in Apple
	abstract int getCalories();
	abstract void setCalories(int cals);
	
}
