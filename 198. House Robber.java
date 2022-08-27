//0ms (100%)#################################################### DP Better from Below
class Solution {
    
    public int rob(int[] nums) {
        int n = nums.length;
        
        // can only rob the one that is existing
        if(n==1){
            return nums[0];
        }
        
        int[] dp = new int[n];
        
        // if we are at the last house we can only rob that
        dp[n-1] = nums[n-1];
        // and at second last, we can only rob this. Last will be adjacent and cannot rob
        dp[n-2] = nums[n-2];
        
        for(int i = n-3;i>=0;i--){
            // for every ther position, we cannot rob the adjacent but anything after
            // we want to get the maximum profit
            //
            // we are coming from back and at each iteration we calculate and keep the max
            // consider the current position is started and next position cannot be selected
            //      so i+2, would be like the starting position
            //      and i+3 would be the next
            //   similar to the final calculation we can start from 0 or 1, so take max of both
            int max = dp[i+2];
            if(i+3<n){
                max = Math.max(dp[i+3], max);
            }
            dp[i] = nums[i] + max;
        }
        
        // We can start from first position or skip and start from second
        // so take the max from either
        return Math.max(dp[0], dp[1]);
    }

}



//1ms (20%)#################################################### DP Iterative
// class Solution {
    
//     public int rob(int[] nums) {
//         int n = nums.length;
        
//         // can only rob the one that is existing
//         if(n==1){
//             return nums[0];
//         }
        
//         int[] dp = new int[n];
        
//         // if we are at the last house we can only rob that
//         dp[n-1] = nums[n-1];
//         // and at second last, we can only rob this. Last will be adjacent and cannot rob
//         dp[n-2] = nums[n-2];
        
//         for(int i = n-3;i>=0;i--){
//             // for every ther position, we cannot rob the adjacent but anything after
//             // we want to get the maximum profit, so search for the max
//             int max = dp[i+2];
//             for(int j=i+3;j<n;j++){
//                 max = Math.max(dp[j], max);
//             }
//             dp[i] = nums[i] + max;
//         }
        
//         // We can start from first position or skip and start from second
//         // so take the max from either
//         return Math.max(dp[0], dp[1]);
//     }

// }


//TLE#################################################### RECURSIVE SOLUTION
// class Solution {
//     public int rob(int[] nums) {
//         return rob(nums, 0, 0);
//     }
    
//     public int rob(int[] nums, int i, int sum){
//         if(i >= nums.length){
//             return sum;
//         }
        
//         return Math.max(rob(nums, i+1, sum), rob(nums, i+2, sum + nums[i]));
//     }
// }
