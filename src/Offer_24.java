
/**
 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 */
public class Offer_24 {

}
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }



//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null){//链表典型的问题，这里一般都需要判断链表为空或者链表只有一个元素。
//            return head;//这里不能返回null
//        }
//        ListNode newHead = reverseList(head.next);
//        head.next.next = head;
//        head.next = null;//不是head = null;
//        return newHead;
//    }
//    public ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode cur = head;
//        while(cur != null){
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;//cur = cur.next 是错误的，这个时候cur.next已经指向了pre，不能向后移动。
//        }
//        return pre;
//    }
}
