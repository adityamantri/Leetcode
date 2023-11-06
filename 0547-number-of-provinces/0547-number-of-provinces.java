class Solution {

    public void dfs(int node, int[][] arr, boolean[] visit){
        visit[node] = true;
        for(int edge = 0; edge < arr[node].length; edge++){
            if(arr[node][edge] == 1 && !visit[edge])
                dfs(edge, arr, visit);
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] visit = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visit[i]){
                ans++;
                dfs(i, isConnected, visit);
            }
        }
        return ans;
    }
}