class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int d = 0;
        while(xor != 0){
            if((xor & 1) == 1){
                d++;
            }
            xor = xor >> 1;
        }
        return d;
    }
}