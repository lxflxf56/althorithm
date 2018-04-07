package offer1;

//输入一个链表，输出该链表中倒数第k个结点。
public class FindKthToTailT {
    public ListNode FindKthToTail(ListNode head,int k) {
        int step=computeDeep(head)-k;
        for (int i=0;i<step;i++){
            head=head.next;
        }
        return head;

    }


    public int computeDeep(ListNode head){
        int sum=1;
        while (head.next!=null){
            head=head.next;
            sum++;
        }
        return sum;
    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
