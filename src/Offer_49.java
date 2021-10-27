/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */ szc
public class Offer_49 {
    public int nthUglyNumber(int n) {
        //丑数 = （2、3、5）* 一个较小的丑数
        int a = 0;
        int b = 0;
        int c = 0;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++){
            res[i] = Math.min(2 * res[a], Math.min(3 * res[b], 5 *res[c]));
            if (2 * res[a] == res[i]) a++;
            if (3 * res[b] == res[i]) b++;
            if (5 * res[c] == res[i]) c++;
        }
        return res[n - 1];
    }





    public int nthUglyNumber(int n) {
        int[] res = new int [n];
        res[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++){
            res[i] = Math.min(2 * res[a], Math.min(3 * res[b], 5 * res[c]));
            if (res[i] == 2 * res[a]) a++;
            if (res[i] == 3 * res[b]) b++;
            if (res[i] == 5 * res[c]) c++;
        }
        return res[n - 1];
    }
}
