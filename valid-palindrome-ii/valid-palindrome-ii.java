class Solution {
    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length()-1, 1);
    }
    
    public boolean isValid(String s, int start, int end, int k){
        if(start >= end) return true;
        if(s.charAt(start) != s.charAt(end)){
            if(k == 0){ return false;}
            else if(k == 1){
                return isValid(s, start+1, end, 0) || isValid(s, start, end-1, 0);
            }
        }
        return isValid(s, start+1, end-1, k);
    }
}