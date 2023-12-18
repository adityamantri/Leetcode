class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int arr[]  = new int[128];
        int distinct = 0;
        int start = 0, end = 0;
        int maxSize = 0;
        while(end < s.length()){
            char c = s.charAt(end);
            if(arr[c] == 0) distinct++;
            arr[c]++;
            while( distinct > k){
                // store size and move left
                // maxSize = Math.max(maxSize, end-start);
                if(arr[s.charAt(start)]-- == 1) distinct--;
                start++;
            }
            end++;
            maxSize = Math.max(maxSize, end-start);
        }
        return maxSize;
    }
}