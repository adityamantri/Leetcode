class Solution {
    public int getWinner(int[] arr, int k) {
        k = Math.min(arr.length, k);
        Deque<Integer> dq = new ArrayDeque<>();
        Map<Integer, Integer> win = new HashMap<>();
        for(int num : arr){
            dq.offer(num);
            win.put(num, 0);
        }

        while(true){
            int first = dq.poll();
            int second = dq.poll();
            int max = Math.max(first, second), min = Math.min(first, second);
            win.put(max, win.get(max)+1);
            if(win.get(max) == k){
                return max;
            }
            dq.offerFirst(max);
            dq.offerLast(min);
        }
    }
}