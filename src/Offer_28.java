/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 */
public class Offer_28 {
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return recur(root.left, root.right);
    }
    private boolean recur(TreeNode left, TreeNode right){
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        if (left.val != right.val)
            return false;
        return recur(left.left, right.right) && recur(left.right, right.left);//注意这里是left.right, right.left构成镜像
    }
}