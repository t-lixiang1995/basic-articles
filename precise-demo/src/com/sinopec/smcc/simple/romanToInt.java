package com.sinopec.smcc.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.omg.PortableServer.ServantActivator;

/**
 * 罗马数字转整数，罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * @author pcitc
 *
 */
public class romanToInt {

	public int romanToInt(String s) {
		   int result = 0;
	        Map<String , Integer> roman_num_map =new HashMap<String , Integer>();
	        roman_num_map.put("I", 1);
	        roman_num_map.put("V", 5);
	        roman_num_map.put("X", 10);
	        roman_num_map.put("L", 50);
	        roman_num_map.put("C", 100);
	        roman_num_map.put("D", 500);
	        roman_num_map.put("M", 1000);        
	        int size = s.length();
	        for(int i = 1; i < size+1; ++i)
	        {
	            //小的数字位于大的数字左边

	        	if(i+1>size){
	        		result += roman_num_map.get(s.substring(i-1, i));
	        	}else{
	        		if(roman_num_map.get(s.substring(i-1, i)) < roman_num_map.get(s.substring(i, i+1)))
		            {
		                result -= roman_num_map.get(s.substring(i-1, i));
		            }
		            else
		            {
		                 result += roman_num_map.get(s.substring(i-1, i));
		            }  
	        	}
	                      
	        }       
	        return result;
	    }
	
	public static void main(String[] args){
		romanToInt romanToInt = new romanToInt();
		Scanner sc = new Scanner(System.in);
		int result = romanToInt.romanToInt(sc.nextLine());
		System.out.println(result);;
	}
 
}
