class Solution {
    char[][] reversiblePairs = {
        {'0', '0'}, {'1', '1'},
        {'8', '8'}, {'6', '9'}, {'9', '6'}
    };
    public List<String> findStrobogrammatic(int n) {
        return recurse(n, n);
    }
    
    public List<String> recurse(int n, int finalLength){
        if(n == 0) return Arrays.asList("");
        if(n == 1) return Arrays.asList("1", "8", "0");
        
        List<String> prev = recurse(n-2, finalLength);
        List<String> curr = new ArrayList<>();
        for(String s : prev){
            for(char[] pair : reversiblePairs){
                // we can not take 0 on the outer length, as leading 0 will be removed in numbers
                if(pair[0] != '0' || n != finalLength){
                    curr.add(pair[0]+s+pair[1]);
                }
            }
        }
        return curr;
    }
}