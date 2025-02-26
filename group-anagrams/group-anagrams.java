class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] freq = new int[26];
            for(char c : str.toCharArray()){
                freq[c-'a']++;
            }
            String s = new String(Arrays.toString(freq));
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}