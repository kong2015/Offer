/**
 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Offer_64 {
    public int sumNums(int n) {
        int sum = 0;
        boolean b = n >= 1 && (sum += n + sumNums(n - 1)) > 0;
        return sum; //sumNums(0)时候返回了sum= 0；
    }











//    public int sumNums(int n) {
//        int sum = 0;
//        boolean res = n > 0 && (sum += sumNums(n - 1) + n) > 0;
//        return sum;
//    }
}
