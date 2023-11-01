class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if((total % 2) == 1){
            return false;
        }
        // System.out.println(total);
        int target = total/2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;
            for(int n : nums){
        for(int i = target; i > 0; i--){
                if(n <= i) 
                dp[i] = dp[i] || dp[i-n];
            }
        }
        // System.out.println(dp[target]);
        return dp[target];
    }
}