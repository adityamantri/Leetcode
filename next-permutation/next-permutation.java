class Solution {
    public void nextPermutation(int[] nums) {
        int pivot = nums.length-2;
        while(pivot >= 0 && nums[pivot] >= nums[pivot+1]){
            pivot--;
        }
        if(pivot >= 0){
            int idx = nums.length-1;
            while(pivot < idx && nums[pivot] >= nums[idx]){
                idx--;
            }
            int x = nums[pivot];
            nums[pivot] = nums[idx];
            nums[idx] = x;
        }
        
        pivot++;
        int j = nums.length-1;
        while(pivot < j){
            int temp = nums[pivot];
            nums[pivot] = nums[j];
            nums[j] = temp;
            pivot++; j--;
        }
    }
}