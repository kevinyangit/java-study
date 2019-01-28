package clone.deep;

import lombok.Data;

/**子引用也实现clone的接口
 * @author guangfeng.yang
 *
 */
@Data
public class Teacher implements Cloneable{
	String name;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
