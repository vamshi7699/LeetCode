/**************************************************************************************************************************************************************
Using map
Keep track of what is already visited and check if the difference of current element and the target is already visited. This means the current element and the visited element sum up to the target.
****************************************************************************************************************************************************************/

class Solution {
    public int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            if(map.containsKey(target-a[i])){
                return new int[]{map.get(target-a[i]), i};
            }
            map.put(a[i], i);
        }
        return new int[2];
    }
}


/**************************************************************************************************************************************************************
TWO POINTER
When the array is sorted
Say we are at the first and last positions
If the sum of those elements is the target then then return result.

If the sum is less than target, then we know the sum of the selected elements increases if we move the left pointer right bcoz the array is sorted and the values increase
   else move the right pointer left as the elements decrease here
****************************************************************************************************************************************************************/

class Solution {
    public int[] twoSum(int[] a, int target) {
        int i=0, j=a.length-1;
        while(true){
            if(a[i]+a[j]>target){
                j--;
            } else if(a[i]+a[j]<target){
                i++;
                j = j + (j+1<a.length ? 1 : 0);
            } else{
                break;
            }
        }
        return new int[]{i+1,j+1};
    }
}
