class Solution {
    public String ones(int n){
        switch(n){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }

    public String twoLessThan20(int num) {
        switch(num) {
        case 10: return "Ten";
        case 11: return "Eleven";
        case 12: return "Twelve";
        case 13: return "Thirteen";
        case 14: return "Fourteen";
        case 15: return "Fifteen";
        case 16: return "Sixteen";
        case 17: return "Seventeen";
        case 18: return "Eighteen";
        case 19: return "Nineteen";
        }
        return "";
    }

    public String tens(int n){
        switch(n){
            case 1: return "Ten";
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }

    public String three(int n){
        StringBuilder sb = new StringBuilder();
        int hundred = n/100;
        int rest = n - 100*hundred; // 10s
        if(hundred != 0) {
            sb.append(ones(hundred)+" Hundred");
        }
        if(rest != 0) {
            if(!sb.isEmpty()) sb.append(" ");
            int ten = (n - 100*hundred)/10;
            if(ten == 0){
                sb.append(ones(rest));
            }else if(ten == 1){
                sb.append(twoLessThan20(rest));
            }else{
                sb.append(tens(ten));
                if(rest %10 != 0){
                    sb.append(" "+ ones(rest%10));
                }
            }
        }
        return sb.toString();
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder res = new StringBuilder();

        int billions = num/1_000_000_000;
        int millions = (num - billions*1_000_000_000)/1_000_000;
        int thousands = (num - billions*1_000_000_000 - millions*1_000_000)/1000;
        int remaining = (num - billions*1_000_000_000 - millions*1_000_000 - thousands*1000);

        helper(billions, " Billion", res);
        helper(millions, " Million", res);
        helper(thousands, " Thousand", res);

        if(remaining != 0){
            if(!res.isEmpty()) res.append(" ");
            res.append(three(remaining));
        }
        return res.toString();
    }

    public void helper(int n, String value, StringBuilder res){
        if(n == 0) return;
        if(!res.isEmpty()) res.append(" ");
        res.append(three(n));
        res.append(value);
    }
}