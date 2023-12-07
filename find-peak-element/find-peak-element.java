class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = left + (right - left)/2;
            long l = mid == 0 ? Long.MIN_VALUE : nums[mid-1];
            long r = mid == nums.length-1 ? Long.MIN_VALUE : nums[mid+1];
            if(nums[mid] > l && nums[mid] > r){
                return mid;
            }else if(r > nums[mid]){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}