/**
 *输入两个链表，找出它们的第一个公共节点。
 */
public class Offer_52 {

}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B){
            if (A != null){
                A = A.next;
            }else {
                A = headB;
            }
            if (B != null){
                B = B.next;
            }else {
                B = headA;
            }
        }
        return A;
    }






    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B){
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}