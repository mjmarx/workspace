package assignment5;

public class Cat {

	private String name, breed;
	private int age;
	
	public Cat(String name, String breed, int age) {
		this.name = name;
		this.breed = breed;
		this. age = age;	
	}
	
	protected void print(){
		System.out.println("Cat name: " + name + "\n");
		System.out.println("Cat breed: " + breed + "\n");
		System.out.println("Cat age: " + age + "\n\n");
	}
}
