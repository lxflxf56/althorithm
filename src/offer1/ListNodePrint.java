package offer1;

import java.util.ArrayList;
import java.util.Stack;

//输入一个链表，从尾到头打印链表每个节点的值。
public class ListNodePrint {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack=new Stack<>();
        while(listNode!=null){
            stack.push(listNode);
            listNode=listNode.next;
        }
        ArrayList<Integer> arrayList=new ArrayList<>();
        while (!stack.empty()){
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }



    public class ListNode {

        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }

    }
}
