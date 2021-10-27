import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 */
public class Offer_17 {
    int[] res;
    int count = 0;
    public int[] printNumbers(int n) {
        res = new int[(int) (Math.pow(10, n) - 1)];
        for (int j = 1; j <= n; j++){
            char[] chars = new char[j];
            for (char i = '1'; i <= '9'; i++){
                chars[0] = i;
                dfs1(1, chars);
            }
        }
        return res;
    }
    private void dfs1(int i, char[] chars){
        if (i == chars.length){
            res[count++] = Integer.parseInt(String.valueOf(chars));
            return;
        }
        for (char c = '0'; c <= '9'; c++){
            chars[i] = c;
            dfs1(i + 1, chars);
        }
    }


    //这种方法定义了res是list，难以直接转换为数组，耗费时间
//    int n;
//    List<Integer> res = new ArrayList<>();
//    public int[] printNumbers(int n) {
//        for (int j = 1; j <= n; j++){
//            char[] c = new char[j];
//            for (char i = '1'; i <= '9'; i++){
//                c[0] = i;
//                dfs(1, c);
//            }
//        }
//        int[] result = new int[res.size()];
//        for (int i = 0; i < result.length; i++){
//            result[i] = res.get(i);
//        }
//        return result;
//    }
//    //遍历第x个位置的元素
//    private void dfs(int x, char[] c){
//        if (x == c.length){
//            res.add(Integer.parseInt(String.valueOf(c)));
//            return;
//        }
//        for (char i = '0'; i <= '9'; i++){
//            c[x] = i;
//            dfs(x + 1, c);
//        }
//    }


//    所以考虑直接定义数组存放结果，避免转换
    int[] res;
    int count;
    public int[] printNumbers(int n) {
        res = new int[(int) Math.pow(10, n) - 1];
        for (int j = 1; j <= n; j++){
            char[] c = new char[j];
            for (char i = '1'; i <= '9'; i++){
                c[0] = i;
                dfs(1, c);
            }
        }
        return res;
    }
    //遍历第x个位置的元素
    private void dfs(int x, char[] c){
        if (x == c.length){
            res[count++] = Integer.parseInt(String.valueOf(c));
            return;
        }
        for (char i = '0'; i <= '9'; i++){
            c[x] = i;
            dfs(x + 1, c);
        }
    }
}
