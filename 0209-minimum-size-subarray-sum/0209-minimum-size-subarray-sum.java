class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0, sum = 0, minSize = Integer.MAX_VALUE;
        while(end < nums.length){
            sum += nums[end];
            while(sum >= target){
                minSize = Math.min(minSize, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}