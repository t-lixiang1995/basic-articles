package com.sinopec.smcc.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 移除元素
 * @author pcitc
 *
 */
public class removeElement {

	public static int removeElement(int[] nums, int val) {
		 int len = 0;
	        for(int i=0;i<nums.length;i++){
	        	if(nums[i]!=val){
	                nums[len] = nums[i];
	                len++;
	        	}
	        }
	        return len;
    }
	/*public static int removeElement(int[] nums, int val) {
		 List<Integer> list = new ArrayList<Integer>();
	        for (int i=0; i<nums.length; i++) {
	            if(nums[i]!=val) {
	                list.add(nums[i]);
	            }
	        }
	     nums = list.stream().mapToInt(Integer::valueOf).toArray();
	     return list.size();
   }*/
	public static void main(String[] args){
    	int[] array = {3,2,2,3};
    	removeElement(array,3);
    	for(int j=0;j<array.length;j++){
	    	 System.out.println(array[j]);
	     }
    }
}
