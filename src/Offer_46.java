/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class Offer_46 {
    public int translateNum(int num) {
        int res1 = 1;
        int res2 = 1;
        int a;
        int b;
        int sum;
        while (num != 0){
            b = num % 10;
            num /= 10;
            a = num % 10;
            sum = (a * 10 + b) < 26 && (a * 10 + b) > 9 ? res1 + res2 : res2;
            res1 = res2;
            res2 = sum;
        }
        return res1;
    }



    public int translateNum(int num) {
        int a = 1;
        int b = 1;
        int res;
        int rem2, rem1 = num % 10;
        while (num != 0){
            num /= 10;
            rem2 = num % 10;
            int digit = rem2 * 10 + rem1;
            res = digit < 26 && digit > 9 ? a + b : b;
            a = b;
            b = res;
            rem1 = rem2;
        }
        return b;
    }
}
