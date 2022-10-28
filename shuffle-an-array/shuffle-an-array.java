class Solution {
    static int nums[], copy[];
    int ptr;
    Random rand = new Random();
    public Solution(int[] nums) {
        this.nums = nums;
        copy = nums.clone();
    }
    
    public int[] reset() {
        copy = nums.clone();
        return copy;
    }
    
    public int[] shuffle() {
        for(int i = 0; i < copy.length; i++){
            int idx = rand.nextInt(copy.length - i)+ i;
            int val = copy[i];
            copy[i] = copy[idx];
            copy[idx] = val;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */