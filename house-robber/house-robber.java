class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int prev2 = 0, prev1 = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(nums[i]+prev2, prev1);
            prev2 = prev1;
            prev1 = max;
        }
        return max;
    }
}