/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class Offer_39 {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0){
                res = num;
            }
            if (num == res){
                count++;
            }else {
                count--;
            }
        }
        return res;
    }








    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0){
                res = num;
            }
            if (res == num){
                count++;
            }else {
                count--;
            }
        }
        return res;
    }
}
