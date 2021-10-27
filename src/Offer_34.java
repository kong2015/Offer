import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.List;
/**
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径
 */
public class Offer_34 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int sum = 0;
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs1(root, target);
        return res;
    }
    private void dfs1(TreeNode node, int target){
        if (node == null){
            return;
        }
        sum += node.val;
        list.add(node.val);
        if (node.left == null && node.right == null && sum == target){
            res.add(new LinkedList<>(list));
        }
        dfs1(node.left, target);
        dfs1(node.right, target);
        sum -= node.val;
        list.pollLast();//poll 是错误的，这个删除的是头部的元素.
    }

//    LinkedList<Integer> list = new LinkedList<>();
//    List<List<Integer>> res = new LinkedList<>();
//    int sum = 0;
//    public List<List<Integer>> pathSum(TreeNode root, int target) {
//        dfs(root, target);
//        return res;
//    }
//    private void dfs(TreeNode node, int target){
//        if (node == null)
//            return;
//        sum += node.val;
//        list.offer(node.val);
//        if (sum == target && node.left == null && node.right == null){
//            res.add(new LinkedList<>(list));//必须新建一个对象，不然list的值一直会变
//        }
//        dfs(node.left, target);
//        dfs(node.right, target);
//        sum -= node.val;
//        list.pollLast();
//    }
}
