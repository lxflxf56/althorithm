package offer1;

//输入一个链表，反转链表后，输出链表的所有元素。
public class ReverseListT {
    public ListNode ReverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        /*ListNode l1=head,l2=head.next;
        l1.next=null;
        l2.next=l1;
        while(head.next!=null){
            l1=head;
            l2=head.next;
            l2.next=l1;
            head=head.next;
        }*/
        ListNode l1=new ListNode(head.val);
        ListNode l2=new ListNode(head.next.val);
        l1.next=null;
        l2.next=l1;
        head=head.next;
        while (head.next!=null){
            l1=l2;
            l2=new ListNode(head.next.val);
            l2.next=l1;
            head=head.next;
        }
        return l2;

    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
