package exercise8a;

public class Test {
	  public static void main(String[] args) {
	    m(new GraduateStudent());
	    m(new Student());
	    m(new Person());
	    m(new Object());
	  }

	  public static void m(Student x) {
	    System.out.println(x.toString());
	  }
	}


