/**
 * 统计一个数字在排序数组中出现的次数。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class Offer_53_1 {
}
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1) - binarySearch(nums, target - 1, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int target, int l, int r){
        if (l > r)
            return l;//返回左边（已经越过边界）
        int mid = l + (r - l) / 2;
        if (nums[mid] <= target){
            return binarySearch(nums, target, mid + 1, r);
        }else{
            return binarySearch(nums, target, l, mid - 1);
        }
    }
}