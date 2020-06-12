package com.sinopec.smcc.simple;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/**
 * 栈
 * 有效的括号
 * @author pcitc
 *
 */
public class isValid {

	  private HashMap<Character, Character> mappings;
	  public isValid() {
	    this.mappings = new HashMap<Character, Character>();
	    this.mappings.put(')', '(');
	    this.mappings.put('}', '{');
	    this.mappings.put(']', '[');
	  }

	  public boolean isValid(String s) {
	    Stack<Character> stack = new Stack<Character>();
	    for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);
	      if (this.mappings.containsKey(c)) {
	        char topElement = stack.empty() ? '#' : stack.pop();
	        if (topElement != this.mappings.get(c)) {
	          return false;
	        }
	      } else {
	        stack.push(c);
	      }
	    }
	    return stack.isEmpty();
	 }
	 public static void main(String[] args){
		 isValid obj = new isValid();
		 Scanner sc = new Scanner(System.in);
		 System.out.println(obj.isValid(sc.nextLine()));
	 }
}
