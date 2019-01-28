package clone;

import lombok.Data;

/**需要实现cloneable的接口，并重写他的方法，才能使用clone的方法。
 * @author guangfeng.yang
 *
 */
@Data
public class Cat  implements Cloneable{
	String name;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
