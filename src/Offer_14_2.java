/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 */
public class Offer_14_2 {
    public int cuttingRope(int n) {
        if (n < 4)
            return n - 1;
        int a = n / 3;
        int b = n % 3;
        long res = 1;
        int p = 1000000007;
        for (int i = 1; i < a; i++){
            res = (res * 3 % p);
        }
        if (b == 1){
            res = (res * 4 % p);
        }else if (b == 2){
            res = (res * 6 % p);
        }else {
            res = (res * 3 % p);
        }
        return (int) res;
    }



//    public int cuttingRope(int n) {
//        if (n <= 3)
//            return n - 1;
//        int count = n / 3;
//        int last = n % 3;
//        int p = 1000000007;
//        long res = 1;//这里必须用long
//        for (int i = 1; i < count; i++){
//            res = res * 3 % p;
//        }
//        if (last == 0){
//            return (int) (res * 3 % p);//这里必须加括号(res * 3 % p)
//        }else if (last == 1){
//            return (int) (res * 4 % p);
//        }else {
//            return (int) (res * 6 % p);
//        }
//    }
}