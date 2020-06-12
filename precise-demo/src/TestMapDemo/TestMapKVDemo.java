package TestMapDemo;

import java.util.HashMap;
import java.util.Map;

class Book{
	private String title;
	public Book(String title){
		this.title=title;
	}
	@Override
	public String toString(){
		return "书名："+this.title;	
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
public class TestMapKVDemo {

	public static void main(String[] args) throws Exception{
		Map<Book,String> map=new HashMap<Book,String>();
//		map.put(new String("JAVA"), new Book("JAVA开发"));
//		System.out.println(map.get(new String("JAVA")));
		map.put( new Book("JAVA开发"),new String("JAVA"));
		System.out.println(map.get(new Book("JAVA开发")));
	}
}
