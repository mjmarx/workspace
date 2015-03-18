package exercise7a;


public class Cat extends Animal {

	String breed;
	
	public Cat() {
		
	}

	public Cat(int age, String name, String breed) {
		super(age, name);
		this.breed = breed;
	}
	
	//Fill out the toString() method.
	public String toString() {
	
		return (super.toString() + "Breed: " + breed);
	}
}

