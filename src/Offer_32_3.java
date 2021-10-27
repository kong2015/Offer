/**
 * 请实现一个函数按照之字形顺序打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */

import javax.swing.tree.TreeNode;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer32_3 {
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;

        List<List<Integer>> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            flag = !flag;
            for (int i = size; i > 0; i--) {
                TreeNode node = queue.poll();
                if (flag)
                    list.addFirst(node.val);//addFirst
                else {
                    list.addLast(node.val);//addLast
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }






    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            LinkedList<Integer>temp = new LinkedList<>();
            flag = !flag;
            for (int i = queue.size(); i > 0; i--){
                TreeNode node = queue.poll();
                if (flag)
                    temp.addLast(node.val);
                else temp.addFirst(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}