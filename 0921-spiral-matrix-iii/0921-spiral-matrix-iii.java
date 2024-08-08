class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int dirs[][] = {{0,1}, {1,0}, {0,-1},{-1,0}}; // east, south, west, north
        int[][] mat = new int[rows*cols][2];
        int num = 0;
        mat[0] = new int[]{rStart, cStart};
        num++;
        int len = 0, d = 0; 
        while(num < rows*cols){
            if(d == 0 || d == 2) len++; // when east or west increase length
            for(int i = 0; i < len; i++){
                rStart += dirs[d][0];
                cStart += dirs[d][1];
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                    mat[num++] = new int[]{rStart, cStart};
                }
            }
            d = (d + 1) % 4;
        }
        return mat;
    }
}