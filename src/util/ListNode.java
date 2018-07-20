package util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode getMid(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, quick = head;
        while(quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }

    public static ListNode sortList(ListNode head) {//链表归并排序
        if (head==null||head.next==null){
            return head;
        }

        ListNode mid=getMid(head);
        ListNode right=sortList(mid.next);
        mid.next=null;
        ListNode left = sortList(head);
        return mergeTwoList(left,right);
    }
    private static ListNode mergeTwoList(ListNode left,ListNode right){
        if (left==null){
            return right;
        }
        if (right==null){
            return left;
        }
        ListNode tmp=new ListNode(0);
        ListNode head=tmp;
        while (left!=null&&right!=null){
            if (left.val>right.val){
                head.next=right;
                right=right.next;
            }else {
                head.next=left;
                left=left.next;
            }
            head=head.next;
        }
        if (left==null){
            head.next=right;
        }
        if (right==null){
            head.next=left;
        }
        return tmp.next;
    }

    public static ListNode insertionSortList(ListNode head) {//插入排序
        ListNode dumy = new ListNode(Integer.MIN_VALUE);
        ListNode cur = head;
        ListNode pre = dumy;
        while (cur != null) {
            //保存当前节点下一个节点
            ListNode next = cur.next;
            pre = dumy;
            //寻找当前节点正确位置的一个节点
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            //将当前节点加入新链表中
            cur.next = pre.next;
            pre.next = cur;
            //处理下一个节点
            cur = next;
        }
        return dumy.next;
    }


    public static ListNode detectCycle(ListNode head) {//查环，可开创空间直接用hashset（EntryNodeOfLoop），这是快慢指针
        /*
        1）同linked-list-cycle-i一题，使用快慢指针方法，判定是否存在环，并记录两指针相遇位置(Z)；
        2）将两指针分别放在链表头(X)和相遇位置(Z)，并改为相同速度推进，则两指针在环开始位置相遇(Y)。
        证明:https://www.nowcoder.com/questionTerminal/6e630519bf86480296d0f1c868d425ad
        */

        if (head==null){
            return null;
        }

        ListNode meet=meetingNode(head);

        if (meet==null){
            return null;
        }

        ListNode slow=head;
        ListNode fast=meet;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }


    private static ListNode meetingNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
