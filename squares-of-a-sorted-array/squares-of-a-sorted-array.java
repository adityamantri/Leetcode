class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1, idx = 0;
        int[] res = new int[nums.length];
        while(i <= j){
            if(Math.abs(nums[i]) >= Math.abs(nums[j])){
                res[j - i] = nums[i] * nums[i];
                i++;
            }else{
                res[j - i] = nums[j] * nums[j];
                j--;
            }
            idx++;
        }
        return res;
    }
}