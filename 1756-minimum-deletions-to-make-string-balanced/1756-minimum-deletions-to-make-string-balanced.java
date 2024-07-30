class Solution {
    public int minimumDeletions(String s) {
        int[][] arr = new int[s.length()+1][2];
        int a = 0, b = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a') a++;
            else b++;
            arr[i][0] = a;
            arr[i][1] = b;
        }
        // now assume each point as division point. 
        //remove extra a's on right
        // remove extra b's on left
        int ans = a;
        for(int i = 0; i < s.length(); i++){
            ans = Math.min(ans, a - arr[i][0] + arr[i][1]);
        }
        return ans;

    }
}