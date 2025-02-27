class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] arr = new int[256];
        int unique = 0;
        int start = 0, ans = 0;
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            if(arr[c] == 0) unique++;
            arr[c]++;
            while(unique > k){
                ans = Math.max(ans, end - start);
                arr[s.charAt(start)]--;
                if(arr[s.charAt(start)] == 0) unique--;
                start++;
            }
        }
        return Math.max(s.length() - start, ans);
    }
}