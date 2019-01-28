package clone.deep;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.hutool.core.util.ObjectUtil;

/**深复制，基本类型不用，子引用对象也要实现clone的接口。
 * 缺点：如果是多个引用对象，一个个实现，显得非常的麻烦，
 * 1. 可以使用Hutool工具的Cloneable的接口，或者是CloneSupport类
 * 2. 最好的方法是通过流来实现深复制，也必须实现serializable的接口， hutool也支持ObjectUtils.closeStream();
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
	
	@Test
	public void testCloneByUtils() throws Exception {
		Student student = new Student();
		student.setName("li si");
		Student cloneByStream = ObjectUtil.cloneByStream(student);
		cloneByStream.setName("zhang san");
		System.out.println(cloneByStream);
		System.out.println(student);
	}

}
