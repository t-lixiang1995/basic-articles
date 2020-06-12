package TestSetDemo;

import java.util.Enumeration;
import java.util.Vector;

public class TestEnumerationDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		//设置了泛型，从而保证集合中所有的数据类型都一致
		Vector<String> all=new Vector<String>();
		all.add("A");
		all.add("B");
		all.add("C");             //重复元素
		all.add("D");
		
		Enumeration<String> enu=all.elements();
		while(enu.hasMoreElements()){
			
			String str=enu.nextElement();
			System.out.println(str);
		}
	}
}
