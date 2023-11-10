class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0, res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(i >= k){
                sum -= nums[i-k];
            }
            if (i >= k-1)
                res = Math.max(res, sum/k);
        }
        return Math.max(res, sum/k);
    }
}