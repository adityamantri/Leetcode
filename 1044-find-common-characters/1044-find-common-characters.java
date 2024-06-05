class Solution {
    public List<String> commonChars(String[] words) {
        int[] arr = new int[26];
        Arrays.fill(arr, Integer.MAX_VALUE);
        for(int i = 0; i < words.length; i++){
            int[] freq = new int[26];
            for(char c : words[i].toCharArray()){
                freq[c-'a']++;
            }
            for(int j = 0; j < 26; j++){
                arr[j] = Math.min(freq[j], arr[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++){
            while(arr[i] > 0){
                char c = (char)('a'+i);
                // c+=i;
                res.add(c+"");
                arr[i]--;
            }
        }
        return res;
    }
}