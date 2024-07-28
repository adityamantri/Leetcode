class Solution {
    public int nonSpecialCount(int l, int r) {
        int count = 0;
        int start = (int)Math.sqrt(l);
        int end = (int)Math.sqrt(r);
        
        // find all prime numbers between start and end 
        for(int i = start; i <= end; i++){
            if(i != 1  && i * i >= l && isPrime(i)){
                count++;
            }
        }

        return r - l - count + 1;
    }

    public boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}