package offer3;
/*在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
重复的结点不保留，返回链表头指针。
例如，链表1->2->3->3->4->4->5 处理后为 1->2->5*/
public class DeleteDuplicationT {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode first=new ListNode(-1);
        first.next=pHead;
        ListNode p1=first;
        ListNode p2=pHead;
        while (p2!=null&&p2.next!=null){
            int val=p2.val;
            if (val==p2.next.val){
                p2=p2.next;
                while (p2!=null&&p2.val==val){
                    p2=p2.next;
                }
                p1.next=p2;
            }else {
                p1=p2;
                p2=p2.next;
            }

        }
        return first.next;

    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
