/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */
public class Offer_49 {
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
