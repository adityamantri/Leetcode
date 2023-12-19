class Solution {
    Boolean[][] memo;
    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length()+1][p.length()+1];
        return dp(0, 0, s, p);
    }

    public boolean dp(int i, int j, String s, String p){
        if(memo[i][j] != null){
            return memo[i][j];
        }

        boolean ans;
        if(j == p.length()){
            ans = i == s.length();
        }else{
            boolean firstMatch = (i < s.length() && 
                                (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)));
            // next p index is in range && next p char is *
            // prev answer does not bother
            if(j+1 < p.length() && p.charAt(j+1) == '*'){
                ans = (dp(i, j+2, s, p)) || firstMatch && dp(i+1, j, s, p);
            } else {
                // p is not *, so continue matching next chars
                ans = firstMatch && dp(i+1, j+1, s, p);
            }
        }
        memo[i][j] = ans;
        return ans;
    }
}