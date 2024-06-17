class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Long> set = new HashSet<>();
        for(long i = 0; i*i <= c; i++){
            long num = i*i;
            long compliment = c - num;
            if(set.contains(compliment) || compliment == num)
                return true;
            set.add(num);
        }
        return false;
    }
}