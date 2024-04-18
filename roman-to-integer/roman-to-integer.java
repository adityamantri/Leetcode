class Solution {
    public int romanToInt(String s) {
        int prev = 0, num = 0, ans = 0;
        for(char c : s.toCharArray()){
            switch(c){
                case 'I': 
                    num = 1; 
                    break;
                case 'V': 
                    num = 5; 
                    break;
                case 'X': 
                    num = 10; 
                    break;
                case 'L': 
                    num = 50; 
                    break;
                case 'C': 
                    num = 100; 
                    break;
                case 'D': 
                    num = 500; 
                    break;
                case 'M': 
                    num = 1000; 
                    break;
            }
            if(prev < num){
                ans -= (prev + prev);
            }
            ans += num;
            prev = num;
        }
        return ans;
    }
}