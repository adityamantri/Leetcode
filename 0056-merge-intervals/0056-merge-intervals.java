class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }else{
                return a[0] - b[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{intervals[0][0], intervals[0][1]});
        for(int i = 1; i < intervals.length; i++){
            int[] item = list.get(list.size()-1);
            if(item[1] >= intervals[i][0]){
                item[1] = Math.max(item[1], intervals[i][1]);
            }else{
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][]);
        
    }
}