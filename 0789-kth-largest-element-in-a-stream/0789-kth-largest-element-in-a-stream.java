class KthLargest {
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(k+1);
        this.k = k;
        for(int i : nums){
            add(i);
        }
    }
    
    public int add(int val) {
        if(pq.size() < k || pq.peek() < val){
            pq.offer(val);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */