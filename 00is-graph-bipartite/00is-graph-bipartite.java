class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < graph.length; i++){
            if(visited[i] == 0){
                visited[i] = 1;
                q.offer(i);
                if(!bfs(q, visited, graph)) return false;
            }
        }
        return true;
    }

    public boolean bfs(Queue<Integer> q, int[] visited, int[][] graph){
        while(!q.isEmpty()){
            int node = q.poll();
            int[] neigh = graph[node];
            for(int n : neigh){
                if(visited[n] == 0){
                    visited[n] = -1 * visited[node];
                    q.offer(n);
                }else if(visited[n] == visited[node]){
                    return false;
                }
            }
        }
        return true;
    }
}