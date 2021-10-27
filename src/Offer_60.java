import java.util.Arrays;

/**
 *
 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 */
public class Offer_60 {
    public double[] dicesProbability(int n) {
        double[] res= new double[6];
        Arrays.fill(res, 1 / 6.0);

        for (int i = 2; i <= n; i++){ // 一个到n个的迭代
            double[] tem = new double[5 * i + 1];// 6n - n +1
            for (int j = 0; j < res.length; j++){//上一次的每一个res都可以影响六个位置
                for (int k = 0; k < 6; k++){
                    tem[j + k] += res[j] * (1 / 6.0);//上一次的基础上乘以 1/ 6
                }
            }
            res = tem;
        }
        return res;
    }



    public double[] dicesProbability(int n) {
        double[] dp = new double[6];
        Arrays.fill(dp, 1 / 6.0);
        for (int i = 2; i <= n; i ++){
            double[] tem = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++){
                for (int k = 0; k < 6; k++){
                    tem[j + k] += dp[j] * 1 / 6.0;
                }
            }
            dp = tem;
        }
        return dp;
    }
}
