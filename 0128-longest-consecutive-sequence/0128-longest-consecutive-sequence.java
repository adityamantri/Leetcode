class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) 
            set.add(i);
        int streak = 0;
        for(int n : nums){
            if(!set.contains(n-1)){
                int currNum = n, count = 1;
                while(set.contains(currNum+1)){
                    currNum++;
                    count++;
                }
                streak = Math.max(streak, count);
            }
        }
        return streak;
    }
}