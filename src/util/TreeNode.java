package util;

import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }


    public static ArrayList<Integer> preorderTraversal(TreeNode root) {//前序遍历迭代法
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
        return list;
    }


    public static ArrayList<Integer> postorderTraversal(TreeNode root) {//后序遍历迭代法，递归在offer1
        TreeNode p = root, r = null;        //P记录当前节点，r用来记录上一次访问的节点
        Stack<TreeNode> s = new Stack<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(p != null || !s.isEmpty()) {
            if(p != null) {     //左孩子一直入栈，直到左孩子为空
                s.push(p);
                p = p.left;
            } else {
                p = s.peek();
                p = p.right;
                if(p != null && p != r) {   //如果栈顶元素的右孩子不为空，且未被访问过
                    s.push(p);              //则右孩子进栈，然后重复左孩子一直进栈直到为空的过程
                    p = p.left;
                } else {
                    p = s.pop();            //否则出栈，访问，r记录刚刚访问的节点
                    list.add(p.val);
                    r = p;
                    p = null;
                }
            }
        }
        return list;
    }
}
