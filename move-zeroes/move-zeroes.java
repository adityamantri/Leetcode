class Solution {
    public void moveZeroes(int[] nums) {
        int zCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zCount++;
            } else {
                nums[i - zCount] = nums[i];
            }
        }
        while(zCount != 0){
            nums[nums.length - zCount ] = 0;
            zCount--;
        }
    }
}