class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case '{':
                    stack.offerLast('}');
                    break;
                case '[':
                    stack.offerLast(']');
                    break;
                case '(':
                    stack.offerLast(')');
                    break;
                case '}' : case ']' : case ')':
                    if(stack.isEmpty() || stack.pollLast() != s.charAt(i))
                        return false;
                    break;
                default: return false;
            }
        }
        return stack.isEmpty();
    }
}