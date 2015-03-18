package assignment8;

public class Professor extends Instructor {
	
	Boolean tenure;

	public Professor(String name, int age, int ID, String specialty, Boolean tenure) {
		super(name, age, ID, specialty);
		this.tenure = tenure;
	}
	
	void print(){
		super.print();
		System.out.println("Tenured?: " + tenure);
	}

}
