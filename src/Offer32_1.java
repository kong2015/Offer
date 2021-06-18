import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 */
public class Offer32_1 {
}

class Solution {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer>list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i <res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }
}
