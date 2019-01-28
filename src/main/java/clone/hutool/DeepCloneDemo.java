package clone.hutool;

import clone.Dog;
import cn.hutool.core.util.ObjectUtil;

public class DeepCloneDemo {
	
	public static void main(String[] args) {
		Dog dog = new Dog();
		dog.setName("test");
		Dog dog2 = ObjectUtil.cloneByStream(dog);
		
		System.out.println(dog.getName());
		System.out.println(dog2.getName());
		
	}

}
