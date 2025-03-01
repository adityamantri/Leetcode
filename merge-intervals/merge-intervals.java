class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> list = new ArrayList<>();
        for(int[] interval : intervals){
            if(list.isEmpty() || list.get(list.size()-1)[1] < interval[0]){
                list.add(interval);
            }else{
                int[] arr = list.get(list.size()-1);
                arr[1] = Math.max(interval[1], arr[1]);
            }
        }
        return list.toArray(new int[0][]);
    }
}