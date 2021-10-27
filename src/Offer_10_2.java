/**
 *
 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 */
public class Offer_10_2 {
    public int numWays(int n) {
        if (n == 0)
            return 1;
        if (n < 3){
            return n;
        }
        int a = 1;
        int b = 1;
        int sum = 2;
        for (int i = 2; i < n; i++){
            a = b;
            b = sum;
            sum = (a + b) % 1000000007;
        }
        return sum;
    }


    public int numWays(int n) {
        int a = 1, b = 1;
        int sum;
        for (int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
