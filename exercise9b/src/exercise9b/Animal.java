package exercise9b;

public abstract class Animal {

	private double weight;
	
	public Animal(double weight) {
		this.weight = weight;
	}

	public abstract void animalNoise();
}
