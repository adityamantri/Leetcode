class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int prod = nums[0];
        for(int i = 1; i < n; i++){
            answer[i] *= prod;
            prod *= nums[i];
        }
        prod = 1;
        for(int i = n-2; i >= 0; i--){
            prod *= nums[i+1];
            answer[i] *= prod;
        }
        return answer;
    }
}