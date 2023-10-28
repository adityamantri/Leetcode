class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+1);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            // loop through available squares
            for(int j = 1; j*j <= i; j++){
                dp[i] = Math.min(dp[i-(j*j)]+1, dp[i]);
            }
        }
        return dp[n];
    }
}