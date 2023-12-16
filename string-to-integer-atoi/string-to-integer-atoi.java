class Solution {

    public int myAtoi(String s) {
        s = s.trim(); // rule 1
        int n = s.length();
        long res = 0;
        if(n == 0) return 0; // empty string
        int sign = 1; 
        int i = 0;
        if(s.charAt(0) == '-'){
            sign = -1;
            i++;
        }else if(s.charAt(0) == '+'){
            i++;
        }
        
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            int num = s.charAt(i)-'0';
            
            // check overflow and underflow
            if(res > Integer.MAX_VALUE /10 || res == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE%10){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            res *= 10;
            res += num;
            
            i++;
        }
        return (int) res*sign;
    }
}