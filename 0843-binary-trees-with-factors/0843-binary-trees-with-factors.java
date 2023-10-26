class Solution {
    private static int MOD = (int)(1e9 + 7);
    public int numFactoredBinaryTrees(int[] arr) {
        Map<Integer, Long> subtreeCount = new HashMap<>();
        Arrays.sort(arr);

        for(int root : arr){
            subtreeCount.put(root, 1L);
            for(int factor : arr){
                if(factor >= root) break;

                if(root % factor == 0 && subtreeCount.containsKey(root/factor)){
                    subtreeCount.put(root, subtreeCount.get(root) + subtreeCount.get(root/factor) * subtreeCount.get(factor));
                }
            }
        }
        long total = 0L;
        for(long val : subtreeCount.values()){
            total  = (total+val)%MOD;
        }
        return (int)total;
    }
}