package TestMapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestHashMapOperationDemo {

	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("壹", 1);
		map.put("贰", 2);
		map.put("叁", 33);
		map.put("叁", 3);             //key值重复会覆盖
		map.put(null, 0);
		System.out.println(map.get("壹"));
		System.out.println(map.get("叁"));
		System.out.println(map.get("陸"));
		System.out.println(map.get(null));
		
		Set<String> set=map.keySet();
		Iterator<String> iter=set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}
}
