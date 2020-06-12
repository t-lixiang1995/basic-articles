package com.sinopec.smcc.simple;

import java.util.LinkedList;
import java.util.List;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * @author pcitc
 *
 */
public class addTwoNumbers {
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	private static List<ListNode> nodeList = null;
	private static int num_a = 0;
	private static int num_b = 0;
	private static int power_a = 0;
	private static int power_b = 0;
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = null;
		number(l1,num_a,power_a);
		number1(l2,num_b,power_b);
		int sum = num_a+num_b;
		String str = String.valueOf(sum);
		int size = str.length();
		int i=0;
		int[] dataArray = new int[size];
		while(size>0){
			dataArray[i]=sum%10;
			sum = sum/10;
			size--;
			i++;
		}
		result = createLinkedList(dataArray);
		return result;
    }
	public void number(ListNode listNode,int num,int power){

		num+=listNode.val*Math.pow(10, power);
		num_a = num;
		if(listNode.next!=null){
			power++;
			number(listNode.next,num,power);
		}
	}
	public void number1(ListNode listNode,int num,int power){

		num+=listNode.val*Math.pow(10, power);
		num_b = num;
		if(listNode.next!=null){
			power++;
			number1(listNode.next,num,power);
		}
	}
	public static void  main(String[] args){
		addTwoNumbers result = new addTwoNumbers();
		int[] a = { 0};
		int[] b = { 0};
		ListNode nodelist_a = result.createLinkedList(a);
		ListNode nodelist_b = result.createLinkedList(b);
		ListNode data = result.addTwoNumbers(nodelist_a,nodelist_b);
		while(data!=null){
			System.out.print(data.val + " -> ");
			data = data.next;
		}
	}
	public ListNode createLinkedList(int[] array) {  
        nodeList = new LinkedList<ListNode>();  
        // 将一个数组的值依次转换为Node节点  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  
            nodeList.add(new ListNode(array[nodeIndex]));  
        }  
        // 将所有节点连接起来  
        for (int Index = 0; Index < array.length-1; Index++) {  
            nodeList.get(Index).next = nodeList  
                    .get(Index + 1);  
        }  
        return nodeList.get(0);
    }  
}
