package ioc;

import java.util.ArrayList;
import java.util.List;

/**Bean的所有的属性值
 * @author Administrator
 *
 */
public class PropertyValues {

	List<PropertyValue> propertyValues = new ArrayList<PropertyValue>();

	public void addPropertyValue(PropertyValue propertyValue) {
		propertyValues.add(propertyValue);
	}

	public List<PropertyValue> getPropertyValues() {
		return this.propertyValues;
	}
}
