/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [5,1,2,3,4] 和[2,3,4,5,1]为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
  */
public class Offer_11 {
}

class Solution {
    public int minArray(int[] numbers) {
        return binarySearch(numbers, 0, numbers.length - 1);
    }
    private int binarySearch(int[] nums, int l, int r){
        if (l > r)
            return nums[l];
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[r]){
            return binarySearch(nums, mid + 1, r);
        }else if (nums[mid] < nums[r]){
            return binarySearch(nums, l, mid);
        }else {
            return binarySearch(nums, l, --r);
        }
    }
}