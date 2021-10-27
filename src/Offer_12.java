/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 */
public class Offer_12 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (recur(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean recur(char[][] board, String words, int k, int i, int j){
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || words.charAt(k) != board[i][j]){
            return false;
        }
        if (k == words.length() - 1)
            return true;
        board[i][j] = ' ';
        boolean res = recur(board, words,k + 1, i, j - 1) || recur(board, words,k + 1, i, j + 1)
                || recur(board, words,k + 1, i + 1, j) || recur(board, words,k + 1, i - 1, j);
        board[i][j] = words.charAt(k);
        return res;
    }



//    char[] c;
//    public boolean exist(char[][] board, String word) {
//        c = word.toCharArray();
//        for (int i = 0; i < board.length; i++){
//            for (int j = 0; j < board[0].length; j++){
//                if(dfs(i, j, board, 0))
//                    return true;
//            }
//        }
//        return false;
//    }
//    private boolean dfs(int i , int j, char[][]board, int k){
//        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != c[k]){
//            return false;
//        }
//        if (k == c.length - 1){
//            return true;
//        }
//        board[i][j] = '\0';//别忘了赋值为空，表示不能返回原来的路径
//        boolean res =  dfs(i, j+1, board,k+1)||dfs(i, j - 1,board, k+1)||dfs(i+1, j, board, k+1)||dfs(i-1,j,board,k+1);
//        board[i][j] = c[k];//还原原来的矩阵
//        return res;
//    }
}
