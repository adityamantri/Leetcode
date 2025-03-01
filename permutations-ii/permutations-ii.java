class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        recurse(nums, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    
    public void recurse(int[] nums, List<List<Integer>> res, List<Integer> curr, boolean[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i > 0 && nums[i] == nums[i-1] && visited[i-1]){
                continue;
            }
            visited[i] = true;
            curr.add(nums[i]);
            recurse(nums, res, curr, visited);
            curr.remove(curr.size()-1);
            visited[i] = false;
        }
    }
}