package com.sinopec.smcc.simple;

import java.util.Scanner;

/**
 * 最长公共前缀
 * 查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
 * @author pcitc
 *
 */
public class longestCommonPrefix {

	 public static String longestCommonPrefix(String[] strs) {
		 
		 if (strs.length == 1){
	         return strs[0];
	     }
	     StringBuilder sb = new StringBuilder();
	     if (strs.length>1) {
	    	 int len = strs[0].length();
			 for(int i=0;i<strs.length;i++){
				 len = Math.min(len, strs[i].length());
			 }
	         for (int i = 0; i < len; i++) {
	             char curr = strs[0].charAt(i);
	             for (int j = 1; j < strs.length; j++) {
	                 if (strs[j].charAt(i) != curr) {
	                     return sb.toString();
	                 }	         
	             }
	             sb.append(curr);
	         }
	     }
	    return sb.toString();
	 }
	 /*public static String longestCommonPrefix(String[] strs) {
	 if (strs.length == 1){
         return strs[0];
     }
     StringBuilder sb = new StringBuilder();
     if (strs.length>1) {
         int len = strs[0].length();
         for (int i = 0; i < len; i++) {
             char curr = strs[0].charAt(i);
             for (int j = 1; j < strs.length; j++) {
                 if (strs[j].length()<=i ||strs[j].charAt(i) != curr) {
                     return sb.toString();
                 }
                 if (strs[j].charAt(i) == curr && j == strs.length - 1) {
                     sb.append(curr);
                 }
             }
         }
     }
    return sb.toString();
	}*/
	 public static void main(String[] args){
		 Scanner s1 = new Scanner(System.in);
		 Scanner s2 = new Scanner(System.in);
		 Scanner s3 = new Scanner(System.in);
		 String[] strings = {s1.nextLine(),s2.nextLine(),s3.nextLine()};
		 System.out.println(longestCommonPrefix(strings));
	 }
}
