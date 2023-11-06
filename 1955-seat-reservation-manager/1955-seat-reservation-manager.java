class SeatManager {
    PriorityQueue<Integer> pq;
    boolean[] arr;
    public SeatManager(int n) {
        pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            pq.offer(i);
        }
        arr = new boolean[n];
    }
    
    public int reserve() {
        int num = pq.poll();
        arr[num-1] = true;
        return num;
    }
    
    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
        arr[seatNumber-1] = false;
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */