import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class Offer_27 {
}

class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
    //采用队列非递归实现
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();//注意这里在队列初始化的时候不能使用ArrayList
        q.offer(root);
        while (! q.isEmpty()){
            TreeNode node = q.poll();
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }
}
