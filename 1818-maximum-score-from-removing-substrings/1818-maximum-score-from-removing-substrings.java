class Solution {
    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = x > y ? "ba" : "ab";
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == highPriorityPair.charAt(1) && !st.isEmpty() && st.peek() == highPriorityPair.charAt(0)){
                st.pop();
                totalScore += Math.max(x, y);
            }else{
                st.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0, st.pop());
        }
        s = sb.toString();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == lowPriorityPair.charAt(1) && !st.isEmpty() && st.peek() == lowPriorityPair.charAt(0)){
                st.pop();
                totalScore += Math.min(x, y);
            }else{
                st.push(c);
            }
        }
        return totalScore;
    }
}