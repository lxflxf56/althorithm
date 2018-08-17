package leetcode.page2;

import java.util.LinkedList;
import java.util.Queue;

/*

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.

Initially, all next pointers are set toNULL.


For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7


After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL


*/
public class ConnectT {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue1=new LinkedList<>();
        Queue<TreeLinkNode> queue2=new LinkedList<>();
        queue1.add(root);
        while (!queue1.isEmpty()||!queue2.isEmpty()){
            while (!queue1.isEmpty()){
                TreeLinkNode treeLinkNode = queue1.poll();
                if (treeLinkNode!=null){
                    treeLinkNode.next=queue1.peek();
                    queue2.add(treeLinkNode.left);
                    queue2.add(treeLinkNode.right);
                }
            }

            while (!queue2.isEmpty()){
                TreeLinkNode treeLinkNode = queue2.poll();
                if (treeLinkNode!=null){
                    treeLinkNode.next=queue2.peek();
                    queue1.add(treeLinkNode.left);
                    queue1.add(treeLinkNode.right);
                }
            }
        }
        return;
    }


    public class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
    }
}
