/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class Offer_66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0)
            return new int[0];
        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i < a.length; i++){
            res[i] = res[i - 1] * a[i - 1];
        }
        int tem = 1;
        for (int i = a.length - 2; i >= 0; i--){
            tem *= a[i + 1];
            res[i] = res[i] * tem;
        }
        return res;
    }

    //超出时间限制
//    public int[] constructArr(int[] a) {
//        int[] res = new int[a.length];
//        Arrays.fill(res, 1);
//        for (int j = 0; j < a.length; j++) {
//            for (int i = 0; i < a.length; i++){
//                if (i == j){
//                    continue;
//                }
//                res[j] *= a[i];
//            }
//        }
//        return res;
//    }

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0)
            return new int[0];
        int[] res = new int[a.length];
        res[0] = 1;
        int temp = 1;
        for (int i = 1; i <= a.length - 1; i++){
            res[i] = res[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0 ; i--){
            temp *= a[i + 1];
            res[i] *= temp;
        }
        return res;
    }
}
