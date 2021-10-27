import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数
 */
public class Offer_51 {
}

class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        return mergeSort(nums, 0, nums.length - 1, temp);

    }
    private int mergeSort(int[] nums, int left, int right, int[] temp){
        int sum = 0;
        if (left >= right)
            return 0;
        int mid = left + (right - left) / 2;
        sum+= mergeSort(nums, left, mid, temp);
        sum+= mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] > nums[mid + 1]){
            sum += merge(nums, left, mid, right, temp);
        }
        return sum;
    }
    private int merge(int[] nums, int left, int mid, int right, int[] temp){
        int res = 0;
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++){
            if (i > mid){
                nums[k] = temp[j];
                j++;
            }else if (j > right){
                nums[k] = temp[i];
                i++;
            }else if (temp[i] > temp[j]){
                nums[k] = temp[j];
                res += mid - i + 1;
                j++;
            }else {
                nums[k] = temp[i];
                i++;
            }
        }
        return res;
    }



    public int reversePairs(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        return mergeSort2(nums, 0, nums.length-1, temp);
    }

    private int mergeSort2(int[] array, int l, int r, int[] temp){
        int res = 0;
        if (l >= r){
            return 0;
        }
        int mid = l + (r - l) / 2;
        res += mergeSort2(array, l, mid, temp);
        res += mergeSort2(array, mid + 1, r, temp);
        if (array[mid] > array[mid + 1]){
            res += merge2(array, l, mid, r, temp);
        }
        return res;
    }

    private int merge2(int[] array, int l, int mid, int r, int[] temp){
        System.arraycopy(array,l, temp, l, r-l+1);
        int i = l;
        int j = mid + 1;
        int res = 0;
        for (int k = l; k <= r; k++){
            if (i > mid){
                array[k] = temp[j];
                j++;
            }else if (j > r){
                array[k] = temp[i];
                i++;
            }else if (temp[i] <= temp[j]){ //注意这里有等号，相等的元素不能构成逆序数对。
                array[k] = temp[i];
                i++;
            }else{
                array[k] = temp[j];
                j++;
                res += mid - i + 1;
            }
        }
        return res;
    }
}