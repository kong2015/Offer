import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 前序遍历 preorder = [3,9,1,20,15,7]
 * 中序遍历 inorder = [9,1,3,15,20,7]
 */
public class Offer_7 {
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return recur(preorder, 0, 0, inorder.length - 1);
    }
    private TreeNode recur(int[] preorder, int rootIndex, int left, int right){
        if (left > right)//当指向同一个元素的需要执行下面的增加节点过程。所以不能使用等号.
            return null;
        int e = preorder[rootIndex];
        Integer index = map.get(e);
        TreeNode root = new TreeNode(e);
        root.left = recur(preorder, rootIndex + 1, left, index - 1);
        root.right = recur(preorder, rootIndex + index - left + 1,index + 1, right);
        return root;
    }


//    HashMap<Integer, Integer> map = new HashMap<>();
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for (int i = 0; i < inorder.length; i++){
//            map.put(inorder[i], i);
//        }
//        return recur(preorder,0, 0 , inorder.length - 1);//root为前序遍历中的根节点索引，left和right为中序遍历中的左子树和右子树的边界。
//    }
//    private TreeNode recur(int[] preOrder, int root, int left, int right){
//        if (left > right)
//            return null;
//        int i = map.get(preOrder[root]);
//        TreeNode node = new TreeNode(preOrder[root]);
//        node.left = recur(preOrder, root + 1, left, i - 1);
//        node.right = recur(preOrder, root + i - left + 1, i + 1, right);
//        return node;
//    }
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
