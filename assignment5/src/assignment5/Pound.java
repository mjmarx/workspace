package assignment5;

public class Pound {

	//Data fields to store the actual cats and dog objects.
	private Cat[] cats = new Cat[10];
	private Dog[] dogs = new Dog[15];
	private int catCount = 0;
	private int dogCount = 0;
	
	//Generic constructor.
	public Pound() {
		
	}
	
	
	//Methods to add actual Cat/Dog objects.
	public void addDog(Dog d1) {
		dogs[dogCount] = d1;
		dogCount++;
	}
	
	public void addCat(Cat c1) {
		cats[catCount] = c1;
		catCount++;
	}
	
	//Small method to print all of the animals in the pound.
	protected void printAnimals() {
		
		System.out.println("Printing Dogs:");
		for(int i = 0; i < dogCount; i++) {
			dogs[i].print();
		}
		
		System.out.println("\nPrinting Cats:");
		for(int i = 0; i < catCount; i++) {
			cats[i].print();
		}
	}
	
	
	//Main method. Execution begins here.
	public static void main(String[] args) {
		Pound p1 = new Pound();
		
		p1.addDog(new Dog("Bob", "Husky", 5));
		p1.addDog(new Dog("King", "Yorkie", 3));
		p1.addCat(new Cat("Hernan", "Siamese", 8));
		
		p1.printAnimals();
	}
}


