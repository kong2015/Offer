/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class Offer_39 {
    public int majorityElement(int[] nums) {
        int votes = 0;
        int res = 0;
        for (int num : nums) {
            if (votes == 0) {
                res = num;
            }
            votes += res == num ? 1 : -1;
        }
        return res;
    }
}
