class Solution {

    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int l1 = expand(s, i, i);
            if(end - start + 1 < l1){
                int dist = l1/2;
                start = i - dist;
                end = i + dist;
            }
            int l2 = expand(s, i, i+1);
            if(end - start + 1 < l2){
                int dist = l2/2 - 1;
                start = i - dist;
                end = i + 1 + dist;
            }
        }
        return s.substring(start, end+1);
    }

    public int expand(String s, int start, int end) {
        int len = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}