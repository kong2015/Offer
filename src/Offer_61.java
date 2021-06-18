import java.util.HashSet;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14
 */
public class Offer_61 {
    public boolean isStraight(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int min = 14, max = 0;
        for (int num : nums){
            if (num != 0){
                if (set.contains(num)){
                    return false;
                }else {
                    set.add(num);
                }
            }
            max = Math.max(num, max);
            min = Math.min(num, min);
        }
        return max - min < 5;
    }
}
