class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b [1]);
        int end = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            int newStart = intervals[i][0];
            int newEnd = intervals[i][1];
            if(newStart < end){
                end = Math.min(end, newEnd);
                count++;
            }else{
                end = newEnd;
            }
        }
        
        return count;
    }
}