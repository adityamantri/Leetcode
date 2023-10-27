class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; row++){
            
            for(int col = 0; col < grid[0].length; col++){
                if(row == 0 && col == 0) continue;
                if(row == 0) grid[row][col] += grid[row][col-1];
                else if(col == 0) grid[row][col] += grid[row-1][col];
                else{
                    grid[row][col] = Math.min(grid[row-1][col], grid[row][col-1]) + grid[row][col];
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}