class Solution {
    public double myPowHelper(double x, long n) {
        if(n == 0) return 1;
        if(n < 0){
            x = 1.0/x;
            n = -1*n;
        }
        double res = 1;
        while(n != 0){
            if((n % 2) == 1){
                res *= x;
                n -= 1;
            }
            x = x*x;
            n /= 2;
        }
        return res;
    }
    
    public double myPow(double x, int n){
        return myPowHelper(x, (long) n);
    }
}

/**
n = 10, x = 2.0
n = 2*5
res = 2pow(5+5) = (2+2+1 + 2+2+1)

*/