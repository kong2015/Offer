/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * [0,1,3]
 */
public class Offer_53_2 {
}
class Solution {
    public int missingNumber(int[] nums) {
        return binaryS(nums, 0, nums.length - 1);
    }
    private int binaryS(int[] nums, int left, int right){
        if (left > right){
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == mid){
            return binaryS(nums, mid + 1, right);
        }else {
            return binaryS(nums, left, mid - 1);
        }
    }




    public int missingNumber(int[] nums){
        return binary(nums, 0 , nums.length - 1);
    }
    private int binary(int[] nums, int left, int right){
        if (left > right){
            return left;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] <= mid){
            return binary(nums, mid + 1, right);
        }else {
            return binary(nums, left, mid  - 1);
        }
    }
}
