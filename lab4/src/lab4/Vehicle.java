package lab4;

public abstract class Vehicle {

	private String color, name;
	private int year;
	
	protected Vehicle(String color, String name, int year){
		this.color = color;
		this.name = name;
		this.year = year;
	}
	
	abstract void printColor();
	abstract void printAll();
	
	public String getColor(){
		return color;
	}
	
	public String getName(){
		return name;
	}
	
	public int getYear(){
		return year;
	}
}
