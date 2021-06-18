import java.util.ArrayList;

/**
 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class Offer_57_2 {
    public int[][] findContinuousSequence(int target) {
        int i = 1, j = 2;
        int sum = 3;
        ArrayList<int[]> list = new ArrayList<>();
        while (i < j){
            if (sum == target){
                int[] element = new int[j - i +1];
                for (int k = i; k <= j; k++){
                    element[k - i] = k;
                }
                list.add(element);
            }
            if (sum >= target){//假设执行完上面的等号代码块，仍需寻找下一组满足条件的序列，此时应该让左边界加一。所以这个if和上面的if并不是互斥。
                sum -= i;
                i++;
            }else {
                j++;
                sum +=j;
            }
        }
        return list.toArray(new int[0][]);
    }
}
