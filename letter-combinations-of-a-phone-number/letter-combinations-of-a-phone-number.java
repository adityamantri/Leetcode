class Solution {
    Map<Character, String> map;
    public List<String> letterCombinations(String digits) {
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> strs = new ArrayList<>();
        if(digits.isEmpty()) return strs;
        backtrack(digits, 0, strs, new StringBuilder());
        return strs;
    }
    
    private void backtrack(String digits, int idx, List<String> strs, StringBuilder sb){
        // base case
        if(digits.length() == idx){
            strs.add(sb.toString());
            // sb.delete(sb.length()-1);
            return;
        }
        
        for(char c : map.get(digits.charAt(idx)).toCharArray()){
            sb.append(c);
            backtrack(digits, idx+1, strs, sb);
            sb.deleteCharAt(idx);
        }
    }
}