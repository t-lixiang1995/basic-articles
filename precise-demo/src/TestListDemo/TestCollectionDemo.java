package TestListDemo;

import java.util.ArrayList;
import java.util.Collection;

public class TestCollectionDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		//设置了泛型，从而保证集合中所有的数据类型都一致
		Collection<String> all=new ArrayList<String>();
		System.out.println("长度："+all.size()+"，是否为空："+all.isEmpty());
		all.add("Hello");
		all.add("Hello");             //重复元素
		all.add("World");
		System.out.println("长度："+all.size()+"，是否为空："+all.isEmpty());
		Object obj[]=all.toArray();
		for(int x=0;x<obj.length;x++){
			System.out.println(obj[x]);
		}
	
	}
}
