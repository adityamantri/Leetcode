class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];

        for(int i = 0; i < n; i++){
            time[i] = (int)Math.ceil((1.0)*dist[i]/speed[i]);
        }
        Arrays.sort(time);
        for(int i = 0; i < n; i++){
            if(time[i] <= i){
                return i;
            }
        }
        return n;
    }
}