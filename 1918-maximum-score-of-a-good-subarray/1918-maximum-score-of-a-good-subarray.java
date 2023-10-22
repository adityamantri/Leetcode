class Solution {
    public int maximumScore(int[] nums, int k) {
        int i = k, j = k, min = nums[k], res = nums[k], n = nums.length;
        while(i >= 0 && j < n){
            min = Math.min(min, Math.min(nums[i], nums[j]));
            res = Math.max(min*(j-i+1), res);
            int left = i > 0 ? nums[i-1] : 0;
            int right = j < n-1 ? nums[j+1] : 0;
            if(left >= right){
                i--;
            }
            if(right > left){
                j++;
            }
        }
        return res;
    }
}