/**
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class Offer_57_1 {
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            if (nums[l] + nums[r] == target)
                return new int[]{nums[l], nums[r]};
            else if (nums[l] + nums[r] > target)
                --r;
            else ++l;
        }
        return new int[0];
    }


    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] == target){
                return new int[]{nums[left], nums[right]};
            }else if (nums[left] + nums[right] > target){
                right--;
            }else {
                left++;
            }
        }
        return new int[0];
    }
}
