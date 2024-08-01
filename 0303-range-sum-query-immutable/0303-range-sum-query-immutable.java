class NumArray {
    int[] arr;
    public NumArray(int[] nums) {
        arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = (i == 0 ? 0 : arr[i-1]) + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return arr[right] - (left == 0 ? 0 : arr[left-1]);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */