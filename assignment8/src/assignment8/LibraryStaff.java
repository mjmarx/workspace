package assignment8;

public class LibraryStaff extends Person {

	String jobDesc;
	
	public LibraryStaff(String name, int age, String jobDesc) {
		super(name, age);
		this.jobDesc = jobDesc;
	}
	
	void print(){
		super.print();
		System.out.println("Job Description: " + jobDesc);
	}

}
