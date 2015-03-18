package assignment10;

public class Manager {
	Cat[] cats = new Cat[100];
	Dog[] dogs = new Dog[100];
	int catCount, dogCount;
	
	public Manager(){
		catCount = 0;
		dogCount = 0;
	}
	
	public String addDog(String name, int age, String breed){
		Dog newDog = new Dog(name,age,breed);
		dogs[dogCount] = newDog;
		dogCount++;
		return ("\nDog added!" + newDog.toString());
	}
	public String addCat(String name, int age, String breed){
		Cat newCat = new Cat(name,age,breed);
		cats[catCount] = newCat;
		catCount++;
		return ("\nCat added!" + newCat.toString());
	}
	public double averageAge(){
		System.out.println("\n stage 1");
		int total = 0;
		for(int i = 0; i<catCount; i++){
			total+=cats[i].age;
		}
		System.out.println("cat age total: " + total);
		for(int i = 0; i<dogCount; i++){
			total+=dogs[i].age;
		}
		System.out.println("age total: " + total);
		System.out.println("dogCount = " + dogCount);
		System.out.println("catCount = " + catCount);
		System.out.println("\n stage 2");
		double count = (double) catCount+dogCount;
		System.out.println("count is " + count);
		double avg = (double) total/count;
		System.out.println("average is " + avg);
		System.out.println("\n stage 3");
		return avg;
	}


	
	
}
