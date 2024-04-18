class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty()) return 0;
        int[] index = new int[128];
        Arrays.fill(index, -1);
        int maxLen = 0;
        int prev = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(index[c] != -1){
                prev = Math.max(index[c], prev);
            }
            index[c] = i;
            maxLen = Math.max(i - prev, maxLen);
        }
        return maxLen;
    }
}