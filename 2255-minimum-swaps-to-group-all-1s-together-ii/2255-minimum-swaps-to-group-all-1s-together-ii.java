class Solution {
    public int minSwaps(int[] nums) {
        int minSwaps = Integer.MAX_VALUE;
        int totalOnes = 0;
        for(int i : nums){
            totalOnes += i;
        }
        int onesCount = nums[0];
        int end = 0;
        for(int start = 0; start < nums.length; start++){
            if(start != 0){
                onesCount -= nums[start-1];
            }
            while(end - start + 1 < totalOnes){
                end++;
                onesCount += nums[end % nums.length];
            }
            minSwaps = Math.min(minSwaps, totalOnes - onesCount);
        }
        return minSwaps;
    }
}