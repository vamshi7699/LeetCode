/**
    Checking for each node is time critical i.e, check if each node can reach pacific and atlantic
    
    We are node the edge nodes join atleast either of pacific or atlantic
    
    So we can search from the edge nodes and mark if each node can reach the oceans.
*/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Flow[][] flow = new Flow[heights.length][heights[0].length];
        
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                flow[i][j] = new Flow();
            }
        }
        
        // top and bottom nodes
        for(int j=0;j<heights[0].length;j++){
            dfs(heights, flow, 0, j, -1, true, false);
            dfs(heights, flow, heights.length-1, j, -1, false, true);
        }
        
        // left and right nodes
        for(int i=0;i<heights.length;i++){
            dfs(heights, flow, i, 0, -1, true, false);
            dfs(heights, flow, i, heights[0].length-1, -1, false, true);
        }
        
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(flow[i][j].pacific && flow[i][j].atlantic){
                    res.add(Arrays.asList(new Integer[]{i,j}));
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int[][] h, Flow[][] flow, int i, int j, int prev, boolean pacific, boolean atlantic){
        if(i<0 || i>=h.length || j<0 || j>=h[0].length || h[i][j] == -1 || h[i][j] < prev) {
            return;
        }
        
        // if a node has already been reached from an ocean then the entire flow has already been covered and need not search again
        // pacific and atlantic booleans just for ease of methods, only one method for 2 oceans
        if((pacific && flow[i][j].pacific) || (atlantic && flow[i][j].atlantic)){
            return;
        }
        
        flow[i][j].pacific = flow[i][j].pacific || pacific;
        flow[i][j].atlantic = flow[i][j].atlantic || atlantic;
        
        int temp = h[i][j];
        // to avoid back recursion. If -1 we can just return and recurse again
        h[i][j] = -1;
        
        dfs(h, flow, i+1, j, temp, pacific, atlantic);
        dfs(h, flow, i-1, j, temp, pacific, atlantic);
        dfs(h, flow, i, j+1, temp, pacific, atlantic);
        dfs(h, flow, i, j-1, temp, pacific, atlantic);
        
        // restore actual value
        h[i][j] = temp;
    }
    
    
    class Flow {
        public boolean pacific = false;
        public boolean atlantic = false;
    }
}
