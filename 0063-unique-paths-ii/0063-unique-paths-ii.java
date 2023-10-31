class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[0][0] = 1;
                else{
                    int top = i == 0 ? 0 : dp[i-1][j];
                    int left = j == 0 ? 0 : dp[i][j-1];
                    dp[i][j] = top + left;
                }
            }
        }
        return dp[m-1][n-1];
    }
}