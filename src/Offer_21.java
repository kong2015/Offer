/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 */
public class Offer_21 {
}
class Solution {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[0];
        int left = 0;
        int right = nums.length - 1;
        int temp;
        while (left < right){
            while (left <= right && nums[left] % 2 == 1){
                left++;
            }
            while (left <= right && nums[right] % 2 == 0){
                right--;
            }
            if (left > right)
                break;
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }





//    public int[] exchange(int[] nums) {
//        if (nums == null ||nums.length == 0)
//            return new int[0];
//        int i = 0, j = nums.length - 1;
//        while (i < j){
//            while (i < j && nums[i] % 2 == 1){
//                i++;
//            }
//            while (i < j && nums[j] % 2 == 0){
//                j--;
//            }
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//            i++;
//            j--;
//        }
//        return nums;
//    }
}
