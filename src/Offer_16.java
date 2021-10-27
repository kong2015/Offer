/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 */
public class Offer_16 {
}
class Solution {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        long b = n;         //Java 代码中 int32 变量 n \in [-2147483648, 2147483647]n∈[−2147483648,2147483647] ，因此当 n = -2147483648n=−2147483648 时
                            // 执行 n = -n会因越界而赋值出错。解决方法是先将 nn 存入 long 变量 bb ，后面用 bb 操作即可
        if (b < 0){
            b = -b; //  b = -n 是错误的
            x = 1 / x;
        }
        double res = 1;
        while (b > 0){
            if (b % 2 == 1)
                res = res *x;
            x = x * x;
            b = b / 2;
        }
        return res;
    }


//    public double myPow(double x, int n) {
//        if (x == 0)
//            return 0.0;
//        //Java 代码中 int32 变量 n \in [-2147483648, 2147483647]n∈[−2147483648,2147483647] ，因此当 n = -2147483648n=−2147483648 时
//        // 执行 n = -n会因越界而赋值出错。解决方法是先将 nn 存入 long 变量 bb ，后面用 bb 操作即可
//        long b = n;
//        if (b < 0){
//            b = -b;
//            x = 1 / x;
//        }
//        double res = 1.0;
//        while (b > 0){
//            if (b % 2 == 1){//if((b & 1) == 1)
//                res *= x;
//            }
//            x *= x;
//            b /= 2;//b >>= 1;
//        }
//        return res;
//    }
}
