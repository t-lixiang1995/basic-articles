package com.sinopec.smcc.simple;

import java.util.LinkedList;
import java.util.List;
/**
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * @author pcitc
 *
 */
public class isUnivalTree2 {

	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	private static int[] array = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
	private static List<TreeNode> nodeList = null; 
	public boolean isUnivalTree(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree(root.right)));
        return left_correct && right_correct;
    }
    public static void main(String[] args){ 
    	isUnivalTree2 ivalTree = new isUnivalTree2();
    	TreeNode root = ivalTree.createBinTree();
    	boolean result = ivalTree.isUnivalTree(root);
    	System.out.println(result);
    }
    public TreeNode createBinTree() {  
    	nodeList  = new LinkedList<TreeNode>();  
        // 将一个数组的值依次转换为Node节点  
        for (int nodeIndex = 0; nodeIndex < array.length; nodeIndex++) {  
            nodeList.add(new TreeNode(array[nodeIndex]));  
        }  
        // 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
        for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {  
            // 左孩子  
            nodeList.get(parentIndex).left = nodeList  
                    .get(parentIndex * 2 + 1);  
            // 右孩子  
            nodeList.get(parentIndex).right = nodeList  
                    .get(parentIndex * 2 + 2);  
        }  
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
        int lastParentIndex = array.length / 2 - 1;  
        // 左孩子  
        nodeList.get(lastParentIndex).left = nodeList  
                .get(lastParentIndex * 2 + 1);  
        // 右孩子,如果数组的长度为奇数才建立右孩子  
        if (array.length % 2 == 1) {  
            nodeList.get(lastParentIndex).right = nodeList  
                    .get(lastParentIndex * 2 + 2);  
        }  
        return nodeList.get(0);
    } 
}
