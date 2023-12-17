class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if(s.equals(t)) return false;
        if(m < n) return isOneEditDistance(t, s);
        
        boolean isEdited = false;
        if(m == n){
            for(int i = 0; i < m; i++){
                char c1 = s.charAt(i), c2 = t.charAt(i);
                if(c1 != c2){
                    if(isEdited) return false;
                    else isEdited = true;
                }
            }
        }else{
            if(m != n+1) return false;
            // skip 1 char from s
            int i = 0, j = 0;
            while(j != n){
                char c1 = s.charAt(i), c2 = t.charAt(j);
                if(c1 == c2){
                    i++;
                    j++;
                }else{
                    i++;
                    if(j+1 != i) return false;
                }
            }
        }
        return true;
    }
}