package TestListDemo;

import java.util.ArrayList;
import java.util.List;

public class TestListDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		//设置了泛型，从而保证集合中所有的数据类型都一致
		List<String> all=new ArrayList<String>();
		System.out.println("长度："+all.size()+"，是否为空："+all.isEmpty());
		all.add("Hello");
		all.add("Hello");             //重复元素
		all.add("World");
		System.out.println("长度："+all.size()+"，是否为空："+all.isEmpty());
		//collection接口定义了size（）方法可以取得集合长度
		//list接口扩充了一个get（）方法，可以根据索引取得元素
		for(int x=0;x<all.size();x++){
			String str=all.get(x);
			System.out.println(str);
		}
	}
}
