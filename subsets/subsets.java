class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res, 0);
        return res;
    }
    
    private void backtrack(int[] nums, List<Integer> curr, List<List<Integer>> res, int idx){
        res.add(new ArrayList<>(curr));
        if(curr.size() == nums.length) return;
        for(int i = idx; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums, curr, res, i+1);
            curr.remove(curr.size()-1);
        }
    }
}