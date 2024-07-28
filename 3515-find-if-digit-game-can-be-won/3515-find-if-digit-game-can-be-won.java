class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        for(int i : nums){
            if(i < 10){
                sum += i;
            }else{
                sum -= i;
            }
        }
        return sum != 0;
    }
}