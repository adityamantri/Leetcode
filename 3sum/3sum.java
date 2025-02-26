class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length-2; i++){
            int j = i+1, k = nums.length-1;
            int comp = -nums[i];
            while(j < k){
                int sum = nums[j] + nums[k];
                if(sum < comp){
                    j++;
                }else if(sum > comp){
                    k--;
                }else{
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                    j++;
                    k--;
                }
            }   
        }
        return new ArrayList(res);
    }
}