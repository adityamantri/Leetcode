class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] def = new int[]{-1, -1};
        int index = lowBinarySearch(nums, target, 0, nums.length);
        if(index == nums.length || nums[index] != target) return def;
        return new int[]{index, lowBinarySearch(nums, target+1, index+1, nums.length)-1};
    }
    
    public int lowBinarySearch(int[] nums, int target, int l, int r){
        while(l < r){
            int m = l + (r-l)/2;
            if(nums[m] < target){
                l = m+1;
            }else{
                r = m;
            }
        }
        return l;
    }
}