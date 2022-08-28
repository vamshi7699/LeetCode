// Find the kth element from 2 sorted arrays

class Solution {
    public double findMedianSortedArrays(int[] a1, int[] a2) {
        int n1 = a1.length, n2 = a2.length;
        // always process second array as bigger array
        // just for easy of computation
        if(n1>n2){
            return findMedianSortedArrays(a2, a1);
        }
        
        // find the elements that need to be on the left half
        // for odd, left is median 
        // for even add the right part also
        int k = (n1+n2+1)>>1;
        
        // if k is greater than the second array (large array), then we would need atleast k-n2 elements from the first array
        // so why we need to check from 0 and handle special cases
        // directly check from k-n2
        int low = Math.max(0, k-n2);
        
        // if k is less than n1, then we cannot include n1 elements in resultant array
        // we can at max only include k elements from arr1, so take make min of n1, k
        int high = Math.min(n1, k);
        
        
        int mid1, mid2, left1=0, left2=0, right1=0, right2=0;
        while(low<=high){
            mid1 = (low + high) >> 1;
            mid2 = k - mid1;
            
            // if the first mid is 0, there is no left part. So assign it to MIN_VAL so that the final condition is not broken
            left1 = mid1==0 ? Integer.MIN_VALUE : a1[mid1-1];
            left2 = mid2==0 ? Integer.MIN_VALUE : a2[mid2-1];
            
            // same as above, not to break
            right1 = mid1==n1 ? Integer.MAX_VALUE : a1[mid1];
            right2 = mid2==n2 ? Integer.MAX_VALUE : a2[mid2];
            
            // for the division to be correct all left values should be less than the right values
            // already left1<=right1 and left2<=right2
            //      so check for remaining
            if(left1<=right2 && left2<=right1){
                break;
            // if left1 is greater, that means larger elements are included into the left division. So try to move the division to left 
            } else if(left1>right2){
                high = mid1-1;
            // else move to right
            } else {
                low = mid1+1;
            }
        }
        
        double median = 0;
        median += Math.max(left1, left2);
        if((n1+n2)%2==0){
            median+=Math.min(right1, right2);
            median = median/2;
        }
        return median;
    }
}
