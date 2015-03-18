package assignment8;

public class GradStudent extends Student {
	
	double UDGPA;

	public GradStudent(String name, int age, int ID, String major, double GPA, double UDGPA) {
		super(name, age, ID, major, GPA);
		this.UDGPA = UDGPA;
	}
	
	void print(){
		super.print();
		System.out.println("UD GPA: " + UDGPA);
	}

}
