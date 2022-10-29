class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] temp = intervals[0];
        result.add(temp);
        for(int i = 0; i < intervals.length; i++){
            
            if(temp[1] < intervals[i][0]){
                temp = intervals[i];
                result.add(temp);
            }else{
                
                temp[1] = Math.max(temp[1], intervals[i][1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}