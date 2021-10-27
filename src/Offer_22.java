
/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 */
public class Offer_22 {
}
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode begin = head;
        ListNode end = head;

        for (int i = 0; i < k; i++){
            begin = begin.next;
        }
        while (begin != null){
            begin = begin.next;
            end = end.next;
        }
        return end;
    }






















//    public ListNode getKthFromEnd(ListNode head, int k) {
//        ListNode former = head, latter = former;
//        int i = 0;
//        while (i != k){
//            former = former.next;
//            i++;
//        }
//        while (former != null){
//            former = former.next;
//            latter = latter.next;
//        }
//        return latter;
//    }
}