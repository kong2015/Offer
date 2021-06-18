/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 */
public class Offer_56_2 {
}
class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++){
            for (int j = 0; j < 32; j++){
                count[j] += (nums[i] & 1);
                nums[i] >>= 1;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++){
            res <<= 1;
            res |= count[31 - i] % 3;//这里res = count[31 - i];是错误的，不能赋值，只能使用位操作（向左移）。
        }
        return res;
    }
}

