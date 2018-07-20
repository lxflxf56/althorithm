package leetcode.page1;


import util.TreeNode;

/*
* Given a binary tree, find its minimum depth.
* The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
* */
public class MinimumDepthOfBinaryTree {
    int min=Integer.MAX_VALUE;
    public int run1(TreeNode root) {
        if (root==null){
            return 0;
        }
        search(root,1);
        return min;
    }

    public int run(TreeNode root) {
        if (root==null){
            return 0;
        }
        int r=run(root.right);
        int l=run(root.left);
        if (r==0||l==0){
            return 1+r+l;
        }
        return 1+Math.min(r,l);
    }
    void search(TreeNode node, int now){
        if (node.left==null&&node.right==null){
            if (min>now){
                min=now;
                return;
            }
        }
        if (node.left!=null){
            search(node.left,now+1);
        }
        if (node.right!=null){
            search(node.right,now+1);
        }

    }



    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.right=new TreeNode(2);
        MinimumDepthOfBinaryTree binaryTree=new MinimumDepthOfBinaryTree();
        int run = binaryTree.run(node);
        System.out.println(run);
    }
}
