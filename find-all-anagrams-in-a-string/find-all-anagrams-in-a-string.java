class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int unique = 0;
        int[] pArr = new int[26];
        for(char c : p.toCharArray()){
            if(pArr[c-'a'] == 0) unique++;
            pArr[c-'a']++;
        }
        List<Integer> output = new ArrayList<>();
        if(s.length() < p.length()) return output;
        int r = 0;
        int[] sArr = new int[26];
        while(r < s.length()){
            char c = s.charAt(r);
            sArr[c - 'a']++;
            if(r >= p.length()){
                sArr[s.charAt(r-p.length())-'a']--;
            }
            if(Arrays.equals(sArr, pArr)){
                output.add(r-p.length()+1);
            }
            r++;
        }
        return output;
    }
}