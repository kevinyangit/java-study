package clone.deep;

import lombok.Data;

@Data
public class Student  implements Cloneable{

	private String name;
	private int age;
	private Teacher teacher;
	
	//重写clone的方法
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Student student = (Student)super.clone();
		student.teacher = (Teacher) teacher.clone();
		return student;
	}
}
