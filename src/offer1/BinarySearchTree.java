package offer1;

import java.util.Arrays;

//二叉查找树
public class BinarySearchTree {
    public static void main(String args[]){
        BinaryTreeNode rootNode=new BinaryTreeNode(4);
        int[] tmp= Tools.readArrInt("5 7 10 2 3 -1 -2 1");
        for(int i:tmp){
            rootNode.add(i);
        }
        rootNode.searchNode(new BinaryTreeNode(3));
        BinaryTreeNode tmp1= BinaryTreeNode.searchMaxDeep(rootNode);
        System.out.println("max:"+tmp1.getData());
        tmp1= BinaryTreeNode.searchMinBreadthfirst(rootNode);
        System.out.println("min:"+tmp1.getData());
        BinaryTreeNode.preOrderTraversal(rootNode);
        System.out.println();
        BinaryTreeNode.inOrderTraversal(rootNode);
        int[] pre= Tools.readArrInt("1 2 3 4 5 6 7");
        int[] in= Tools.readArrInt("3 2 4 1 6 5 7");
        //BinarySearchTree.reConstructBinaryTree(pre,in);
        BinarySearchTree tree=new BinarySearchTree();
        tree.reConstructBinaryTree(pre,in);


    }


    //输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
    // 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
    // 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
    // 则重建二叉树并返回。


    public  TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode rnode=null;
        rnode=reConstructBinaryTree2(rnode,pre,in);
        return rnode;
    }

    public TreeNode reConstructBinaryTree2(TreeNode node,int [] pre,int [] in){
        int root=pre[0];
        node=new TreeNode(root);
        int index= BinarySearchTree.findIndex(in,root);

        int[] leftIn = Arrays.copyOfRange(in,0,index);
        if (index!=0){
            int[] leftPre = Arrays.copyOfRange(pre,1,leftIn.length+1);
            node.left=reConstructBinaryTree2(node.left,leftPre,leftIn);
        }
        int[] rightIn =  Arrays.copyOfRange(in,index+1,in.length);
        if (index!=in.length-1){
            int[] rightPre =  Arrays.copyOfRange(pre,leftIn.length+1,in.length);
            node.right=reConstructBinaryTree2(node.right,rightPre,rightIn);
        }
        return node;
    }

    public int[] subArray(int[] array,int start,int end){
        //int original[] = Arrays.copyOfRange(array, start, end);
        int length=end-start+1;
        int[] tmp=new int[length];
        for (int i=0;i<length;i++){
            tmp[i]=array[start];
            start++;
        }
        return tmp;
    }

    public static int findIndex(int[]array,int tag){
        for (int i=0;i<array.length;i++){
            if (array[i]==tag){
                return i;
            }
        }
        return -1;
    }


    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    }


}
