class Solution {
    public void rotate(int[][] matrix) {
        
        int len = matrix.length-1;
        int rowCount = 0, colCount = 0;
        
        for(int i = 0; i < (matrix.length+1)/2; i++){
            for(int j = 0; j < matrix[0].length/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len -j][i];
                matrix[len -j][i] = matrix[len-i][len-j];
                matrix[len-i][len-j] = matrix[j][len-i];
                matrix[j][len-i] = temp;
            }
        }
    }
}