class Solution {
    public String minWindow(String s, String t) {
        int left = 0, right = 0, minStart = 0, minLen = s.length() + 1, count = t.length();
        if(s.length() < t.length()) return "";
        int[] arr = new int[128];
        for(char c : t.toCharArray()){
            arr[c-'A']++;
        }
        
        while(right < s.length()){
            char c = s.charAt(right);
            if(arr[c-'A']-- > 0){
                count--;
            }
            right++;
            while(count == 0){
                
                if(minLen > right - left){
                    minLen = right-left;
                    minStart = left;
                }
                
                char l = s.charAt(left);
                if(arr[l - 'A']++ == 0){
                    count++;
                }
                left++;
            }
        }
        return (minLen == s.length()+1) ? "" : s.substring(minStart, minStart+minLen);
    }
}