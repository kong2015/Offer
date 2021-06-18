/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 */
public class Offer_53_2 {
}
class Solution {
    public int missingNumber(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    private int binarySearch(int[] nums, int l, int r){
        if (l > r)
            return l;
        int mid = l + (r - l) / 2;
        if (nums[mid] == mid)
            return binarySearch(nums, mid + 1, r);
        else {
            return binarySearch(nums, l, mid - 1);
        }
    }
}
