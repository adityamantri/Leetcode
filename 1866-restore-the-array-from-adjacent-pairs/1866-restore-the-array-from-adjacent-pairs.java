class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1;
        int[] result = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        // we use set to get the two corner elements
        Set<Integer> set = new HashSet<>();
        for(int[] pair : adjacentPairs){
            int u = pair[0], v = pair[1];
            map.putIfAbsent(u, new ArrayList<>());
            map.putIfAbsent(v, new ArrayList<>());
            map.get(u).add(v);
            map.get(v).add(u);
            // we add nums in set, but if the num is already present we remove it.
            // Every corner element is present only once in the adjacentPairs array.
            if(!set.add(u)){
                set.remove(u);
            }
            if(!set.add(v)){
                set.remove(v);
            }
        }
        int num = 0; // dummy value
        // To start by corner element, get an element from set
        for(int i : set){
            num = i;
            break;
        }
        int idx = 0; // idx of result array
        Set<Integer> used = new HashSet<>(); // keep track of used elements
        
        while(used.size() != n){
            result[idx++] = num;
            used.add(num);
            for(int i : map.get(num)){
                if(!used.contains(i))
                    num = i;
            }
        }
        return result;
    }
}