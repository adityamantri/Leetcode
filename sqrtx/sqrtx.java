class Solution {
    public int mySqrt(int x) {
        long l = 1, r = x/2;
        if(x <= 1) return x;
        while(l <= r){
            long m = l + (r-l)/2;
            long sq = m*m;
            if(sq == x) return (int)m;
            if(sq < x){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return (int)r;
    }
}