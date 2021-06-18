/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次
 */
public class Offer_43 {
    public int countDigitOne(int n) {
        return dfs(n);
    }
    private int dfs(int n){
        if (n <= 0){
            return 0;
        }
        String s = String.valueOf(n);
        int high = Integer.parseInt(String.valueOf(s.charAt(0)));//int high = s.charAt(0) - '0';
        int pow = (int) Math.pow(10, s.length() - 1);
        int last = n - high * pow;
        if (high == 1){
            return last + 1 + dfs(last) + dfs(pow - 1);
        }else {
            return high * dfs(pow - 1) + pow + dfs(last);
        }
    }
}
