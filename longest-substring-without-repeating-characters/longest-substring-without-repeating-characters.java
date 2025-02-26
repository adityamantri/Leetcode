class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();// a: 0, b: 1 
        int start = 0;// 0
        int maxLength = 0;// 0
        for(int i = 0; i < s.length(); i++){// 1
            char c = s.charAt(i);// b
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c)+1);
            }
            map.put(c, i); 
            maxLength = Math.max(maxLength, i - start + 1); // 1
        }
        return maxLength;
    }
}
/*
abba
*/