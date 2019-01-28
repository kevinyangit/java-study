package clone.hutool;

import cn.hutool.core.clone.CloneRuntimeException;
import cn.hutool.core.clone.CloneSupport;
import cn.hutool.core.clone.Cloneable;
/**
 * 猫猫类，使用实现Cloneable方式
 * @author Looly
 *
 */

public class ShadowCloneDemo {
	
	/**
	 * 猫猫类，使用实现Cloneable方式
	 * @author Looly
	 *
	 */
	private static class Cat implements Cloneable<Cat>{
	    private String name = "miaomiao";
	    private int age = 2;

	    @Override
	    public Cat clone() {
	        try {
	            return (Cat) super.clone();
	        } catch (CloneNotSupportedException e) {
	            throw new CloneRuntimeException(e);
	        }
	    }
	}
	
	/**
	 * 狗狗类，用于继承CloneSupport类
	 * @author Looly
	 *
	 */
	private static class Dog extends CloneSupport<Dog>{
	    private String name = "wangwang";
	    private int age = 3;
	}
   
}