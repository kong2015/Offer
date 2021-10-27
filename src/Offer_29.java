/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
public class Offer_29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0){
            return new int[0];
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int row1 = 0;
        int col1 = 0;
        int row2 = rows - 1;
        int col2 = rows - 1;
        int[] res = new int[rows * cols];
        int index = 0;
        while (row1<= row2 && col1 <= col2){
            for (int i = col1; i <= col2; i++){
                res[index++] = matrix[row1][i];
            }
            for (int j = row1 + 1; j <= row2; j++){
                res[index++] = matrix[j][col2];
            }
            if (row1 != row2){
                for (int i = col2 - 1; i >= col1; i--){
                    res[index++] = matrix[row2][i];
                }
            }
            if (col1 != col2){
                for (int j = row2 - 1; j > row1; j--){
                    res[index++] = matrix[j][col1];
                }
            }
            row1++;row2--;col1++;col2--;
        }
        return res;
    }


//    public int[] spiralOrder(int[][] matrix) {
//        if(matrix.length == 0 || matrix == null) return new int[0];
//        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
//        int[] ret = new int[(c2+1)*(r2+1)];
//        int j =0;
//        while (r1 <= r2 && c1 <= c2){
//            for (int i = c1; i <= c2; i++){
//                ret[j++] = matrix[r1][i];
//            }
//            for (int i = r1 + 1; i <= r2; i++){
//                ret[j++] = matrix[i][c2];
//            }
//            if (r1 != r2){
//                for (int i = c2 - 1; i >= c1; i--){
//                    ret[j++] = matrix[r2][i];
//                }
//            }
//            if (c1 != c2){
//                for (int i = r2 - 1; i > r1; i--){
//                    ret[j++] = matrix[i][c1];
//                }
//            }
//            r1++;r2--;c1++;c2--;
//        }
//        return ret;
//    }
}
