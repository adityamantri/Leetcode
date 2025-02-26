class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int sign = 1;
        long result = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i == 0 && (c == '+' || c == '-')){
                if(c == '-') sign = -1;
                continue;
            }
            
            if(Character.isDigit(c)){
                // condition for overflow
                
                result = result * 10 + c - '0';
                if(result*sign >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if (result*sign <= Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else{
                break;
            }
        }
        result = result * sign;
        // System.out.println(result);
        
        return (int)result;
    }
}