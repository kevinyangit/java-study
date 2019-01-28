package clone;

import lombok.Data;

@Data
public class Cat  implements Cloneable{
	String name;
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
