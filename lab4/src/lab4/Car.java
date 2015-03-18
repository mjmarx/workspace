package lab4;

public class Car extends Vehicle {

	int maxMPH;
	String intColor;
	
	public Car(String color, int year, String name, String intColor, int maxMPH){
		super(color, name, year);
		this.intColor = intColor;
		this.maxMPH = maxMPH;
	}
	
	void printColor(){
		System.out.println("Interior color: " + this.intColor + "\nExterior color: " + super.getColor());
	}
	
	void printAll(){
		System.out.println("Max MPH: " + maxMPH);
		System.out.println("Year of manufacture: " + super.getYear());
		System.out.println("Model: " + super.getName()); 
	}
	
	public static void main(String[] args){
		Car myCar = new Car("Black", 1997, "Altima", "Gray" , 80);
		myCar.printColor();
		myCar.printAll();
	}
}
