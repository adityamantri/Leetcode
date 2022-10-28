class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        if(numRows == 1){
            return result;
        }
        result.add(Arrays.asList(1,1));
        for(int i = 2; i < numRows; i++){
            List<Integer> curr = new ArrayList<>();
            List<Integer> prev = result.get(result.size()-1);
            int num = 0;
            for(int r : prev){
                curr.add(num+r);
                num = r;
            }
            curr.add(1);
            result.add(curr);
            prev = curr;
        }
        return result;
    }
}