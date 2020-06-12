package com.sinopec.smcc.simple;

import java.util.Scanner;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * @author pcitc
 *
 */
public class isPalindrome {

	public boolean isPalindrome(int x) {
        if(x<0){
        	return false;
        }
        int ret = 0;
        int data = x;
        while(x!=0){
        	int temp = ret*10+x%10;
        	ret = temp;
        	x/=10;
        }
        if(data==ret){
        	return true;
        }else{
        	return false;
        }
    }
	
	/*public boolean isPalindrome(int x) {
		 String reverseNumber = new StringBuilder(String.valueOf(x)).reverse().toString(); 
		 return reverseNumber.equals(String.valueOf(x));
	}*/
	 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		isPalindrome isPalindrome = new isPalindrome();
		System.out.println(isPalindrome.isPalindrome(sc.nextInt()));
	}
}
