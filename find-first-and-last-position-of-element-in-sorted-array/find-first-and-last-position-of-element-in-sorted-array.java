class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int left = findLeft(nums, target, 0, nums.length);
        if(left == nums.length || nums[left] != target)  return new int[]{-1, -1};
        int right = findLeft(nums, target+1, left+1, nums.length);
        return new int[]{left, right-1};
    }
    
    public int findLeft(int[] nums, int target, int l, int r){
        while(l < r){
            int m = l + (r-l)/2;
            if(nums[m] >= target){
                r = m;
            }else{
                l = m+1;
            }
        }
        return l;
    }
}