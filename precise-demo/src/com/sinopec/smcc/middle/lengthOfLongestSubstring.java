package com.sinopec.smcc.middle;

import java.io.IOException;
import java.util.Scanner;
/**
 * 
 * 给定一个字符串，找出其中不含有重复字符的 最长子串 的长度。
 * @author pcitc
 *
 */
public class lengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		 char[] chars = new char[256];
	        int begin = 0;
	        int res = 0;
	        for(int i = 0;i<s.length();i++){
	            while(begin <= i && chars[s.charAt(i)] > 0){
	                chars[s.charAt(begin)]--;
	                begin++;
	            }
	            chars[s.charAt(i)]++;
	            res = Math.max(res,i - begin + 1);
	        }
	        return res;
    }
	public static void main(String[] args) throws IOException{
		 //读入输入直到回车
		lengthOfLongestSubstring test = new lengthOfLongestSubstring();
		Scanner sc = new Scanner(System.in);
		int result = test.lengthOfLongestSubstring(sc.nextLine());
		System.out.println(result);
	}
}
