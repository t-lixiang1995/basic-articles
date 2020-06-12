package TestStreamDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamDemo {


	public static void main(String[] grgs) throws Exception{//此处直接抛出
		//设置了泛型，从而保证集合中所有的数据类型都一致
		List<String> all=new ArrayList<String>();
/*		all.add("Hello");
		all.add("Hello");             //重复元素
		all.add("World");
		all.add("World");
		all.add("good");
		all.add("good");
		Stream<String> stream=all.stream();      //取得stream类的对象
		System.out.println(all.size());
//		System.out.println(stream.count());
//		System.out.println(stream.distinct().count());          //取得数据个数
		List<String> newAll=stream.distinct().collect(Collectors.toList());
		newAll.forEach(System.out::println);
*/
		
		all.add("Java");
		all.add("Android");             
		all.add("Ios");
		all.add("JSP");
		all.add("ORACLE");
		all.add("C++");
		Stream<String> stream=all.stream();
		//过滤，使用了断言型函数式接口，String类的contains方法
	//	List<String> newAll=stream.distinct().filter((x)->x.contains("a")).collect(Collectors.toList());
		List<String> newAll=stream.distinct().map((x)->x.toLowerCase()).filter((x)->x.contains("a")).collect(Collectors.toList());
		newAll.forEach(System.out::println);
	}
}
