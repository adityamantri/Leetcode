class Solution {
    public final String PUSH = "Push"; 
    public final String POP = "Pop"; 
    public List<String> buildArray(int[] target, int n) {
        int idx = 0;
        List<String> res = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            res.add("Push");
            if(target[idx] != i){
                res.add("Pop");
            }else{
                idx++;
            }
            if(idx == target.length) return res;
        }
        return res;
    }
}