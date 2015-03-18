package assignment6;

public class GeometricObject {
	  
	private double perimeter;
	private double area;
  
	//Construct a default geometric object
	public GeometricObject() {
    
	}

	public double getPerimeter() {
		return perimeter;
	}
	
	public double getArea() {
		return area;
	}
	
	public void setPerimeter(double perimeter) {
		this.perimeter = perimeter;
	}
	
	public void setArea(double area) {
		this.area = area;
	}
	
	public void printArea() {
		System.out.println(area);
	}
	
	public void printPerimeter() {
		System.out.println(perimeter);
	}
}
