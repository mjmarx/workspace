package assignment7;

public class Complex {
	private double real, imag;
	
	public Complex(){}
	
	public Complex(double real, double imag){
		this.real = real;
		this.imag = imag;
	}
	
	double getReal(){
		return real;
	}
	
	double getImag(){
		return imag;
	}
	
	public Complex add(Complex c2) {
		double totalRealPart = this.real + c2.getReal();
		double totalImagPart = this.imag + c2.getImag();
		return new Complex(totalRealPart, totalImagPart);
	}
	
	public Complex subtract(Complex c2){
		double totalRealPart = this.real - c2.getReal();
		double totalImagPart = this.imag - c2.getImag();
		return new Complex(totalRealPart, totalImagPart);
	}
	
	public Complex multiply(Complex c2){
		 double a = this.real;
		 double b = this.imag;
		 double c = c2.real;
		 double d = c2.imag;
		 double newReal = (a*c-b*d);
		 double newImag = (b*c+a*d);
		 return new Complex(newReal, newImag);
	}
	
	public String toString(){
		return( this.real + " + " + this.imag +"i");
	}

}
