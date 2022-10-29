class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b [1]);
        int start = intervals[0][0], end = intervals[0][1];
        int count = 0;
        List<int[]> list = new ArrayList<>();
        
        
        for(int i = 1; i < intervals.length; i++){
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            if(newStart < end){
                end = Math.min(end, intervals[i][1]);
                count++;
            }else{
                start = newStart;
                end = newEnd;
            }
        }
        
        return count;
    }
}