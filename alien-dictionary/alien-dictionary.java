class Solution {
    Map<Character, List<Character>> revAdjList = new HashMap<>();
    Map<Character, Boolean> seen = new HashMap<>();
    StringBuilder output = new StringBuilder();
    public String alienOrder(String[] words) {
        Set<Integer> set = new HashSet<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                revAdjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        for(int i = 0; i < words.length-1; i++){
            String word1 = words[i], word2 = words[i+1];
            // check prefix
            if(word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            
            for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
                // create relation of directed edges like r -> t
                if(word1.charAt(j) != word2.charAt(j)){
                    revAdjList.get(word2.charAt(j)).add(word1.charAt(j));
                    break;
                }
            }
        }

        // DFS
        for(char c : revAdjList.keySet()){
            if(!dfs(c)) return "";
        }
        return output.toString();
    }
    
    private boolean dfs(Character c){
        if(seen.containsKey(c)) return seen.get(c); // cycle was detected if already visited
        seen.put(c, false); // graph coloring algorithm to detect cycle PART 1 
        for(Character next : revAdjList.get(c)){
            boolean result = dfs(next);
            if(!result) return false;
        }
        seen.put(c, true); // graph coloring algorithm to detect cycle PART 2
        output.append(c);
        return true;
    }
}

/**
["wrt","wrf","er","ett","rftt"]
wrt

t -> f
w -> e -> r -> t -> f
 */