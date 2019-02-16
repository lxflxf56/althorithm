package leetcode.page2;


import util.TreeNode;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] num) {
        if(num==null||num.length==0){
            return null;
        }
        int mid=num.length/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left=sortedArrayToBST(num,0,mid-1);
        node.right=sortedArrayToBST(num,mid+1,num.length-1);
        return node;
    }
    public static TreeNode sortedArrayToBST(int[] num,int start,int end) {
        if (start>end||start>num.length||end<0){
            return null;
        }
        int mid=(start+end+1)/2;
        TreeNode node = new TreeNode(num[mid]);
        node.left=sortedArrayToBST(num,start,mid-1);
        node.right=sortedArrayToBST(num,mid+1,end);
        return node;
    }

    public static void main(String[] args) {
        SortedArrayToBST.sortedArrayToBST(new int[]{-1,0,1,2});
    }

}
