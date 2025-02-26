class Solution {
    public int romanToInt(String s) {
        int prev = 0, sum = 0, num = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            switch(c){
                case 'I':
                    num = 1; break;
                case 'V':
                    num = 5; break;
                case 'X':
                    num = 10; break;
                case 'L':
                    num = 50; break;
                case 'C':
                    num = 100; break;
                case 'D':
                    num = 500; break;
                case 'M':
                    num = 1000; break;
            }
            sum += (prev <= num) ? num : -num;
            prev = num;
        }
        return sum;
    }
}