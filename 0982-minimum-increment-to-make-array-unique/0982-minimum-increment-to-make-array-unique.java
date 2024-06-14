class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length, res = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int[] freq = new int[n + max];
        for(int val : nums){
            freq[val]++;
        }
        for(int i = 0; i < freq.length; i++){
            if(freq[i] <= 1) continue;
            int dups = freq[i] - 1;
            freq[i+1] += dups;
            freq[i] = 1;
            res += dups;
        }
        return res;
    }
}