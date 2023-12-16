class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1, 'V', 5, 'X', 10, 'L', 50, 'C', 100,
                                            'D', 500, 'M', 1000);
        int prev = 0, res = 0;
        for(int i = s.length()-1; i >= 0; i--){
            char c = s.charAt(i);
            int num = map.get(c);
            res += num < prev ? -num : num;
            prev = num;
        }
        return res;
    }
}