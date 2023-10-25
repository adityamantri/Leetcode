class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;

        int totalElements = (int)Math.pow(2, n-1);
        int halfElements = totalElements/2;
        if(k > halfElements){
            return 1 - kthGrammar(n, k-halfElements);
        }
        return kthGrammar(n-1, k);
    }
}