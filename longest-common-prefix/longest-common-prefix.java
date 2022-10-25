class Solution {
    
    public String longestCommonPrefix(String[] strs) {
        int maxLen = strs[0].length();
        
        for(int i = 1; i < strs.length; i++){
            int count = 0;
            for(int j = 0; j < Math.min(strs[i].length(), maxLen); j++){
                if(strs[i].charAt(j) != strs[0].charAt(j)){
                    break;
                }
                count++;
            }
            if(count == 0) return "";
            maxLen = Math.min(maxLen, count);
        }
        return strs[0].substring(0, maxLen);
    }
}
