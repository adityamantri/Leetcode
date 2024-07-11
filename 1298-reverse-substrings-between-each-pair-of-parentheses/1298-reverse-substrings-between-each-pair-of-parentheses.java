class Solution {
    public String reverseParentheses(String s) {
        Stack<Integer> openIndices = new Stack<>();
        int n = s.length();
        int[] pair = new int[n];
        for(int i = 0 ; i < n; i++){
            if(s.charAt(i) == '('){
                openIndices.push(i);
            }
            if(s.charAt(i) == ')'){
                int j = openIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int currIdx = 0, dir = 1; currIdx < n; currIdx+=dir){
            if(s.charAt(currIdx) == '(' || s.charAt(currIdx) == ')'){
                currIdx = pair[currIdx];
                dir = -dir;
            }else{
                sb.append(s.charAt(currIdx));
            }
        }
        return sb.toString();
    }
}