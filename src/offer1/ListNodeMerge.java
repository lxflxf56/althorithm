package offer1;

//输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
public class ListNodeMerge {
    public ListNode Merge1(ListNode list1,ListNode list2) {//非递归错误
        if (list1==null){
            return list2;
        }else if (list2==null){
            return list1;
        }
        ListNode rootNode=null;
        ListNode myList=null;

        while (true){
            if (rootNode==null){
                if (list1.val<list2.val){
                    myList=list1;
                }else {
                    myList=list2;
                }
                rootNode=myList;
                myList.next=null;

                continue;
            }
            if (list1==null){
                myList=list2;
                break;
            }else if(list2==null){
                myList=list1;
                break;
            }else {
                if (list1.val<list2.val){
                    myList=list1;
                    list1=list1.next;
                }else {
                    myList=list2;
                    list2=list2.next;
                }
            }
            myList=myList.next;
        }
        return rootNode;

    }



    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1==null){
            return list2;
        }
        if (list2==null){
            return list1;
        }
        if (list1.val<list2.val){
            list1.next=Merge(list1.next,list2);
            return list1;
        }else{
            list2.next=Merge(list1,list2.next);
            return list2;
        }


    }
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
