package leetcode.page3;

import util.TreeNode;

/* Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.
Note:
A solution using O(n ) space is pretty straight forward. Could you devise a constant space solution?


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

The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}". */
public class RecoverTree {
    public void recoverTree(TreeNode root) {
        if (root==null){
            return;
        }
        if (root.left!=null){
            if (root.left.val>root.val){
                
            }
        }
    }
}
