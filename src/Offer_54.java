/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class Offer_54 {
}

class Solution {
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
            res =  node.val;
            return;
        }
        inOrderReverse(node.left, k);
    }
}
