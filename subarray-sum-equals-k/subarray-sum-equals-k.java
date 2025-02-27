class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prevSum = 0;
        map.put(0, 1);
        int total = 0;
        for(int i : nums){
            prevSum += i;
            int compliment = prevSum - k;
            total += map.getOrDefault(compliment, 0);
            map.put(prevSum, map.getOrDefault(prevSum, 0)+1);
        }
        return total;
    }
}