class Solution {
    public int compress(char[] chars) {
        // char count = '1';
        int i = 0, j = 0, n = chars.length;
        while(n == 1) return n;
        while(i < n){
            int count = 1;
            char c = chars[i];
            while(i < n-1 && chars[i] == chars[i+1]){
                count++;
                i++;
            }
            // chars[j++] = c;
            if(count == 1) chars[j++] = c;
            else if(count > 1){
                chars[j++] = c;
                String counter = count+"";
                for(int r = 0; r < counter.length(); r++){
                    chars[j++] = counter.charAt(r);
                }
            }
            i++;
        }
        return j;
    }
}