import javax.swing.tree.TreeNode;
import java.util.HashMap;
/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class Offer_7 {
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
    HashMap<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return recur(preorder,0, 0 , inorder.length - 1);//root为前序遍历中的根节点索引，left和right为中序遍历中的左子树和右子树的边界。
    }
    private TreeNode recur(int[] preOrder, int root, int left, int right){
        if (left > right)
            return null;
        int i = map.get(preOrder[root]);
        TreeNode node = new TreeNode(preOrder[root]);
        node.left = recur(preOrder, root + 1, left, i - 1);
        node.right = recur(preOrder, root + i - left + 1, i + 1, right);
        return node;
    }
}