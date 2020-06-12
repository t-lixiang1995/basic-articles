package TestSetDemo;

import java.util.HashSet;
import java.util.Set;

class Note {
	
	private String title;
	private Double price;
	public Note(String title, Double price){
		
		this.price=price;
		this.title=title;
	}
	@Override
	public String toString(){
		return "书名："+this.title+",价格："+this.price;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
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
		Note other = (Note) obj;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}
public class TestHashSetDemo {

	public static void main(String[] grgs) throws Exception{//此处直接抛出
		Set<Note> all=new HashSet<Note>();
		all.add(new Note("JAVA开发",79.8));
		all.add(new Note("JAVA开发",79.8));//完全相同
		all.add(new Note("JASP开发",79.8));//部分相同
		all.add(new Note("ANDROID开发",99.8));//都不相同
		System.out.println(all);
	}
}
