class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        int span = matrix[0].length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (target <= matrix[mid][span] && target >= matrix[mid][0]) {
                int left = 0;
                int right = span;
                while (left <= right) {
                    int tmpMid = (left + right) / 2;
                    if (matrix[mid][tmpMid] == target) {
                        return true;
                    } else if (target > matrix[mid][tmpMid]) {
                        left = tmpMid + 1;
                    } else {
                        right = tmpMid - 1;
                    }
                }
                return false;
            } else if (target > matrix[mid][span]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
