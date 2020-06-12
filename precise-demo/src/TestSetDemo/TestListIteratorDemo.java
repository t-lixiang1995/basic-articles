package TestSetDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class TestListIteratorDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		//设置了泛型，从而保证集合中所有的数据类型都一致
		List<String> all=new ArrayList<String>();
		all.add("A");
		all.add("B");
		all.add("C");             //重复元素
		all.add("D");
		
		System.out.print("由前向后输出：");
		ListIterator<String> iter=all.listIterator();
		while(iter.hasNext()){
			String str=iter.next();
			System.out.print(str+"丶");
		}
		
		System.out.print("\n从后向前输出：");
		while(iter.hasPrevious()){
			
			System.out.print(iter.previous()+"丶");
		}
	}
}
