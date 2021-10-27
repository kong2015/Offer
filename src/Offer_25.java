/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 */
public class Offer_25 {
}

class Solution {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while(l1 != null || l2 != null){
            if (l1 != null && l2 == null){
                cur.next = l1;
                break;
            }else if (l1 == null && l2 != null){
                cur.next = l2;
                break;
            }else if (l1.val <= l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if (l1.val <= l2.val)
            l1.next = mergeTwoLists(l1.next,l2);
        if (l1.val > l2.val)
            l2.next = mergeTwoLists(l1,l2.next);
        return l1.val <= l2.val ? l1 : l2;
    }
}
