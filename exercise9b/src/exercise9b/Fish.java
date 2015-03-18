package exercise9b;

public class Fish extends Animal implements Food{

	String sound, eating;
	
	public Fish(double weight) {
		super(weight);
	}
	
	@Override
	public void animalNoise(){
		System.out.println("Fish: " + sound);
	}
	
	@Override
	public void howToEat(){
		System.out.println("Fish: " + eating);
	}

}
