class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] arr = new int[n*(n+1)/2];
        int idx = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                arr[idx++] = sum;
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int sum = 0;
        for(int i = left-1; i < right; i++){
            sum = (sum+arr[i]) % ((int)1e9+7);
        }
        return sum;
    }
}