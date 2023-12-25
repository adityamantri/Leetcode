class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        st.push(-1);
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(i);
            }else{
                st.pop();
                // add to stack the current element for calculations
                if(st.isEmpty()){
                    st.push(i);
                }
                ans = Math.max(ans, i - st.peek());
            }
        }
        return ans;
    }
}