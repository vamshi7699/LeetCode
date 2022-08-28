/*
    Once a larger element is found, we can consider this the window maximum until its removed
        so we can safely eliminate all the smaller elements that have been in the queue
        
    Whenever we are sliding the window, we can check if the element being removed is the maximum i.e, the top of the queue
        in which case we can just delete the queue top
*/
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> max = new ArrayDeque<>();
        int[] res = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            // push the found large element to the front and remove smaller values
            while(!max.isEmpty() && max.peekLast() < nums[i]){
                max.pollLast();
            }
            max.add(nums[i]);
        }
        int j=0;
        for(int i=k;i<nums.length;i++, j++){
            res[j] = max.peek();
            // if window removed element is same as max element, remove it
            if(max.peek() == nums[i-k]){
                max.poll();
            }
            // push the found large element to the front and remove smaller values
            while(!max.isEmpty() && max.peekLast() < nums[i]){
                max.pollLast();
            }
            max.add(nums[i]);
        }
        res[j] = max.peek();
        return res;
    }
}
