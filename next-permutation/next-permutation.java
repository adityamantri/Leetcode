class Solution {
    public void nextPermutation(int[] nums) {
        int r = nums.length-2, idx2 = -1;
        // find decreasing order from last
        while(r >= 0 && nums[r] >= nums[r+1]) r--;
        int pivot = r;
        
        // if entire array is not sorted in reverse order (edge case)
        if(pivot >= 0){
            // find the next greater element to swap
            for(int i = nums.length-1; i > pivot; i--){
                if(nums[i] > nums[pivot]){
                    idx2 = i;
                    break;
                }
            }
            // swap it
            swap(nums, pivot, idx2);
        }
        // reverse on the right to get the Next number
        reverse(nums, pivot+1);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int l){
        int r = nums.length-1;
        while(l < r){
            swap(nums, l, r);
            l++; r--;
        }
    }
}