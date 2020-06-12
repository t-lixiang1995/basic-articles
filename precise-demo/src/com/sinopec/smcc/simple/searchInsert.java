package com.sinopec.smcc.simple;
/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @author pcitc
 *
 */
public class searchInsert {

	public static int searchInsert(int[] nums, int target) {
		int i;
        for(i=0;i<nums.length;i++){
        	 if(nums[i]>target){
                 return i;
             }
         	if(nums[i]==target){
         		return i;
         	}
        }
        return i;
    }
	public static void main(String[] args){
		int nums[]={1,3,5,6};
		System.out.println(searchInsert(nums,4));
	}
}
