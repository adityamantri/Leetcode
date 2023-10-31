class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();
        if(s.length() != t.length()) return false;
        int i = 0;
        for(char c : s.toCharArray()){
            char b = t.charAt(i++);
            if((s2t.containsKey(c) && (s2t.get(c) != b)) || (t2s.containsKey(b) && t2s.get(b) != c))
                return false;
            s2t.put(c, b);
            t2s.put(b, c);
        }
        return true;
    }
}