package offer2;
//输入两个链表，找出它们的第一个公共结点。
public class FindFirstCommonNodeT {



    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;

        while (p1!=null){
            ListNode p2=pHead2;
            while (p2!=null){
                if (p1==p2){
                    return p1;
                }
                p2=p2.next;
            }
            p1=p1.next;
        }
        return p1;

    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {//似乎此算法时间效率更高
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=p2){
            if (p1!=null){
                p1=p1.next;
            }else {
                p1=pHead2;
            }
            if (p2!=null){
                p2=p2.next;
            }else {
                p2=pHead1;
            }
        }
        return p1;
    }


    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
