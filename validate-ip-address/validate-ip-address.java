class Solution {
    public String validIPAddress(String queryIP) {
        String[] arr = queryIP.split("\\.", -1);
        if(arr.length == 4){
            for(String s : arr){
                if(s.isEmpty() || s.length() > 3) return "Neither";
                if(s.charAt(0) == '0' && s.length() > 1) return "Neither";
                for(char c : s.toCharArray())
                    if(!Character.isDigit(c)) return "Neither";
                if(Integer.parseInt(s) > 255) return "Neither";
            }
            return "IPv4";
        }
        arr = queryIP.split(":", -1);
        if(arr.length != 8) return "Neither";
        String hex = "1234567890abcdefABCDEF";
        for(String s : arr){
            if(s.length() > 4 || s.isEmpty()) return "Neither";
            for(char c : s.toCharArray()){
                if(hex.indexOf(c) == -1) return "Neither"; 
            }
        }
        return "IPv6";
    }
}