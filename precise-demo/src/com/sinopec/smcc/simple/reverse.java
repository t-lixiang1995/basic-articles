package com.sinopec.smcc.simple;

import java.util.Scanner;
/**
 * 整数反转
 * @author pcitc
 *
 */
public class reverse {
	 public int reverse(int x) {
         /**
        ret 保存旧的翻转中间值, temp 保存新的翻转过程中间值
        	依次提取 x 的末位加入 temp, 如果发生溢出则通过temp/10 
        	无法得到上一轮的翻转结果 ret
        **/
        int ret = 0;
        while(x != 0) {
            int temp = ret*10 + x%10;
            if(temp / 10 != ret)
                return 0;
            ret = temp;
            x /= 10;
        }
        return ret;
    }
	 //貌似性能更好
/*	 public int reverse(int x) {

	        int flag=x<0?-1:1;
	        int num=Math.abs(x);
	        StringBuilder newNum=new StringBuilder();
	        newNum.append(num);
	        newNum.reverse();
	        try {
	            int result = Integer.parseInt(newNum.toString());
	            return flag*result;
	        }
	        catch (NumberFormatException e){}
	        return 0;
	    }*/
	 
	public static void main(String[] args){
		reverse obj = new reverse();
		Scanner sc = new Scanner(System.in);
		int init = sc.nextInt();
		int result = obj.reverse(init);
		System.out.println(result);
	}
}
