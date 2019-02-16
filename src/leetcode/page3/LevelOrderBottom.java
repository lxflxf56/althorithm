package leetcode.page3;

import util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values.
(ie, from left to right, level by level from leaf to root).

For example:
Given binary tree{3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7


return its bottom-up level order traversal as:

[
  [15,7]
  [9,20],
  [3],
]


confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5

The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".

*/
public class LevelOrderBottom {

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<>();
        if (root==null){
            return arrayLists;
        }
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        Stack<ArrayList<Integer>> stack=new Stack<>();
        queue1.add(root);
        ArrayList<Integer> arrayList;
        while (!queue1.isEmpty()||!queue2.isEmpty()){
            arrayList=new ArrayList<>();
            while (!queue1.isEmpty()){
                TreeNode poll = queue1.poll();
                arrayList.add(poll.val);
                if (poll.left!=null){
                    queue2.add(poll.left);
                }
                if (poll.right!=null){
                    queue2.add(poll.right);
                }
            }
            stack.add(arrayList);

            arrayList=new ArrayList<>();
            while (!queue2.isEmpty()){
                TreeNode poll = queue2.poll();
                arrayList.add(poll.val);
                if (poll.left!=null){
                    queue1.add(poll.left);
                }
                if (poll.right!=null){
                    queue1.add(poll.right);
                }
            }
            stack.add(arrayList);
        }

        while (!stack.isEmpty()){
            ArrayList<Integer> pop = stack.pop();
            if (pop.size()!=0){
                arrayLists.add(pop);
            }
        }
        return arrayLists;
    }
    public static void main(String[] args) {

    }
}
