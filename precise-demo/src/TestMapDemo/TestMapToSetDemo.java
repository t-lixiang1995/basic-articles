package TestMapDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMapToSetDemo {

	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("壹", 1);
		map.put("贰", 2);
		map.put("叁", 33);
		//将map集合变为set集合是为了使用Iterator方法
		Set<Map.Entry<String,Integer>> set=map.entrySet();
		Iterator<Map.Entry<String,Integer>> iter=set.iterator();
		while(iter.hasNext()){
			Map.Entry<String, Integer> me=iter.next();
			System.out.println(me.getKey()+"="+me.getValue());
		}
	}
}
