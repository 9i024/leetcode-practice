class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;
            if(target > matrix[mid][matrix[0].length-1]) left = mid + 1;
            else right = mid;
        }

        int row = left;
        int colLeft = 0;
        int colRight = matrix[0].length - 1;
        while(colLeft <= colRight ){
            int colMid = colLeft + (colRight - colLeft) / 2;
            if(target > matrix[row][colMid]) colLeft = colMid + 1;
            else if(target < matrix[row][colMid]) colRight = colMid - 1;
            else return true;
        }


        return false;
    }
}
