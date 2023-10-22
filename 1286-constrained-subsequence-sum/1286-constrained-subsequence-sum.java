class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        // int ans = nums[0];
        TreeMap<Integer, Integer> window = new TreeMap();
        window.put(0, 0);
        int dp[] = new int[nums.length];
        // PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // heap.offer(new int[]{nums[0], 0});

        for(int i = 0; i < nums.length; i++){
            // remove extra elements from heap
            dp[i] = nums[i] + window.lastKey();
            window.put(dp[i], window.getOrDefault(dp[i], 0)+1);
            
            if(i >= k){
                window.put(dp[i-k], window.get(dp[i-k])-1);
                if(window.get(dp[i-k]) == 0){
                    window.remove(dp[i-k]);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int num : dp){
            ans = Math.max(ans, num);
        }

        return ans;
    }
}