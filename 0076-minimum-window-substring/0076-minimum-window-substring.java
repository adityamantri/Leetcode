class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), count = t.length();
        if(m == 0 || count == 0 || m < count) return "";
        int minLen = Integer.MAX_VALUE, minStart = 0;
        int start = 0, end = 0;
        int[] arr = new int[128];
        // add all characters to array
        for(char c : t.toCharArray()){
            arr[c-'A']++;
        }

        // Loop over each character
        while(end < m){
            char c = s.charAt(end);
            if(arr[c-'A']-- > 0){
                count--;
            }
            while(count == 0){
                if(minLen > end-start+1){
                    minStart = start;
                    minLen = end-start+1;
                }
                if(arr[s.charAt(start)-'A']++ == 0){
                    count++;
                }
                start++;
            }
            end++;
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
    }
}