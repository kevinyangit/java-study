package collection;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class ConcurrentModifiedExceptionTest {
	@Test
	public void testSingleThreadForeach() throws Exception {
		ArrayList<Integer> arrayList = new ArrayList<>();
		arrayList.add(2);
		arrayList.add(1);
		arrayList.add(3);
		for (Integer object : arrayList) {
			if(object == 2){
				arrayList.remove(object);
			}
		}
	}
	@Test
	public void testSingleThreadIterator() throws Exception {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(2);
		arrayList.add(1);
		arrayList.add(3);
		Iterator<Integer> iterator = arrayList.iterator();
		//foreach 循环实际就是iterator的一个简写
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			if(integer == 2){
				//用集合去删除
				 arrayList.remove(integer);
			}
		}
	}
	
	@Test
	public void testSingleThreadNoThrow() throws Exception {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(2);
		arrayList.add(1);
		arrayList.add(3);
		Iterator<Integer> iterator = arrayList.iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			if(integer == 2){
				//用迭代器，删除一边循环的数字就可以，为什么？
				iterator.remove();
			}
		}
	}
}
