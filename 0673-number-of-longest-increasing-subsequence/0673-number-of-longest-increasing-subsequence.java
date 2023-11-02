class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        int max = 1;

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                        count[i] = count[j];
                    }
                    else if(dp[j]+1 == dp[i]){
                        count[i] += count[j];
                    }
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = dp[i];
            if(sum == max) res += count[i];
        }
        return res;
    }
}