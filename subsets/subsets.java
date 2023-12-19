class Solution {

    public void backtrack(int[] nums, int idx, List<List<Integer>> res, List<Integer> curr){
        res.add(new ArrayList<>(curr));
        // exit condition
        if(idx == nums.length) return;

        for(int i = idx; i < nums.length; i++){
            curr.add(nums[i]);
            backtrack(nums, i+1, res, curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res, new ArrayList<>());
        return res;
    }
}