package leetcode.page2;

import util.TreeNode;
import java.util.ArrayList;
/*

Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path1->2->3which represents the number123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3


The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.

Return the sum = 12 + 13 =25.
*/
public class TreeSumNumbers {
    StringBuilder builder;
    ArrayList<Integer> arrayList;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        builder=new StringBuilder();
        arrayList=new ArrayList<>();
        dfs(root);
        int sum=0;
        for (int num:arrayList){
            sum+=num;
        }
        return sum;
    }
    public void dfs(TreeNode node){
        builder.append(node.val);
        if (node.right==null&&node.left==null){
            arrayList.add(Integer.parseInt(builder.toString()));
        }else {
            if (node.left!=null){
                dfs(node.left);
            }
            if (node.right!=null){
                dfs(node.right);
            }
        }
        builder.deleteCharAt(builder.length()-1);
    }
    public static void main(String[] args) {
        //TreeSumNumbers numbers=new TreeSumNumbers();
        StringBuilder builder=new StringBuilder("asd");
        builder.deleteCharAt(builder.length()-1);
        System.out.println(builder.toString());
    }
}
