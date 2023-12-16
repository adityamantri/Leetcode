class Solution {
    public int removeDuplicates(int[] nums) {
        int duplicates = 0;
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]){
                duplicates++;
            }
            nums[i-duplicates] = nums[i];
        }
        return nums.length - duplicates;
    }
}