/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子
 */
public class Offer_13 {
    boolean[][] mat;
    public int movingCount(int m, int n, int k) {
        mat = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }
    private int sum(int m){
        int sum = 0;
        while (m != 0){
            sum += (m % 10);
            m = m / 10;
        }
        return sum;
    }
    private int dfs(int i, int j, int m, int n, int k){
        if (sum(i) + sum(j) > k || i >= m || j >= n || mat[i][j]){
            return 0;
        }
        mat[i][j] = true;
        return 1 + dfs(i + 1, j, m, n, k) + dfs(i, j + 1, m, n, k);
    }


//    private boolean[][] visited;
//    public int movingCount(int m, int n, int k) {
//        visited = new boolean[m][n];
//        return dfs(0,0, 0, 0, m,n,k);
//    }
//    private int dfs(int i, int j, int iSum, int jSum, int m, int n, int k){
//        if (iSum + jSum > k || i >= m || j >= n || visited[i][j])
//            return 0;
//        visited[i][j] = true;//同样
//        return 1+ dfs(i+1,j,(i+1) % 10 == 0 ? iSum-8:iSum+1,jSum,m,n,k) + dfs(i,j+1,iSum,(j+1) % 10 == 0 ? jSum-8:jSum+1,m,n,k) ;
//    }

}

