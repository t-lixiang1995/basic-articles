package com.sinopec.smcc.simple;
/**
 * 给定一个整数数组 nums 和一个目标值 target，在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * @author pcitc
 *
 */
public class twoSum {
	    public static int[] twoSum(int[] nums, int target) {
	        int[] a = new int[2];
	        for(int i=0;i<nums.length-1;i++){
	            for(int j=i+1;j<nums.length;j++){
	                if(nums[i]+nums[j]==target){
	                    a[0]=i;
	                    a[1]=j;
	                }
	            }
	        }
	        return a;
	    }
	    public static void main(String[] args){
	    	int[] nums ={2, 7, 11, 15};
	    	int[] result =twoSum(nums,9);
	    	System.out.println(result[0]+","+result[1]);
	    }
}

