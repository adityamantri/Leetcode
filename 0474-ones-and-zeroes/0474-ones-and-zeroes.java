class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String str : strs){
            int currOnes = 0, currZeros = 0;
            for(char c : str.toCharArray()){
                if(c == '0') currZeros++; 
                if(c == '1') currOnes++; 
            }

            for(int i = m; i >= currZeros; i--){
                for(int j = n; j >= currOnes; j--){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-currZeros][j-currOnes]);
                }
            }
        }
        return dp[m][n];
    }
}