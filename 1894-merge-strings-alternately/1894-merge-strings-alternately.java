class Solution {
    public String mergeAlternately(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < Math.min(l1, l2); i++){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        if(l1 > l2){
            sb.append(word1.substring(Math.min(l1, l2), word1.length()));
        }else if(l2 > l1){
            sb.append(word2.substring(Math.min(l1, l2), word2.length()));
        }
        return sb.toString();
    }
}