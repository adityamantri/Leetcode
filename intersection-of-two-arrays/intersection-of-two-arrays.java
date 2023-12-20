class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> res = new HashSet<>();
        int p1 = 0, p2 = 0;
        while(p1 < nums1.length && p2 < nums2.length){
            int v1 = nums1[p1], v2 = nums2[p2];
            if(v1 == v2){
                res.add(v1);
                p1++;
            }else if(v1 < v2){
                p1++;
            }else if(v1 > v2){
                p2++;
            }
        }
        return res.stream().mapToInt(Number::intValue).toArray();
    }
}