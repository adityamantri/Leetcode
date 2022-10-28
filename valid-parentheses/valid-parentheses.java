class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for(char c : s.toCharArray()){
            switch(c) {
                case('}'):
                    if(stack.size() == 0 ||  stack.pollFirst() != '{') return false;
                    break;
                case(']'):
                    if(stack.size() == 0 || stack.pollFirst() != '[') return false;
                    break;
                case(')'):
                    if(stack.size() == 0 || stack.pollFirst() != '(') return false;
                    break;
                default:
                    stack.offerFirst(c);
            }
        }
        return stack.size() == 0;
    }
}