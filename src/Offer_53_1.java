import javax.lang.model.type.ErrorType;
import java.lang.annotation.Target;

/**
 * 统计一个数字在排序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class Offer_53_1 {
}
class Solution {
    public int search(int[] nums, int target) {
        return binaryS(nums, target,0, nums.length - 1) - binaryS(nums, target - 1, 0, nums.length - 1);
    }
    private int binaryS(int[] nums, int target, int left, int right){
        if (left > right){
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] <= target){
            return binaryS(nums, target, mid + 1, right);
        }else {
            return binaryS(nums, target, left, mid - 1);
        }
    }


//寻找大于一个数的最小索引 [5,7,7,8,8,10]
    public int search(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target) - binary(nums, 0, nums.length - 1, target - 1);
    }
    private int binary(int[] nums, int left, int right, int target){
        if (left > right){
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] <= target){
            return binary(nums, mid + 1, right, target);
        }else {
            return binary(nums, left, mid - 1,target);
        }
    }
}