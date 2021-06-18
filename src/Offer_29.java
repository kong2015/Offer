import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix == null) return new int[0];
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        int[] ret = new int[(c2+1)*(r2+1)];
        int j =0;
        while (r1 <= r2 && c1 <= c2){
            for (int i = c1; i <= c2; i++){
                ret[j++] = matrix[r1][i];
            }
            for (int i = r1 + 1; i <= r2; i++){
                ret[j++] = matrix[i][c2];
            }
            if (r1 != r2){
                for (int i = c2 - 1; i >= c1; i--){
                    ret[j++] = matrix[r2][i];
                }
            }
            if (c1 != c2){
                for (int i = r2 - 1; i > r1; i--){
                    ret[j++] = matrix[i][c1];
                }
            }
            r1++;r2--;c1++;c2--;
        }
        return ret;
    }
}
