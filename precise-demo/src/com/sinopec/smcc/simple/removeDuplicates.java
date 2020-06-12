package com.sinopec.smcc.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.NumberUpSupported;

/**
 * 删除排序数组中的重复项
 * @author pcitc
 *
 */
public class removeDuplicates {

	 public static int removeDuplicates(int[] nums) {
		 List<Integer> list = new ArrayList<Integer>();
	        for (int i=0; i<nums.length; i++) {
	            if(!list.contains(nums[i])) {
	                list.add(nums[i]);
	            }
	        }
	     int[] resultArray = list.stream().mapToInt(Integer::valueOf).toArray();
	     for(int j=0;j<resultArray.length;j++){
	    	 System.out.println(resultArray[j]);
	     }
	     return list.size();
	 }
	 /*public static int removeDuplicates(int[] nums) {
		    if (nums.length == 0) return 0;
		    int i = 0;
		    for (int j = 1; j < nums.length; j++) {
		        if (nums[j] != nums[i]) {
		            i++;
		            nums[i] = nums[j];
		        }
		    }
		    return i + 1;
		}*/
	 public static void main(String[] args){
		 int[] nums = {0,1,1,3,4,4,5,6};
		 int len = removeDuplicates(nums);
	 }
}
