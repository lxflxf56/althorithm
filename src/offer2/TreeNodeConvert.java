package offer2;

import java.util.Stack;

/*输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
要求不能创建任何新的结点，只能调整树中结点指针的指向。*/
public class TreeNodeConvert {
    Stack<TreeNode> stack=new Stack<>();
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return pRootOfTree;
        }
        addNode(pRootOfTree);
        TreeNode rightNode=null;
        TreeNode node=null;
        while (true){
            node=stack.pop();
            node.right=rightNode;
            if (!stack.empty()){
                node.left=stack.peek();
            }else {
                break;
            }
            rightNode=node;
        }
        node.left=null;
        return node;
    }
    public void addNode(TreeNode node){
        if (node==null){
            return;
        }
        addNode(node.left);
        stack.add(node);
        addNode(node.right);
    }

    public static void main(String[] args) {

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
