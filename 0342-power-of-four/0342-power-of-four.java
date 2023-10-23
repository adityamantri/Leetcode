class Solution {
    public boolean isPowerOfFour(int n) {
        if(n == 1) return true;
        int left = 1, right = n;
        while(n > 1){
            if(n%4 > 0){
                return false;
            }
            n = n/4;
        }
        return n > 0;
    }
}