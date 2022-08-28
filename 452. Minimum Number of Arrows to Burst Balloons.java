/*
Overlapping Intervals
    Meerting Rooms


Say the array is sorted by Xend.
If we shoot arrow at Xend, there is a more chance that we would hit another balloon that falls in the range XstartOther <= XendCurr <=XendOther
Then the other balloon is also bursts if we hit here

So, sort by Xend, hit at Xends and skip all that fall in above range
*/
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (x,y)->{return x[1]-y[1];});
        int res = 0;
        int i=0, j=0;
        int n = points.length;
        
        while(i<n){
            res++;
            j=i+1;
            while(j<n && points[i][1]>=points[j][0] && points[j][1]>=points[i][1]){
                j++;
            }
            i=j;
        }
        
        return res;
    }
}
