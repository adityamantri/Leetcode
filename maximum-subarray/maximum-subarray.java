class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
    }
}