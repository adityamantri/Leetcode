class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[256];
        int start = 0, end = 0, len = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            arr[c]++;
            
            while(arr[c] > 1){
                
                arr[s.charAt(start++)]--;
            }
            end++;
            len = Math.max(len, end - start);
        }
        return len;
    }
}