package com.sinopec.smcc.simple;

import java.util.Scanner;

/**
 * 实现 strStr() 函数。不使用kmp算法
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 * @author pcitc
 *
 */
public class strStr {

	 /*public static int strStr(String haystack, String needle) {
		 if(null==haystack||null == needle) {
		        return -1;
		    }
		    if(needle.length()>haystack.length()){
		        return -1;
		    }
		    if (needle.length()==0) {
		        return 0;
		    }
		    return haystack.indexOf(needle);
	 }*/
	 public static int strStr(String haystack, String needle) {
         int l1 = haystack.length();
		int l2 = needle.length();
		if(l1<l2)return -1;
		String substr = null;
		for(int i = 0;i<=l1-l2;i++) {
			substr = haystack.substring(i, i+l2);
			if(needle.equals(substr)) {
				return i;
			}
		}
		return -1;
    }
	 public static void main(String[] args){
		 Scanner haystack = new Scanner(System.in);
		 Scanner needle = new Scanner(System.in);
		 System.out.println(strStr(haystack.nextLine(),needle.nextLine()));
	 }
}
