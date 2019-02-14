package ioc;

/**属性值
 * @author guangfeng.yang
 *
 */
public class PropertyValue {

	public PropertyValue(String name, Object value) {
		this.name = name;
		this.value = value;
	}
	private String name;
	private Object value;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
