package exercise7a;


public class Animal {

	private int age;
	private String name;
	
	public Animal() {
		
	}
	
	public Animal(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public String toString() {
		return "Age: " + age + "\nName: " + name + "\n";
	}
}


