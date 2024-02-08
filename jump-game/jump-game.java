class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length < 2) return true;
        int maxJump = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(maxJump < i) return false;
            maxJump = Math.max(i+nums[i], maxJump);
            if(maxJump >= nums.length-1) return true;
        }
        return false;
    }
}