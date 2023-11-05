class Solution {

    public long dfs(int i, List<Integer>[] adj, int[] values, boolean[] visited){
        if(adj[i].size() == 1 && i != 0)
            return (long)values[i];
        
        long sum = 0;
        visited[i] = true;
        for(int j : adj[i]){
            if(visited[j])
                continue;
            // sum of all sub nodes
            sum += dfs(j, adj, values, visited);
        }
        return Math.min((long) values[i], sum);
    }
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        long sum = Arrays.stream(values).asLongStream().sum();
        boolean[] visited = new boolean[n];
        long k = dfs(0, adj, values, visited);
        return sum - k;
    }
}