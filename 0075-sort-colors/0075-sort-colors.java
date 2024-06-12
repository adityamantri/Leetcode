class Solution {
    public void sortColors(int[] nums) {
        int[] arr = new int[3];
        for(int i = 0; i < nums.length; i++){
            arr[nums[i]]++;
        }
        int idx = 0;
        for(int i = 0; i <= 2; i++){
            while(arr[i]-- > 0){
                nums[idx++] = i;
            }
        }
    }
}