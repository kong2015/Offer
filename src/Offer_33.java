/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。
 * 假设输入的数组的任意两个数字都互不相同
 */
public class Offer_33 {
}

class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    private boolean recur(int[] postorder, int l, int r){
        if (l >= r)
            return true;
        int p = l;
        while (postorder[r] > postorder[p])
            p++;
        int temp = p;
        while (postorder[r] < postorder[p])
            p++;
        if (p != r)
            return false;
        return recur(postorder,l,temp - 1) && recur(postorder, temp, r - 1);
    }
}
