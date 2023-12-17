class Solution {
    public String addBinary(String a, String b) {
        int m = a.length()-1, n = b.length()-1;
        if(n > m) return addBinary(b, a);
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(m >= 0){
            int y = (n < 0) ? 0 : b.charAt(n--) - '0';
            int x = a.charAt(m--) - '0';
            sb.append((x+y+carry)%2);
            carry = (x+y+carry) / 2;
        }
        if(carry == 1) sb.append(carry);
        if(sb.isEmpty()) return "0";
        return sb.reverse().toString();
    }
}