package offer3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*请实现一个函数按照之字形打印二叉树，
即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
第三行按照从左到右的顺序打印，其他行以此类推*/
public class PrintNode {

    /*
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> leftQueue=new LinkedList<>();
        Queue<TreeNode> rightQueue=new LinkedList<>();
        ArrayList<ArrayList<Integer>> all=new ArrayList<>();
        leftQueue.add(pRoot);
        boolean left=true;
        TreeNode node;
        while (!leftQueue.isEmpty()||!rightQueue.isEmpty()){

            if (left){
                if (leftQueue.isEmpty()){
                    left=false;
                    continue;
                }
                node=leftQueue.poll();
                rightQueue.add(node.right);
                rightQueue.add(node.left);
            }else {
                if (rightQueue.isEmpty()){
                    left=true;
                    continue;
                }
                node=rightQueue.poll();



            }
        }



    }*/

    public ArrayList<ArrayList<Integer> > Print(TreeNode node) {

        Stack<TreeNode> leftStack=new Stack<>();
        Stack<TreeNode> rightStack=new Stack<>();
        ArrayList<ArrayList<Integer>> all=new ArrayList<>();
        if (node==null){
            return all;
        }
        boolean left=true;
        ArrayList<Integer> arrayList=new ArrayList<>();
        leftStack.add(node);
        while (!leftStack.empty()||!rightStack.empty()){
            if (left){
                if (leftStack.empty()){
                    left=false;
                    all.add(arrayList);
                    arrayList=new ArrayList<>();
                    continue;
                }
                node=leftStack.pop();
                arrayList.add(node.val);
                if (node.left!=null)
                    rightStack.add(node.left);
                if (node.right!=null)
                    rightStack.add(node.right);
            }else {
                if (rightStack.empty()){
                    left=true;
                    all.add(arrayList);
                    arrayList=new ArrayList<>();
                    continue;
                }
                node=rightStack.pop();
                arrayList.add(node.val);
                if (node.right!=null)
                    leftStack.add(node.right);
                if (node.left!=null)
                    leftStack.add(node.left);
            }
        }
        all.add(arrayList);
        return all;
    }


    public PrintNode(){
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        TreeNode node1=node.left;
        node1.left=new TreeNode(4);
        node1.right=new TreeNode(5);
        Print(node);
    }


    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {
        PrintNode node=new PrintNode();
    }
}
