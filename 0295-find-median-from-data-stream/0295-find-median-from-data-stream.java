class MedianFinder {
    
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(minHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.offer(num);
        }else{
            minHeap.offer(num);
        }
       
        
        if(maxHeap.size() > minHeap.size() + 1){
            minHeap.offer(maxHeap.poll());
        }else if(minHeap.size() > maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() > minHeap.size()){
            return maxHeap.peek();
        }else{
            return (minHeap.peek() + maxHeap.peek() + 0.0)/2;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */