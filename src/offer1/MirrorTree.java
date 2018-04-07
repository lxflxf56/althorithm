package offer1;

import java.util.Stack;

//操作给定的二叉树，将其变换为源二叉树的镜像。
public class MirrorTree {
    TreeNode nowNode=null;
    Stack<TreeNode> stack=new Stack<>();
    public void Mirror(TreeNode root) {
        if (root!=null)
            stack.add(root);
        while (!stack.empty()){
            nowNode=stack.pop();
            TreeNode tmp=nowNode.left;
            nowNode.left=nowNode.right;
            nowNode.right=tmp;
            if (nowNode.left!=null){
                stack.add(nowNode.left);
            }
            if (nowNode.right!=null){
                stack.add(nowNode.right);
            }

        }
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
