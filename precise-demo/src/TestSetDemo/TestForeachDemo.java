package TestSetDemo;

import java.util.ArrayList;
import java.util.List;

public class TestForeachDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		//设置了泛型，从而保证集合中所有的数据类型都一致
		List<String> all=new ArrayList<String>();
		all.add("A");
		all.add("B");
		all.add("C");             //重复元素
		all.add("D");
		for(String str:all){
			
			System.out.println(str);
		}
	}
}
