class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) return 0;
        Arrays.sort(points, (a, b) -> {
            if(a[1] == b[1]) return 0;
            if(a[1] < b[1]) return -1;
            else return 1;
        });

        int res = 1;
        int xStart, xEnd, prevEnd = points[0][1];
        for(int[] p: points){
            xStart = p[0];
            xEnd = p[1];
            if(prevEnd < xStart){
                prevEnd = xEnd;
                res++;
            }
        }
        return res;
    }
}