class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> list = new ArrayList<>();
        // int[] prev = intervals[0];
        list.add(intervals[0]);
        for(int[] interval : intervals){
            int[] prev = list.get(list.size()-1);
            if(prev[1] >= interval[0]){
                prev[1] = Math.max(prev[1], interval[1]);
            }else{
                list.add(interval);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}