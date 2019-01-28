package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class CollectionsUtilsTest<E> {

	@Test
	public void testSingle2List(){
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("1");
		arrayList.add("2");
		List<ArrayList<String>> singletonList = Collections.singletonList(arrayList);
		System.out.println(singletonList.size());
		
		String s = "hello";
		Set<String> singletonSet = Collections.singleton(s);
		s = "world";
		System.out.println(singletonSet);
		
		String b = "test";
		System.out.println(b);
		b = "abest";
		System.out.println(b);
		
	}
	
	@Test
	public void indexOfSublist(){
		List<String> source = new ArrayList<String>();
		source.add("1");
		source.add("4");
		source.add("4");
		source.add("4");
		source.add("4");
		source.add("4");
		source.add("5");
		List<String> target = new ArrayList<String>();
		target.add("4");
		target.add("5");
		int indexOfSubList = Collections.indexOfSubList(source, target);
		System.out.println(indexOfSubList);
	}
	
//	@Test
//	public void testContinueTest(){
//		nextCand; 
//		for (int i = 0; i < 100; i++) {
//			continue nextCand;
//		}
//	}
	
	@Test
	public void testshuffle(){
		List<String> list = new ArrayList<String>();
		list.add("1231");
		list.add("131");
		list.add("11");
		list.add("31");
		Collections.shuffle(list );
		System.out.println(list.toString());
	}
	
	@Test
	public void testLinkedList(){
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("121");
		linkedList.add("1");
		String string = linkedList.get(1);
		System.out.println(string);
	}
}
