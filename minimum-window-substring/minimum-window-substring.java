class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int[] arr = new int[128];
        int left = 0, right = 0;
        int start = 0;
        int minWindow = s.length()+1;
        int count = t.length();
        // calculate t_map
        for(char c : t.toCharArray()){
            arr[c-'A']++;
        }

        // loop over each char
        while(right < s.length()){
            char c = s.charAt(right);
            if(arr[c-'A']-- > 0){
                count--;
            }

            while(count == 0){
                if(minWindow > right-left+1){
                    start = left;
                    minWindow = right-left+1;
                }
                if(arr[s.charAt(left) - 'A']++ == 0){
                    count++;
                }
                left++;
            }
            right++;
        }

        if(minWindow == s.length()+1) return "";
        return s.substring(start, start+minWindow);
    }
}