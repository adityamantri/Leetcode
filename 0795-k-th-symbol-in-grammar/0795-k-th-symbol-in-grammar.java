class Solution {
    public int kthGrammar(int n, int k) {
        if(n == 1) return 0;

        int halfElements = (int)Math.pow(2, n-2);
        // int halfElements = totalElements/2;
        if(k > halfElements){
            return 1 - kthGrammar(n, k-halfElements);
        }
        return kthGrammar(n-1, k);

        // StringBuilder val = new StringBuilder();
        // val.append("0");
        // if(n==0) return 0;

        // for(int i = 1; i < n; i++){
        //     StringBuilder sb = new StringBuilder();
        //     for (int j = 0; j < val.length(); i++){
        //         char c = val.charAt(j);
        //         if(c == '1'){
        //             sb.append("10");
        //         }else{
        //             sb.append("01");
        //         }
        //     }
        //     val = new StringBuilder(sb);
        // // System.out.println(val.toString());
        // }
        // // for(int i = 0; i < val.length(); i++){
        // //     sb.charAt()
        // // }
        // return Integer.parseInt(val.charAt(k-1)+"");
    }
}