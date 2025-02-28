class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recurse(nums, 0, res, new ArrayList<>(), new HashSet<Integer>());
        return res;
    }
    
    public void recurse(int[] nums, int idx, List<List<Integer>> res, List<Integer> curr, Set<Integer> set){
        if(curr.size() == nums.length){
            res.add(new ArrayList(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                curr.add(nums[i]);
                recurse(nums, idx+1, res, curr, set);
                set.remove(nums[i]);
                curr.remove(curr.size()-1);
            }
        }
    }
}