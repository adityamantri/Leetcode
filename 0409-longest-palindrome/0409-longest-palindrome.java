class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        int odd = 0;
        for(char c : s.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if(freq.get(c) % 2 == 1){
                odd++;
            }else{
                odd--;
            }
        }
        return (odd > 0) ? s.length() - odd + 1 : s.length();
    }
}