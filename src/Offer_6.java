
/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Offer_6 {
    int size = 0;
    int[] nums;
    int index = 0;
    public int[] reversePrint(ListNode head) {
        recur(head);
        return nums;
    }
    public void recur(ListNode head){
        if (head == null){
            nums = new int[size];
            return;
        }
        size++;
        recur(head.next);
        nums[index] = head.val;
        index++;
    }


//    int[] res;
//    int i = 0;//记录总共有多少个节点，用于开辟内存
//    int j = 0;//记录当前节点索引，倒序
//    public int[] reversePrint(ListNode head) {
//        reverseNode(head);
//        return res;
//    }
//    private void reverseNode(ListNode node){
//        if (node == null){//基本问题和下面的更小的问题。
//            res = new int[i];
//            return;
//        }
//        i++;
//        reverseNode(node.next);//宏观语义：节点数加一，遍历下一个节点，将下一个节点的val放在res[j]中，然后j++。
//        res[j] = node.val;
//        j++;
//    }
}

