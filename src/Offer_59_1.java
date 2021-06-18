import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Offer_59_1 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1 - k, j = 0; j < nums.length; i++,j++){
            if (i >= 1 && deque.peekFirst() == nums[i - 1]){
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[j] > deque.peekLast()){//注意此时应该从队列尾部向前判断
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        int [] nums = {1,3,1,2,0,5};
        maxSlidingWindow(nums,3);
    }
}
