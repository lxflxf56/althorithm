package offer1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//二叉树节点
public class BinaryTreeNode {
    private BinaryTreeNode rigthNode=null;
    private BinaryTreeNode leftNode=null;
    private boolean haveLeftNode;
    private boolean haveRightNode;
    private BinaryTreeNode rootNode;
    private int data;


    public boolean isHaveLeftNode(){
        return haveLeftNode;
    }
    public boolean isHaveRightNode(){
        return haveRightNode;
    }

    public int getData() {
        return data;
    }

    public BinaryTreeNode(int data){
        rootNode=this;
        haveLeftNode=false;
        haveRightNode=false;
        this.data=data;
    }





    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public BinaryTreeNode getRigthNode() {
        return rigthNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        if (!rootNode.haveLeftNode){
            rootNode.haveLeftNode=true;
        }

        rootNode.leftNode = leftNode;
        rootNode=this;
    }

    public void setRigthNode(BinaryTreeNode rigthNode) {
        if (!rootNode.haveRightNode){
            rootNode.haveRightNode=true;
        }
        rootNode.rigthNode = rigthNode;
        rootNode=this;
    }
    private void setSearchRightNode(BinaryTreeNode node){
        if (!rootNode.haveRightNode){
            setRigthNode(node);
        }else {
            rootNode=rootNode.rigthNode;
            selectSetNode(node);
        }
    }

    private void selectSetNode(BinaryTreeNode node){
        int nodeData=node.getData();
        if (nodeData==rootNode.data){
            rootNode=this;
            return;
        }
        if (nodeData<rootNode.data){
            setSearchLeftNode(node);
        }else {
            setSearchRightNode(node);
        }
    }

    private void setSearchLeftNode(BinaryTreeNode node){
        if (!rootNode.haveLeftNode){
            setLeftNode(node);
        }else {
            rootNode=rootNode.leftNode;
            selectSetNode(node);
        }
    }

    public void add(int tmpData){//二叉查找树添加
        BinaryTreeNode node=new BinaryTreeNode(tmpData);
        selectSetNode(node);
    }

    public  void searchNode(BinaryTreeNode node){
        int nodeData=node.getData();
        if (nodeData==rootNode.data){
            System.out.println(" found");
            return;
        }
        if (nodeData<rootNode.data){
            System.out.print("left ");
            if (rootNode.isHaveLeftNode()){
                rootNode=rootNode.leftNode;
                searchNode(node);
            }else {
                System.out.println("No found");
                return;
            }
        }else {
            System.out.print("right ");
            if (rootNode.isHaveRightNode()){
                rootNode=rootNode.rigthNode;
                searchNode(node);
            }else {
                System.out.println("No found");
                return;
            }
        }


    }

    /*
    public BinaryTreeNode searchMaxDeep(BinaryTreeNode node,BinaryTreeNode tmpMax){//深度搜索max  非二叉搜索树(递归)

        return tmpMax;
    }*/

    public static BinaryTreeNode searchMaxDeep(BinaryTreeNode node){//深度搜索max  非二叉搜索树(栈)
        Stack<BinaryTreeNode> stack=new Stack<>();
        BinaryTreeNode max=node;
        stack.push(node);
        while (!stack.empty()){
            node=stack.pop();
            if (node.isHaveLeftNode()){
                stack.push(node.getLeftNode());
            }
            if (node.isHaveRightNode()){
                stack.push(node.getRigthNode());
            }
            int data=node.getData();
            System.out.print(data+" ");
            if (max.data<data){
                max=node;
            }

        }
        System.out.println();
        return max;

    }
    public static BinaryTreeNode searchMinBreadthfirst(BinaryTreeNode node){//广度优先搜索min 非二叉搜索树
        Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
        BinaryTreeNode min=node;
        queue.add(node);
        while (!queue.isEmpty()){
            node=queue.remove();
            if (node.isHaveLeftNode()){
                queue.add(node.leftNode);
            }
            if (node.isHaveRightNode()){
                queue.add(node.rigthNode);
            }
            int data=node.getData();
            System.out.print(data+" ");
            if (min.data>data){
                min=node;
            }
        }
        System.out.println();
        return min;
    }

    public static void preOrderTraversal(BinaryTreeNode node){//先序遍历
        System.out.print(node.getData()+" ");
        if (node.isHaveLeftNode()){
            preOrderTraversal(node.getLeftNode());
        }
        if (node.isHaveRightNode()){
            preOrderTraversal(node.getRigthNode());
        }

    }

    public static void inOrderTraversal(BinaryTreeNode node){//中序遍历
        if (node.isHaveLeftNode()){
            inOrderTraversal(node.getLeftNode());
        }
        System.out.print(node.getData()+" ");
        if (node.isHaveRightNode()){
            inOrderTraversal(node.getRigthNode());
        }
    }

    public static void postorderTraversal(BinaryTreeNode node){//后序遍历
        if (node.isHaveLeftNode()){
            postorderTraversal(node.getLeftNode());
        }
        if (node.isHaveRightNode()){
            postorderTraversal(node.getRigthNode());
        }
        System.out.print(node.getData()+" ");

    }


    public static int  deep(BinaryTreeNode root){//树的深度
        if (root==null){
            return 0;
        }
        int leftDeep=deep(root.leftNode);
        int rightDeep=deep(root.rigthNode);
        if (leftDeep<rightDeep){
            return rightDeep+1;
        }else {
            return leftDeep+1;
        }
    }

    boolean isBalance;
    public  boolean isBalanced(BinaryTreeNode rootNode){//平衡二叉树
        isBalance=true;
        balanced(rootNode);
        return isBalance;
    }

    private int balanced(BinaryTreeNode rootNode){
        //后序历遍
        if (rootNode==null||!isBalance){
            return 0;
        }
        int left=balanced(rootNode.leftNode);
        int right=balanced(rootNode.rigthNode);
        if (Math.abs(left-right)>1){
            isBalance=false;
        }
        return left>right?left+1:right+1;

    }

    public static void main(String[] args) {
        BinaryTreeNode node=new BinaryTreeNode(10);
        int [] arr=Tools.readArrInt("1 11 15 9 8");
        for (int i=0;i<arr.length;i++){
            node.add(arr[i]);
        }
        node.postorderTraversal(node);


    }







}
