package TestSetDemo;

import java.util.Set;
import java.util.TreeSet;

class Book implements Comparable<Book>{
	
	private String title;
	private Double price;
	public Book(String title, Double price){
		
		this.price=price;
		this.title=title;
	}
	@Override
	public String toString(){
		return "书名："+this.title+",价格："+this.price;
	}
	@Override
	public int compareTo(Book o) {
		// TODO Auto-generated method stub
		if(this.price>o.price)
		{
			return 1;
		}
		if(this.price<o.price)
		{
			return -1;
		}
		else
		{
			return this.title.compareTo(o.title);  //这里调用了String类的比较方法
		}
	}
}

public class TestTreeSetDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		Set<Book> all=new TreeSet<Book>();
		all.add(new Book("JAVA开发",79.8));
		all.add(new Book("JAVA开发",79.8));//完全相同
		all.add(new Book("JASP开发",79.8));//部分相同
		all.add(new Book("ANDROID开发",99.8));//都不相同
		System.out.println(all);
	}
}
