class Solution {
    public int[] plusOne(int[] digits) {
        
        int carry = 1;
        
        for(int i = digits.length-1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] = (digits[i])%10;
            if(carry == 0){
                return digits;
            }
        }
        
        digits = new int[digits.length+1];
        digits[0] = 1;
        
        return digits;
    }
}