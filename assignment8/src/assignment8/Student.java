package assignment8;

public class Student extends Person {

	protected int ID;
	protected String major;
	protected double GPA;
	
	public Student(String name, int age, int ID, String major, double GPA) {
		super(name, age);
		this.ID = ID;
		this.major = major;
		this.GPA = GPA;
	}
	
	void print(){
		super.print();
		System.out.println("ID: " + ID);
		System.out.println("Major: " + major);
		System.out.println("GPA: " + GPA);
	}

}
