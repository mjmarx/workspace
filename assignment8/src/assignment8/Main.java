package assignment8;

public class Main {

	public static void main(String[] args) {
		Student s = new Student("Erick", 20, 4352345, "ISYE", 3.2);
		s.print();
		System.out.println("\n");
		
		GradStudent g = new GradStudent("sheldon", 19, 35452, "ISYE", 2.9, 2.8);
		g.print();
		System.out.println("\n");
		
		Instructor i = new Instructor("Mary", 40, 4521341, "English");
		i.print();
		System.out.println("\n");
		
		Professor p = new Professor("Chris", 35, 35234, "Csci", true);
		p.print();
		System.out.println("\n");
		
		LibraryStaff l = new LibraryStaff("Susan", 65, "Book Checker");
		l.print();

	}

}
