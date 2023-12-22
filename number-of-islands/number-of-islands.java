class Solution {

    int[][] dirs = {{0,1}, {0, -1}, {1,0}, {-1,0}};
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int island = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    bfs(grid, visited, i, j);
                    island++;
                }
            }
        }
        return island;
    }

    public void bfs(char[][] grid, boolean[][] visited, int i, int j){
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        
        while(!queue.isEmpty()){
            int[] coordinates = queue.poll();
            int x = coordinates[0], y = coordinates[1];
            for(int[] dir : dirs){
                int r = x+dir[0], c = y+dir[1];
                if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || visited[r][c] || grid[r][c] != '1') continue;
                queue.offer(new int[]{r, c});
                visited[r][c] = true;
            }
        }
    }
}
