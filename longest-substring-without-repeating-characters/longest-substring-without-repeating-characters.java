class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int[] idxMap = new int[128];
        Arrays.fill(idxMap, -1);
        int left = -1, right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(idxMap[c] != -1){
                left = Math.max(left, idxMap[c]);
            }
            idxMap[c] = right;
            maxLen = Math.max(right-left, maxLen);
            right++;
        }
        return maxLen;
    }
}