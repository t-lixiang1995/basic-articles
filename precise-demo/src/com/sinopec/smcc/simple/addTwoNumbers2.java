package com.sinopec.smcc.simple;

import java.util.LinkedList;
import java.util.List;
/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * @author pcitc
 *
 */
public class addTwoNumbers2 {
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) { val = x; }
	  }
	
	private static List<ListNode> nodeList = null;

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		 ListNode res,temp;
         res=new ListNode(0);
         temp=res;
         int ten=0;
         int x=0,y=0;
         while(l1!=null||l2!=null){   
             x=l1==null?0:l1.val;
             y=l2==null?0:l2.val;
             temp.val=(x+y+ten)%10;
             ten=(x+y+ten)/10;
             l1=l1==null?null:l1.next;
             l2=l2==null?null:l2.next;
             if(l1!=null||l2!=null){
                 temp.next=new ListNode(0);
                 temp=temp.next; 
             }
         }
         if(ten!=0){
             temp.next=new ListNode(ten);
         }
         return res;
    }

	public static void  main(String[] args){
		addTwoNumbers2 result = new addTwoNumbers2();
		int[] a = { 2,4,3};
		int[] b = { 5,6,4};
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
