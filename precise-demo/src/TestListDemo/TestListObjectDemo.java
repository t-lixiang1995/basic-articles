package TestListDemo;

import java.util.ArrayList;
import java.util.List;

class Book{
	
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
	public boolean equals(Object obj) {			
			if(this==obj){
				return true;
			}
			if(obj==null){
				return false;
			}
			if(!(obj instanceof Book)){
				return false;
			}
			Book book=(Book) obj;
			if(this.title.equals(book.title) && this.price==book.price){
				return true;
			}
			return false;
		}
	}
public class TestListObjectDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		
		List<Book> all=new ArrayList<Book>();
		System.out.println("长度："+all.size()+"，是否为空："+all.isEmpty());
		all.add(new Book("JAVA开发",79.9));
		all.add(new Book("JSP开发",69.9));             //重复元素
		all.add(new Book("ORACLE",89.9));
		//任何情况下集合内容的查询与数据删除都必须提供equals方法
		all.remove(new Book("ORACLE",89.9));
		System.out.println("长度："+all.size()+"，是否为空："+all.isEmpty());
		System.out.println(all);
	}
}
