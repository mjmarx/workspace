package assignment6;

public class Triangle extends GeometricObject {
	double a,b,c;
	
	public Triangle(){
		super();
	}
	
	public Triangle(double a, double b, double c){
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.calcPerimeter();
		this.calcArea();
	}
	
	double calcPerimeter(){
		double perimeter = a+b+c;
		super.setPerimeter(perimeter);
		return perimeter;
	}
	
	double calcArea(){
		double p = (this.calcPerimeter())/2;
		double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		super.setArea(area);
		return area;
	}
	
	public static void main(String[] args) {
		Triangle tri = new Triangle(3,4,5);
		tri.printArea();
		tri.printPerimeter();
	}
	
}
