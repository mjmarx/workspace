package assignment5;

public class Dog {

	private String name, breed;
	int age;
	
	public Dog(String name, String breed, int age) {
		this.name = name;
		this.breed = breed;
		this. age = age;
		
	}
	
	protected void print(){
		System.out.println("Dog name: " + name + "\n");
		System.out.println("Dog breed: " + breed + "\n");
		System.out.println("Dog age: " + age + "\n\n");
	}
	
}
