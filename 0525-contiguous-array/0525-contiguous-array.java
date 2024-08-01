class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> scoreToIndexMap = new HashMap<>();
        scoreToIndexMap.put(0, -1);
        int score = 0, maxDist = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                score--;
            }else{
                score++;
            }
            if(scoreToIndexMap.containsKey(score)){
                int lastIdx = scoreToIndexMap.get(score);
                maxDist = Math.max(i - lastIdx, maxDist);
            }else{
                scoreToIndexMap.put(score, i);
            }
        }
        return maxDist;
    }
}

// [0,1,0]
// [-1, 0, -1]