class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        for(int i = 1; i < nums.length; i++){
            prod *= nums[i-1];
            res[i] = prod;
        }
        prod = 1;
        for(int i = nums.length-2; i >= 0; i--){
            prod *= nums[i+1];
            res[i] *= prod;
        }
        return res;
    }
}

/*
[1,2,3,4]
[0,1,2,6]


*/