import com.sun.source.tree.WhileLoopTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Offer_57_2 {
    public int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 2;
        int sum = 3;
        List<int[]>res = new LinkedList<>();
        while (l < r){// l = r是不可以的，因为这个时候不应该执行程序，比如2、3、4 || 4、5（但是单独一个9不可以）
            if (sum == target){
                int[] data = new int[r - l + 1];
                for (int i = l; i <= r; i++){
                    data[i - l] = i;
                }
                res.add(data);
                sum -= l;
                l++;
            }else if (sum > target){
                sum -= l;
                l++;
            }else {
                r++;
                sum += r;
            }
        }
        return res.toArray(new int[0][]);
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int sum = 3;
        int left = 1, right = 2;
        while (left < right){
            if (sum == target){
                int[] nums = new int[right - left + 1];
                for (int i = left, j = 0; i <= right; i++,j++){
                    nums[j] = i;
                }
                res.add(nums);
                right++;
                sum+=right;
            }
            if (sum < target){
                right++;
                sum += right;
            }
            if (sum > target){
                sum-=left;
                left++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
