class Solution {
    public List<List<Integer>> combinationSum(int[] a, int target) {
        // set for unique list
        Set<List<Integer>> res = new HashSet<>();
        Arrays.sort(a);
        combinationSum(a, 0, res, new ArrayList<Integer>(), 0, target);
        return new ArrayList<>(res);
    }
    
    public void combinationSum(int[] a, int i, Set<List<Integer>> res, List<Integer> t, int sum, int target){
        if(sum == target){
            res.add(new ArrayList<>(t));
            return;
        }   
        if(sum>target || i>=a.length){
            return;
        }
        
        // include the element
        t.add(a[i]);
        combinationSum(a, i, res, t, sum+a[i], target);
        t.remove(t.size()-1);
        
        // exclude the element
        combinationSum(a, i+1, res, t, sum, target);
    }
}
