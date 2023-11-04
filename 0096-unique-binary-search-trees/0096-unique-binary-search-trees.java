class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int totalNodes = 2; totalNodes <= n; totalNodes++){
            for(int currRootNode = 1; currRootNode <= totalNodes; currRootNode++){
                dp[totalNodes] +=  dp[currRootNode-1] * dp[totalNodes-currRootNode];
            }
        }
        return dp[n];
    }
}