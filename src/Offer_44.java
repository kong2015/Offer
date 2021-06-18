/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。
 * 在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 */
public class Offer_44 {
    public int findNthDigit(int n) {
        if (n <= 9)
            return n;
        int start = 1;
        int digit = 1;
        int count = 9;
        int a = 0, b = 0;
        while (true){
            n -= count;
            start *= 10;
            digit ++;
            count = 9 * digit * start;
            a = (n - 1) / digit;
            b = (n - 1) % digit;
            if (a < 9 * start){
                return Integer.parseInt(String.valueOf(String.valueOf(start + a).charAt(b)));
            }
        }
    }
}
