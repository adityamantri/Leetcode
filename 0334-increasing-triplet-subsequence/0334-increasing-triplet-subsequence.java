class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int firstNum = Integer.MAX_VALUE;
        int secondNum = Integer.MAX_VALUE;
        for(int n : nums){
            if(firstNum >= n){
                firstNum = n;
            }else if(secondNum >= n){
                secondNum = n;
            }else{
                return true;
            }
        }
        return false;
    }
}