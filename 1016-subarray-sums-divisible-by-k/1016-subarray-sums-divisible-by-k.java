class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modGroups = new int[k];
        int prefixMod = 0, res = 0, n = nums.length;
        modGroups[0] = 1;
        for(int i = 0; i < n; i++){
            prefixMod = (prefixMod + k + nums[i] % k) % k;
            res += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }
        return res;
    }
}