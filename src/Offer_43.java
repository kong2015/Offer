/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *

 */
public class Offer_43 {

    public int countDigitOne(int n) {
        if (n <= 0)
            return 0;
        int temp = n;
        int pow = 1;
        while (n > 9){
            n /= 10;
            pow *= 10;
        }
        int high = n;
        int last = temp - high * pow;

        if (high == 1){
            return last + 1 + countDigitOne(last) + countDigitOne(pow - 1);
        }else {
            return countDigitOne(last) + pow + high * countDigitOne(pow - 1);
        }
    }

//    public int countDigitOne(int n) {
//        return dfs(n);
//    }
//    private int dfs(int n){
//        if (n <= 0){
//            return 0;
//        }
//        String s = String.valueOf(n);
//        int high = Integer.parseInt(String.valueOf(s.charAt(0)));//int high = s.charAt(0) - '0';
//        int pow = (int) Math.pow(10, s.length() - 1);
//        int last = n - high * pow;
//        if (high == 1){
//            return last + 1 + dfs(last) + dfs(pow - 1);
//        }else {
//            return high * dfs(pow - 1) + pow + dfs(last);
//        }
//    }
}
