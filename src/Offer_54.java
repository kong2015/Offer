import javax.swing.tree.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Offer_54 {
}

class Solution {
    int res;
    int k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        inOrderR(root);
        return res;

    }
    private void inOrderR(TreeNode node){
        if (node == null)
            return;
        inOrderR(node.right);
        this.k--;
        if (this.k == 0){
            res = node.val;
            return;
        }
        inOrderR(node.left);
    }

    int count = 0;
    int res;
    public int kthLargest(TreeNode root, int k) {
        inOrderReverse(root, k);
        return res;
    }
    private void inOrderReverse(TreeNode node, int k){
        if (node == null)
            return;
        inOrderReverse(node.right, k);
        count++;
        if (count == k){
            res = node.val;
            return;
        }
        inOrderReverse(node.left, k);
    }
}
