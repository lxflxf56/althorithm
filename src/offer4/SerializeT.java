package offer4;
/*
二叉树序列化
 1. 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点
不为空时，在转化val所得的字符之后添加一个' ， '作为分割。对于空节点则以 '#' 代替。
 2. 对于反序列化：按照前序顺序，递归的使用字符串中的字符创建一个二叉树(特别注意：
在递归时，递归函数的参数一定要是char ** ，这样才能保证每次递归后指向字符串的指针会
随着递归的进行而移动！！！)
*/
public class SerializeT {
    StringBuilder builder;
    String Serialize(TreeNode root) {
        builder=new StringBuilder();
        add(root);
        return builder.toString();
    }

    private void add(TreeNode node){
        if (node==null){
            builder.append("#,");
        }else {
            builder.append(node.val+",");
            add(node.left);
            add(node.right);
        }
    }
    String[] strs;
    int index=-1;
    TreeNode Deserialize(String str) {
        strs=str.split(",");
        return set();
    }
    private TreeNode set(){
        index++;
        if (index>=strs.length){
            return null;
        }
        if ("#".equals(strs[index])){
            return null;
        }
        TreeNode node=new TreeNode(Integer.parseInt(strs[index]));

        node.left=set();
        node.right=set();
        return node;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    SerializeT(){
        TreeNode node=new TreeNode(1);
        TreeNode node2=new TreeNode(2);
        TreeNode node3=new TreeNode(3);
        TreeNode node4=new TreeNode(4);
        TreeNode node5=new TreeNode(5);
        TreeNode node6=new TreeNode(6);
        node.left=node2;
        node2.left=node4;
        node2.right=node5;
        node5.right=node6;
        node.right=node3;
        String str=Serialize(node);
        TreeNode node1=Deserialize(str);
    }
    public static void main(String[] args) {
        new SerializeT();
    }
}
