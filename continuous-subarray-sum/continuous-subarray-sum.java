class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            sum %= k;
            if(map.containsKey(sum)){
                if(i - map.get(sum) > 1)
                    return true;
            }else
                map.put(sum, i);
        }
        return false;
    }
}