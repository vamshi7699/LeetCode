class Solution {
    int[][] dirs = new int[][] {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
    public int shortestPathBinaryMatrix(int[][] a) {
        // if 0,0 is 1, nothing to start with
        if(a[0][0]==1){
            return -1;
        }
        int n = a.length;
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        vis[0][0]=true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            // we reach the end first with the min value itself
            // at every point we add all the neighbours to the queue
            //      0 -> 1
            //      |--- 2
            // consider we are at first 0
            // we add 1, 2 with length 1
            // next we go to 1, since 2 is already visited we dont go there again
            // at 2 we have the min cost path
            // same for all nodes
            if(curr[0]==n-1 && curr[1]==n-1){
                return 1 + curr[2];
            }
            
            // add all valid neighbours
            for(int[] dir: dirs){
                int x = curr[0] + dir[0];
                int y = curr[1] + dir[1];
                if(x>=0 && y>=0 && x<n && y<n && a[x][y] == 0 && !vis[x][y]){
                    vis[x][y] = true;
                    q.add(new int[]{x, y, curr[2]+1});
                }
            }
        }
        return -1;
    }
}
