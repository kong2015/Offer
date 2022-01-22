/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class Offer_56_1 {
    public int[] singleNumbers(int[] nums) {
        int n = 0;
        for (int num : nums){
            n ^= num;
        }
        int m = 1;
        //若 a \& 0001 = 1a&0001=1 ，则 aa 的第一位为 1 ；
        //若 a \& 0010 = 1a&0010=1 ，则 aa 的第二位为 1 ；
        while ((n & m) == 0){
            m <<= 1;
        }
        int x = 0, y = 0;
        for (int num : nums){
            if ((num & m) == 0){//(num & m) == 1是错误的，位运算不是非0即1的。 5&4=4
                x ^= num;
            }else {
                y ^= num;
            }
        }
        return new int[] {x,y};
    }

    //    public int[] singleNumbers(int[] nums) {
//        int res = 0;
//        for (int num : nums) {
//            res ^= num;
//        }
//        int a = 1;
//        while ((a & res) == 0){
//            a <<= 1;
//        }
//        int x = 0;
//        int y = 0;
//        for (int num : nums) {
//            if ((num & a) == 0){
//                x ^= num;
//            }else {
//                y ^= num;
//            }
//        }
//        return new int[]{x, y};
//    }
}

