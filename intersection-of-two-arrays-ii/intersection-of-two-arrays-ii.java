class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        if(nums1.length < nums2.length){
            return intersect(nums2, nums1);
        }
        for(int i = 0; i < nums2.length; i++){
            map.put(nums2[i], map.getOrDefault(nums2[i], 0)+1);
        }
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i]) && map.get(nums1[i]) > 0){
                map.put(nums1[i], map.get(nums1[i]) - 1);
                list.add(nums1[i]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}