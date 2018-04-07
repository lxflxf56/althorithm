package offer2;
//输入一个复杂链表（每个节点中有节点值，以及两个指针，一
// 个指向下一个节点，另一个特殊指针指向任意一个节点），
// 返回结果为复制后复杂链表的head。
// （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

//原node。next=新node，新node。next=原node。next，如此复制
//新node。random=原node。random。next
//新node。next=新node。next。next
public class RandomListNodeClone {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public  RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead==null)
            return pHead;
        RandomListNode nowNode=pHead;

        //新建
        while (nowNode!=null){
            RandomListNode newNode=new RandomListNode(nowNode.label);
            newNode.next=nowNode.next;
            nowNode.next=newNode;
            nowNode=newNode.next;
        }

        //random
        nowNode=pHead;
        RandomListNode root=pHead.next;
        while (nowNode!=null){
            RandomListNode newNode=nowNode.next;
            if (nowNode.random!=null){
                newNode.random=nowNode.random.next;
            }
            nowNode=newNode.next;
        }

        //新连接
        nowNode=pHead;
        while (nowNode!=null){
            RandomListNode newNode=nowNode.next;
            nowNode.next=newNode.next;
            if (newNode.next!=null){
                nowNode=newNode.next;
                newNode.next=nowNode.next;
            }else break;

        }
        return root;


    }


    public RandomListNode init(){
        RandomListNode a1=new RandomListNode(1);
        RandomListNode a2=new RandomListNode(2);
        RandomListNode a3=new RandomListNode(3);
        a1.next=a2;
        a2.next=a3;
        a3.random=a1;
        return a1;
    }
    public static void main(String[] args) {
        RandomListNodeClone clone=new RandomListNodeClone();
        RandomListNode a=clone.init();
        clone.Clone(a);



    }
}
