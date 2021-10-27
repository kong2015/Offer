import java.lang.invoke.CallSite;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 */
public class Offer_18 {
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode cur = dummyNode;
        while (cur.next != null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
                return dummyNode.next;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }



//    public ListNode deleteNode(ListNode head, int val) {
//        if (head == null) return head;
//        if (head.val == val) return head.next;
//        ListNode prev = head;
//        while (prev.next != null){
//            if (prev.next.val == val){
//                prev.next = prev.next.next;
//                return head;
//            }else {
//                prev = prev.next;
//            }
//        }
//        return head;
//    }
}