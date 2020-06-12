package com.pcitc.com.common_arithmetic;

import java.util.Scanner;

/**
 * 滑动窗口算法
 * 找出给定字符串中特定子串的位置
 * @author pcitc
 *
 */
public class Sliding_window {
	public static int bf(String ts, String ps) {
		char[] t = ts.toCharArray();
		char[] p = ps.toCharArray();
		int i = 0; // 主串的位置
		int j = 0; // 模式串的位置
		while (i < t.length && j < p.length) {
			if (t[i] == p[j]) { // 当两个字符相同，就比较下一个
				i++;
				j++;
			} else {
				i = i - j + 1; // 一旦不匹配，i后退
				j = 0; // j归0
			}
		}
		if (j == p.length) {
			return i - j;
		} else {
			return -1;
		}
	}
	
	public static void main(String[] args){
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int result = bf(sc1.nextLine(), sc2.nextLine());
		System.out.println(result);
	}
}
