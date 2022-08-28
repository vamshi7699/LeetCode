// 597 ms (31ms) ########################### DFS
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return findTargetSumWays(nums, 0, target);
    }
    
    public int findTargetSumWays(int[] nums, int i, int target) {
        if(i >= nums.length){
            return target == 0 ? 1 : 0;
        }
        
        return findTargetSumWays(nums, i+1, target + nums[i]) + findTargetSumWays(nums, i+1, target - nums[i]);
    }
}
