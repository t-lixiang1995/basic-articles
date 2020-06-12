package com.sinopec.smcc.simple;
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author pcitc
 *
 */
public class maxSubArray {
	 public static int maxSubArray(int[] nums) {
	        int res = nums[0];
	        int sum = 0;
	        for (int num : nums) {
	            if (sum > 0)
	                sum += num;
	            else
	                sum = num;
	            res = Math.max(res, sum);
	        }
	        return res;
	    }
	 public static void main(String[] args){
		 int[] nums ={-2,1,-3,4,-1,2,1,-5,4};
		 System.out.println(maxSubArray(nums));
	 }
}
