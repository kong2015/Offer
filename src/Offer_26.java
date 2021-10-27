import javax.swing.tree.TreeNode;
import java.security.PrivateKey;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Offer_26 {
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
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    private boolean recur(TreeNode A, TreeNode B){
        if (B == null)//这里需要优先判断是否为true。（当A和B都是null）
            return true;
        if (A == null) {
            return false;
        }
        if (A.val != B.val)
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }



    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return recur(A,B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }
    private boolean recur(TreeNode A, TreeNode B){
        if (B == null)
            return true;
        if (A == null || A.val != B.val)
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }
}