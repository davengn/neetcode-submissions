class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length -1;
        int scanRow = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int last = matrix[mid].length - 1;
            if (matrix[mid][0] <= target && matrix[mid][last] >= target) {
                scanRow = mid;
                break;
            }else if(matrix[mid][last] > target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        if(scanRow == -1){
            return false;
        }
        left = 0;
        right = matrix[scanRow].length -1;
        while(left <=right){
            int mid = left + (right - left )/2;
            if(matrix[scanRow][mid] == target){
                return true;
            }else if(matrix[scanRow][mid] > target){
                right = mid -1;
            }else{
                left = mid +1;
            }
        }
        return false;
    }
}
