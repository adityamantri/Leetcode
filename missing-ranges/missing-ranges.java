class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        for(int n : nums){
            
            if(lower == n){
                lower = n+1;
            }else if(lower < n){
                res.add(Arrays.asList(lower, n-1));
                lower = n+1;
            }else if(upper < n) break;
            
        }
        if(lower <= upper){
            res.add(Arrays.asList(lower, upper));
        }
        return res;
    }
}