// 3ms (28%) ###################################### Using 2 pointer moving window sum
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // maintain the window pointer
        int i = 0, j = 0;
        int n = nums.length;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while(i<n) {
            // if the sum meets the requirement, then check if the window has the minimum length
            if(sum>=target) {
                minLength = Math.min(minLength, j-i);
                // move the window further
                sum -= nums[i];
                i++;
            } else if(j<n) {
                // if the window end is less than the array, then add the value into window
                sum += nums[j];
                j++;
            } else {
            // nothing to add into the window
                break;
            }
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
