class Solution {
    public void recurse(int[] nums, List<List<Integer>> res, List<Integer> curr){
        if(curr.size() == nums.length){
            res.add(new ArrayList(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            recurse(nums, res, curr);
            curr.remove(curr.size()-1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recurse(nums, res, new ArrayList<>());
        return res;
    }
}