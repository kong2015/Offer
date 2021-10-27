import javax.swing.tree.TreeNode;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Offer_55_1 {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

    }

    int max = 0;
    int depth = 0;
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }
    private void dfs(TreeNode node){
        if (node == null)
            return;
        depth += 1;
        maxDepth(root.left);
        maxDepth(root.right);
        max = Math.max(max, depth);
        depth -= 1;
    }
}