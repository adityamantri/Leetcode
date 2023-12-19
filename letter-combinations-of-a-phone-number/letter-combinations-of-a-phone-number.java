class Solution {
    Map<Character, String> map = Map.of('2', "abc",
                                            '3', "def",
                                            '4', "ghi",
                                            '5', "jkl",
                                            '6', "mno",
                                            '7', "pqrs",
                                            '8', "tuv",
                                            '9', "wxyz"
                                            );

    public void backtrack(String digits, int idx, StringBuilder sb, List<String> res){
        // base case
        if(idx == digits.length()){
            res.add(sb.toString());
            return;
        }

        // recurse
        char d = digits.charAt(idx);
        for(char c : map.get(d).toCharArray()){
            sb.append(c);
            backtrack(digits, idx+1, sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        backtrack(digits, 0, new StringBuilder(), res);
        return res;
    }
}