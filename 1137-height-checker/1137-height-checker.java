class Solution {
    public int heightChecker(int[] heights) {
        int[] sortedArr = heights.clone();
        countSort(sortedArr);
        int res = 0;
        for(int i = 0; i < heights.length; i++){
            if(heights[i] != sortedArr[i]){
                res++;
            }
        }
        return res;
    }

    public void countSort(int[] heights){
        Map<Integer, Integer> counter = new HashMap<>();
        int min = Arrays.stream(heights).min().getAsInt();
        int max = Arrays.stream(heights).max().getAsInt();

        for(int height : heights){
            counter.put(height, counter.getOrDefault(height, 0)+1);
        }
        int idx = 0;
        for(int val = min; val <= max; val++){
            while(counter.getOrDefault(val, 0) > 0){
                heights[idx] = val;
                idx++;
                counter.put(val, counter.get(val)-1);
            }
        }
    }
}