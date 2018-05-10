package offer4;
//给定一颗二叉搜索树，请找出其中的第k大的结点。
// 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
//中序遍历
public class KthNodeT {
    int index=0;
    int k;
    TreeNode result=null;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        this.k=k;
        order(pRoot);
        return result;
    }

    private void order(TreeNode node){
        if (node==null||index>k){
            return;
        }
        order(node.left);
        index++;
        if (k==index){
            result=node;
        }
        order(node.right);
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
