class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length, left = 0;
        int sum = Arrays.stream(nums).sum();
        for(int i = 0; i < n; i++){
            if(left == sum - left - nums[i]) return i;
            left += nums[i];
        }
        return -1;
    }
}