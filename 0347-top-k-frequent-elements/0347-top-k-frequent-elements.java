class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(k+1, (a, b) -> a.getValue() - b.getValue());
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            pq.offer(e);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] arr = new int[k];
        for(Map.Entry<Integer, Integer> e: pq){
            arr[--k] = e.getKey();
        }
        return arr;
    }
}