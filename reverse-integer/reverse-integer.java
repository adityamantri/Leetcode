class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            
            int newResult = rev*10 + x%10;
            if(rev != (newResult-(x%10))/10){
                return 0;
            }
            x /= 10;
            rev = newResult;
        }
        return rev;
    }
}