class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long z1 = 0, z2 = 0, sum1 = 0, sum2 = 0;
        for(int i: nums1){
            if(i == 0) z1++;
            sum1 += i;
        }
        for(int i: nums2){
            if(i == 0) z2++;
            sum2 += i;
        }
        
        // if(sum1 == sum2 && (z1 == 0 || z2 == 0)) return -1;
        sum1 += z1; sum2+=z2;
        if((z1 == 0 && sum1 < sum2) || (z2 == 0 && sum2 < sum1)) return -1;
        return Math.max(sum1, sum2);
        // if(sum1 < sum2){
        //     // z2 will have all 1s
        //     sum2 += z2;
        //     sum1+=z1;
        //     return  
        //     int res = z1;
        //     if(sum1 < sum2){
        //         return sum2 < 
        //     }
        // }
        
    }
}