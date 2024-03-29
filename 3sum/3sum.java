class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                twoSum(nums, res, i);
            }
        }
        return res;
    }

    public static void twoSum(int[] nums, List<List<Integer>> res, int i){
        int lo = i+1, hi = nums.length-1;
        while(lo < hi){
            int sum = nums[i] + nums[lo] + nums[hi];
            if(sum > 0){
                hi--;
            }else if(sum < 0){
                lo++;
            }else{
                res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                while(lo < hi && nums[lo] == nums[lo-1]){
                    lo++;
                }
            }
        }
    }
}