class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int ans = nums[0];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        heap.offer(new int[]{nums[0], 0});

        for(int i = 1; i < nums.length; i++){
            // remove extra elements from heap
            while(i - heap.peek()[1] > k){
                heap.poll();
            }
            int curr = nums[i] + Math.max(0, heap.peek()[0]);
            heap.offer(new int[]{curr, i});
            ans = Math.max(curr, ans);
        }
        return ans;
    }
}