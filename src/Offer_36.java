import org.w3c.dom.Node;


/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向
 */
public class Offer_36 {
    Node pre = null;
    Node head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        inOrder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
    private void inOrder(Node node){
        if (node == null)
            return;
        inOrder(node.left);
        if (pre == null){
            head = node;
        }else {
            pre.right = node;
        }
        node.left = pre;
        pre = node;
        inOrder(node.right);
    }



    Node pre = null, head = null;
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        inOrder(root);
        pre.right = head;
        head.left = pre;
        return head;
    }
    private void inOrder(Node cur){
        if (cur == null)
            return;
        inOrder(cur.left);
        if (pre != null){
            pre.right = cur;//第一次执行的时候pre为空
        }else{
            head = cur;//递归到二叉搜索树最小的节点时，当前节点应该就是链表的head节点，保存为成员变量。
        }//当前的判断条件应该为pre是否为空，只有这一种情况下pre为空，以后pre向后移动，永不为空。
        cur.left = pre;
        pre = cur;
        inOrder(cur.right);
    }
}