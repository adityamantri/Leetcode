class Solution {
    public int countHomogenous(String s) {
        long count = 0, total = 0;
        char prev = 'A';
        for(char c : s.toCharArray()){
            if(c == prev){
                count++;
            }else{
                count = 1;
            }
            total = (total+count)%((int)1e9+7);
            prev = c;
        }
        return (int)total;
    }
}