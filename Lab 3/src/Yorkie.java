public class Yorkie extends Dog {

	
	public Yorkie(String name, int age) {
		super(name,age);
	}
	
	public String toString() {
		String temp = "Yorkie Data\n";
		
		temp+= super.toString();
		
		return temp;
	}
}
