class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length == 0 || s == null) return result;

        Map<String, Integer> map = new HashMap();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }

        int len = words[0].length();
        int totalLen = len * words.length;
        int start = 0, end = 0;
        while(end <= s.length() - len * words.length){
            String sub = s.substring(end, end + totalLen);
            if(isConcat(sub, map, len)){
                result.add(end);
            }
            end++;
        }
        return result;
    }

    private boolean isConcat(String str, Map<String, Integer> map, int len){
        Map<String, Integer> count = new HashMap<>();
        for(int i = 0; i < str.length(); i+=len){
            String sub = str.substring(i, i+len);
            count.put(sub, count.getOrDefault(sub, 0)+1);
        }
        return count.equals(map);
    }
}