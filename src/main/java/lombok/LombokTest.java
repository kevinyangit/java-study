package lombok;

public class LombokTest {

	public static void main(String[] args) {
		Student student = new Student("name","1213");
		student.setAge("11");
		System.out.println(student);
		Student student2 = new Student();
	}
}
