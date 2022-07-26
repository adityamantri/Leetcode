class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> dg = new ArrayList<>();
        for(int i = 0 ; i < numCourses; i++){
            dg.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            dg.get(pre[0]).add(pre[1]);
        }
        boolean[] visited = new boolean[numCourses];  
boolean[] memo = new boolean[numCourses];  
        for(int i = 0; i < numCourses; i++){

            // if(!visited[i]){
                          
                if(!dfs(visited, dg, i, memo)) return false;
            memo[i] = true;
            // }
        }
        return true;
    }
    
    public boolean dfs(boolean[] visited, List<List<Integer>> dg, int i, boolean[] memo){
        if(visited[i]) return false;
        visited[i] = true;
        for(int j: dg.get(i)){
            if(memo[j]) continue;
            if(!dfs(visited, dg, j, memo)){
                return false;
            }
        }
        
        visited[i] = false;
        
        return true;
    }
    
    
}