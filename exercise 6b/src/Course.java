
public class Course {

	String courseName;
	Teacher teach;
	private Student[] students = new Student[]();
	private int classSize;
	
	public Course(String course){
		this.courseName = course;
	}
	
	public void addStudent(Student s1){
		students[classSize] = s1;
		classSize++;
	}
	
	public void setTeacher(Teacher t1){
		teach = t1;
	}
	


}
