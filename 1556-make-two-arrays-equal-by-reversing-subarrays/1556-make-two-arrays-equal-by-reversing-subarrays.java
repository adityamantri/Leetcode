class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : target){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i : arr){
            if(!map.containsKey(i) || map.get(i) == 0) return false;
            map.put(i, map.get(i) - 1);
            if(map.get(i) == 0) map.remove(i);
        }
        return map.isEmpty();
    }
}