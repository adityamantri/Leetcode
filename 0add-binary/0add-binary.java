class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int m = a.length() - 1, n = b.length()-1;
        int carry = 0;
        while(m >= 0 || n >= 0 || carry != 0){
            int i = m>=0 ? a.charAt(m)-'0' : 0;
            int j = n>=0 ? b.charAt(n)-'0' : 0;
            int sum = i + j + carry;
            carry = sum / 2;
            sb.append(sum%2);
            m--; n--;
        }
        return sb.reverse().toString();
    }
}