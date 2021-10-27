import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 */
public class Offer_37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "[]";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuffer res = new StringBuffer();
        res.append("[");
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                res.append(node.val);
                res.append(",");
            }else {
                res.append("null,");
            }
            if (node != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return res.deleteCharAt(res.lastIndexOf(",")).append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")){
            return null;
        }
        String[] splits = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (splits[i].equals("null")){
                node.left = null;
            }else {
                node.left = new TreeNode(Integer.parseInt(splits[i]));
            }
            if (node.left != null){
                queue.offer(node.left);
            }
            i++;
            if (splits[i].equals("null")){
                node.right = null;
            }else {
                node.right = new TreeNode(Integer.parseInt(splits[i]));
            }
            i++;
            if (node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }
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
public class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return "[]";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuffer res = new StringBuffer("[");
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                res.append(node.val + ",");
            }else {
                res.append("null,");
            }
            if (node != null){
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        res.deleteCharAt(res.length() - 1).append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]"))
            return null;
        String[] newDatas = data.substring(1,data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(newDatas[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (!newDatas[i].equals("null")){
                node.left = new TreeNode(Integer.parseInt(newDatas[i])) ;
                queue.offer(node.left);
            }
            i++;
            if (!newDatas[i].equals("null")){
                node.right = new TreeNode(Integer.parseInt(newDatas[i]));
                queue.offer(node.right);
            }
            i++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));