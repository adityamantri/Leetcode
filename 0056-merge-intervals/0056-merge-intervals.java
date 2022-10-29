class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] prev = result.get(result.size()-1);
            if(prev[1] < intervals[i][0]){
                result.add(intervals[i]);
            }else{
                prev = result.remove(result.size()-1);
                prev[1] = Math.max(prev[1], intervals[i][1]);
                result.add(prev);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}