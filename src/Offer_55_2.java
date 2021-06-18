/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树
 */
public class Offer_55_2 {
}
//层序遍历
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        return Math.abs(recur(root.left) - recur(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    private int recur(TreeNode node){
        if (node == null)
            return 0;
        return 1 + Math.max(recur(node.left), recur(node.right));
    }
}
//深度优先遍历
class Solution {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }
    private int recur(TreeNode node){
        if (node == null)
            return 0;
        int left = recur(node.left);
        if (left == -1)
            return -1;
        int right = recur(node.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1: -1;
    }
}
