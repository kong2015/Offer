import java.util.HashMap;
import java.util.Map;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字
 *
 * 解法1： 直接哈希表统计：看哪一个键的值是1；
 * 解法2： 位运算
 * 解法3： 排序法：取前后均不相同的一个索引对应的数值
 */
public class Offer_56_2 {
}
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet()){
            if (e.getValue() == 1)
                return e.getKey();
        }
//        for (int num : nums){
//            if (map.get(num) == 1){
//                return num;
//            }
//        }
        return -1;
    }

//    public int singleNumber(int[] nums) {
//        Arrays.sort(nums);
//        if (nums[0] != nums[1]) return nums[0];
//        int n = nums.length;
//        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];
//        for (int i = 1; i < n; i++){
//            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1])
//                return nums[i];
//        }
//        return -1;
//    }


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

