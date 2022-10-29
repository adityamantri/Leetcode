class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int newStart = newInterval[0], newEnd = newInterval[1];
        int idx = 0, len = intervals.length;
        List<int[]> result = new ArrayList<>();
        
        // add starting elements
        while(idx < len && intervals[idx][1] < newStart){
            result.add(intervals[idx++]);
        }
        
        // merge intervals
        while(idx < len && intervals[idx][0] <= newEnd){
            newStart = Math.min(newStart, intervals[idx][0]);
            newEnd = Math.max(newEnd, intervals[idx][1]);
            idx++;
        }
        result.add(new int[]{newStart, newEnd});
        
        while(idx < len){
            result.add(intervals[idx++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}