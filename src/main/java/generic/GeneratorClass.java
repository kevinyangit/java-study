package generic;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 泛型类
 * 
 * @author guangfeng.yang
 *
 */
@Data
@AllArgsConstructor
public class GeneratorClass<T, K> {

	private T key;
	private K value;

	public static void main(String[] args) {
		GeneratorClass<String, String> generatorClass = new GeneratorClass<String,String>("hello", "world");
		System.out.println(generatorClass.toString());
	}
}
