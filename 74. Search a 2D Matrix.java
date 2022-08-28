class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int l=0, h = matrix.length-1, mid=0, m = matrix[0].length-1;
        while(l<=h){
            mid = (l+h)/2;
            if(target >= matrix[mid][0] && target<=matrix[mid][m]){
                break;
            }
            
            if(target<matrix[mid][0]){
                h=mid-1;
            } else{
                l=mid+1;
            }
        }
        return Arrays.binarySearch(matrix[mid], target) >= 0;
    }
}
