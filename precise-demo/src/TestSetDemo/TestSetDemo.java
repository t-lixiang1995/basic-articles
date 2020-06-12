package TestSetDemo;

import java.util.HashSet;
import java.util.Set;

public class TestSetDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		//设置了泛型，从而保证集合中所有的数据类型都一致
		Set<String> all=new HashSet<String>();
		System.out.println("长度："+all.size()+"，是否为空："+all.isEmpty());
		all.add("OK");
		all.add("Hello");
		all.add("Hello");             //重复元素
		all.add("World");
		System.out.println("长度："+all.size()+"，是否为空："+all.isEmpty());
		System.out.println(all);
	}
}
