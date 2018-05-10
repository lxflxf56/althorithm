package offer3;
//请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
//意思是根节点的 左子树的右节点 与 根节点的 右子树的左节点 相同
public class IsSymmetricalT {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot==null)
            return true;
        boolean result=isSam(pRoot.left,pRoot.right);
        return result;
    }

    public boolean isSam(TreeNode left ,TreeNode right){
        if (left==null&&right==null){
            return true;
        }else if (left==null||right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        boolean a1=isSam(left.left,right.right);
        boolean a2=isSam(left.right,right.left);
        return a1&&a2;
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
