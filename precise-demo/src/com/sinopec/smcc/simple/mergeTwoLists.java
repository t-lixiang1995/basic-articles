package com.sinopec.smcc.simple;

import java.util.LinkedList;
import java.util.List;

import com.sinopec.smcc.simple.addTwoNumbers.ListNode;

/**
 * 合并两个有序链表为新的有序链表
 * @author pcitc
 *
 */
public class mergeTwoLists {

	private static List<ListNode> nodeList = null;
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
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
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		int x = 0;
		while(l1!=null){
			x++;
			l1 = l1.next;
		}
		int[] array1 = new int[x];
		int[] array2 = new int[x];
		for(int i=0;i<x;i++){
			array1[i] = l1.val;
			array2[i] = l2.val;
			l1 = l1.next;
			l2 = l2.next;
		}
		int[] result = mergeArray(array1,array2);
		return createLinkedList(result);
    }
	public int[] mergeArray(int[] a,int[] b){
		int[] result = new int[a.length+b.length];
		int i = 0,j =0,k = 0;
		while(i<a.length && j<b.length){
			if(a[i] < b[j]){
				result[k++] = a[i++];
				}
			else{
				result[k++] = b[j++];
			}
		}
		/* 后面连个while循环是用来保证两个数组比较完之后剩下的一个数组里的元素能顺利传入 *
         * 此时较短数组已经全部放入新数组，较长数组还有部分剩余，最后将剩下的部分元素放入新数组，大功告成*/
        while(i < a.length) 
            result[k++] = a[i++];
        while(j < b.length)
            result[k++] = b[j++];
		return result;
	}
}
