/**
 * 给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 *
 * Consider the following matrix:
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * Given target = 5, return true.
 * Given target = 20, return false.
 */
public class Offer_4 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (true){
            if (row >= matrix.length || col < 0){
                break;
            }
            if (matrix[row][col] == target){
                return true;
            }else if (matrix[row][col] > target){
                col--;
            }else {
                row++;
            }
        }
        return false;
    }

//    public boolean findNumberIn2DArray(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
//            return false;
//        int rows = matrix.length, cols = matrix[0].length;
//        int col = cols - 1, row = 0;
//        while (row < rows && col >= 0){
//            if (matrix[row][col] == target){
//                return true;
//            }else if (matrix[row][col] > target){
//                col--;
//            }else {
//                row++;
//            }
//        }
//        return false;
//    }


}
