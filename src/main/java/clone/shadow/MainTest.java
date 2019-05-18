package clone.shadow;


import static org.junit.Assert.*;

import org.junit.Test;
/**浅复制
 * @author guangfeng.yang
 *
 */
public class MainTest {


	/**李四的老师，和张三的老师
	 * @throws CloneNotSupportedException
	 */
	@Test
	public void testClone() throws CloneNotSupportedException {
		Teacher teacher = new Teacher();
		teacher.setName("lisi");
		Student student = new Student();
		student.setAge(11);
		student.setName("xiao ming");
		student.setTeacher(teacher);
		Student stduent2 =(Student) student.clone();
		stduent2.setAge(15);
		stduent2.setName("xiao dong");
		Teacher teacher2 = stduent2.getTeacher();
		teacher2.setName("zhang san");
		System.out.println(student.toString());
		System.out.println(stduent2);
	}
	/**两个人叫做李四名字的学生的2个老师
	 * @throws CloneNotSupportedException
	 */
	@Test
	public void testClone1() throws CloneNotSupportedException {
		Teacher teacher = new Teacher();
		teacher.setName("lisi");
		Student student = new Student();
		student.setAge(11);
		student.setName("xiao ming");
		student.setTeacher(teacher);
		Student stduent2 =(Student) student.clone();
		Teacher teacher2 = stduent2.getTeacher();
		teacher2.setName("zhang san");
		System.out.println(student.toString());
		System.out.println(stduent2);
	}

}
