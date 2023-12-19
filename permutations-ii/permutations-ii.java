class Solution {

    public void backtrack(int[] nums, boolean[] used, List<List<Integer>> result, List<Integer> curr){
        if(curr.size() == nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // to avoid used or duplicates that occur consecutively [1,1,2]
            // here result with indexes [0,1,2] and [1,0,2] will result in [1,1,2]
            // we just check that the previous is same and not used
            if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums, used, result, curr);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], result, new ArrayList<>());
        return result;
    }
}