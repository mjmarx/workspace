package assignment8;

public class Instructor extends Person {

	int ID;
	String specialty;
	
	
	public Instructor(String name, int age, int ID, String spec) {
		super(name, age);
		this.ID = ID;
		this.specialty = spec;
	}
	
	void print(){
		super.print();
		System.out.println("Specialty: " + specialty);
	}

}
